package br.com.lib.brazilian_utils_koltin.documents

import br.com.lib.brazilian_utils_koltin.documents.TituloEleitoralValidator.getInvalidValues

object DocumentJobUtil {


    fun isValidTituloEleitoral(value: String): Boolean {
        return getInvalidValues(value)
    }

    fun isValidPIS(plPIS: String): Boolean {
        val lsMultiplicador = StringBuffer("3298765432")
        var liTotalizador = 0
        var liResto = 0
        var liMultiplicando = 0
        var liMultiplicador = 0
        var lbRetorno = true
        var liDigito = 99
        val lsAux: StringBuffer = StringBuffer().append(plPIS)
        val liTamanho = lsAux.length
        if (liTamanho != 11) {
            lbRetorno = false
        }
        if (lbRetorno) {
            for (i in 0..9) {
                liMultiplicando = lsAux.substring(i, i + 1).toInt()
                liMultiplicador = lsMultiplicador.substring(i, i + 1).toInt()
                liTotalizador += liMultiplicando * liMultiplicador
            }
            liResto = 11 - liTotalizador % 11
            liResto = if (liResto == 10 || liResto == 11) 0 else liResto
            liDigito = ("" + lsAux[10]).toInt()
            lbRetorno = liResto == liDigito
        }
        return lbRetorno
    }
}