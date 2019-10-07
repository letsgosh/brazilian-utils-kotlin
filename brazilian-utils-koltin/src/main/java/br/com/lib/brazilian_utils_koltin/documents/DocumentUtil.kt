package br.com.lib.brazilian_utils_koltin.documents

import br.com.lib.brazilian_utils_koltin.extensions.removeCharacters

object DocumentUtil {

    // CPF
    private val weightSsn = intArrayOf(11, 10, 9, 8, 7, 6, 5, 4, 3, 2)

    // CNPJ
    private val weightTin = intArrayOf(6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)

    private fun calculate(str: String, weight: IntArray): Int {
        var sum = 0
        var i = str.length - 1
        var digit: Int
        while (i >= 0) {
            digit = Integer.parseInt(str.substring(i, i + 1))
            sum += digit * weight[weight.size - str.length + i]
            i--
        }
        sum = 11 - sum % 11
        return if (sum > 9) 0 else sum
    }

    fun isValidCpf(value: String?): Boolean {
        val cpf = value?.removeCharacters()
        if (cpf == null || cpf.length != 11 || cpf.matches((cpf[0] + "{11}").toRegex())) return false

        val digit1 = calculate(cpf.substring(0, 9), weightSsn)
        val digit2 = calculate(cpf.substring(0, 9) + digit1, weightSsn)
        return cpf == cpf.substring(0, 9) + digit1.toString() + digit2.toString()
    }

    fun isValidCNPJ(value: String?): Boolean {
        val cnpj = value?.removeCharacters()
        if (cnpj == null || cnpj.length != 14 || cnpj.matches((cnpj[0] + "{14}").toRegex())) return false

        val digit1 = calculate(cnpj.substring(0, 12), weightTin)
        val digit2 = calculate(cnpj.substring(0, 12) + digit1, weightTin)
        return cnpj == cnpj.substring(0, 12) + digit1.toString() + digit2.toString()
    }

}