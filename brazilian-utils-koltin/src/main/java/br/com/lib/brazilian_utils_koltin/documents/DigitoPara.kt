package br.com.lib.brazilian_utils_koltin.documents

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class DigitoPara(trecho: String) {
    private val numero: LinkedList<Int>
    private var multiplicadores: MutableList<Int> = ArrayList()
    private var complementar = false
    private var modulo = 0
    private var somarIndividual = false
    private val substituicoes: MutableMap<Int, String?>

    /**
     * Para multiplicadores (ou pesos) sequenciais e em ordem crescente, esse método permite
     * criar a lista de multiplicadores que será usada ciclicamente, caso o número base seja
     * maior do que a sequência de multiplicadores. Por padrão os multiplicadores são iniciados
     * de 2 a 9. No momento em que você inserir outro valor este default será sobrescrito.
     *
     * @param inicio Primeiro número do intervalo sequencial de multiplicadores
     * @param fim Último número do intervalo sequencial de multiplicadores
     * @return this
     */
    fun comMultiplicadoresDeAte(inicio: Int, fim: Int): DigitoPara {
        multiplicadores.clear()
        for (i in inicio..fim) {
            multiplicadores.add(i)
        }
        return this
    }

    /**
     * É comum que os geradores de dígito precisem do complementar do módulo em vez
     * do módulo em sí. Então, a chamada desse método habilita a flag que é usada
     * no método mod para decidir se o resultado devolvido é o módulo puro ou seu
     * complementar.
     *
     * @return this
     */
    fun complementarAoModulo(): DigitoPara {
        complementar = true
        return this
    }

    fun trocandoPorSeEncontrar(substituto: String?, vararg i: Int): DigitoPara {
        for (integer in i) {
            substituicoes[integer] = substituto
        }
        return this
    }

    /**
     * @param modulo Inteiro pelo qual o resto será tirado e também seu complementar.
     * O valor padrão é 11.
     *
     * @return this
     */
    fun mod(modulo: Int): DigitoPara {
        this.modulo = modulo
        return this
    }

    /**
     * Indica se ao calcular o módulo, se a soma dos resultados da multiplicação deve ser
     * considerado digito a dígito.
     *
     * Ex: 2 X 9 = 18, irá somar 9 (1 + 8) invés de 18 ao total.
     *
     * @return this
     */
    fun somandoIndividualmente(): DigitoPara {
        somarIndividual = true
        return this
    }

    /**
     * Faz a soma geral das multiplicações dos algarismos pelos multiplicadores, tira o
     * módulo e devolve seu complementar.
     *
     * @return String o dígito vindo do módulo com o número passado e configurações extra.
     */
    fun calcula(): String? {
        var soma = 0
        var multiplicadorDaVez = 0
        for (algarismo in numero) {
            val multiplicador = multiplicadores[multiplicadorDaVez]
            val total = algarismo * multiplicador
            soma += if (somarIndividual) somaDigitos(total) else total
            multiplicadorDaVez = proximoMultiplicador(multiplicadorDaVez)
        }
        var resultado = soma % modulo
        if (complementar) resultado = modulo - resultado
        return if (substituicoes.containsKey(resultado)) {
            substituicoes[resultado]
        } else resultado.toString()
    }

    /**
     * soma os dígitos do número (até 2)
     *
     * Ex: 18 => 9 (1+8), 12 => 3 (1+2)
     *
     * @param total
     * @return
     */
    private fun somaDigitos(total: Int): Int {
        return total / 10 + total % 10
    }

    /**
     * Devolve o próximo multiplicador a ser usado, isto é, a próxima posição da lista de
     * multiplicadores ou, se chegar ao fim da lista, a primeira posição, novamente.
     *
     * @param multiplicadorDaVez Essa é a posição do último multiplicador usado.
     * @return próximo multiplicador
     */
    private fun proximoMultiplicador(multiplicadorDaVez: Int): Int {
        var multiplicadorDaVez = multiplicadorDaVez
        multiplicadorDaVez++
        if (multiplicadorDaVez == multiplicadores.size) multiplicadorDaVez = 0
        return multiplicadorDaVez
    }

    /**
     * Adiciona um dígito no final do trecho numérico.
     *
     * @param digito É o dígito a ser adicionado.
     * @return this
     */
    fun addDigito(digito: String?): DigitoPara {
        numero.addFirst(Integer.valueOf(digito))
        return this
    }

    /**
     * Cria o objeto a ser preenchido com interface fluente e armazena o trecho numérico
     * em uma lista de algarismos. Isso é necessário porque a linha digitada pode ser
     * muito maior do que um int suporta.
     *
     * @param trecho Refere-se à linha numérica sobre a qual o dígito deve ser calculado
     */
    init {
        comMultiplicadoresDeAte(2, 9)
        mod(11)
        substituicoes = HashMap()
        numero = LinkedList<Int>()
        val digitos = trecho.toCharArray()
        for (digito in digitos) {
            numero.add(Character.getNumericValue(digito))
        }
        numero.reverse()
    }
}