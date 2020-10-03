package br.com.lib.brazilian_utils_koltin.documents.titulo

import br.com.lib.brazilian_utils_koltin.commons.DigitoPara
import java.util.regex.Pattern

object TituloEleitoralValidator {
    private var isFormatted = false

    fun getInvalidValues(tituloDeEleitor: String): Boolean {
        if (isFormatted && !FORMATED.matcher(tituloDeEleitor).matches()) {
            return false
        }
        var unformatedTitulo: String? = null
        unformatedTitulo = try {
            TituloEleitoralFormatter().unformat(tituloDeEleitor)
        } catch (e: IllegalArgumentException) {
            return false
        }
        if (unformatedTitulo?.length != 12 || !unformatedTitulo.matches(Regex("[0-9]*"))) {
            return false
        }
        if (hasCodigoDeEstadoInvalido(unformatedTitulo)) {
            return false
        } else {
            val tituloSemDigito = unformatedTitulo.substring(0, unformatedTitulo.length - 2)
            val digitos = unformatedTitulo.substring(unformatedTitulo.length - 2)
            val digitosCalculados = calculaDigitos(tituloSemDigito)
            if (digitos != digitosCalculados) {
                return false
            }
        }
        return true
    }

    private fun calculaDigitos(tituloSemDigito: String): String {
        val length = tituloSemDigito.length
        val sequencial = tituloSemDigito.substring(0, length - 2)
        val digito1: String? =
            DigitoPara(sequencial).complementarAoModulo().trocandoPorSeEncontrar("0", 10, 11)
                .mod(11).calcula()
        val codigoEstado = tituloSemDigito.substring(length - 2, length)
        val digito2: String? = DigitoPara(codigoEstado + digito1).complementarAoModulo()
            .trocandoPorSeEncontrar("0", 10, 11).mod(11).calcula()
        return digito1 + digito2
    }

    private fun hasCodigoDeEstadoInvalido(tituloDeEleitor: String?): Boolean {
        val codigo =
            tituloDeEleitor!!.substring(tituloDeEleitor.length - 4, tituloDeEleitor.length - 2)
                .toInt()
        return !(codigo in 1..28)
    }

        val FORMATED: Pattern = Pattern.compile("(\\d{10})/(\\d{2})")
        val UNFORMATED: Pattern = Pattern.compile("(\\d{10})(\\d{2})")
}