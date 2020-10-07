package br.com.lib.brazilian_utils_koltin.payment

import br.com.lib.brazilian_utils_koltin.extensions.removeCharacters
import java.lang.Integer.parseInt

object PaymentUtil {

    private const val CHARACTER_LENGTH = 47
    private val CHECK_DIGIT_MOD_11_POSITION = 0..4
    private val MOD_10_WEIGHTS = arrayOf(2, 1)
    private val MOD_11_WEIGHTS = 2..9 + 1
    private val PARTIALS_TO_VERIFY_MOD_10 = arrayOf(
        0..9,
        10..20,
        21..31
    )
    private val DIGITABLE_LINE_TO_BOLETO_CONVERT_POSITIONS = arrayOf(
        0..4,
        4..9,
        10..20,
        21..31,
        32..47
    )

    fun isValidBoleto(value: String?): Boolean {
        val boleto = value.removeCharacters()
        if (!validCharacters(boleto = boleto)) return false
        if (!validateDigitableLinePartials(boleto!!)) return false
        val parseValue = parseDigitableLine(boleto)
        return module11CheckDigit(parseValue)
    }

    private fun module10(boleto: String): Int {
        val sum = boleto
            .split("")
            .reversed()
            .reduceIndexed { index, acc, digit ->
                val mult = parseInt(digit, 10) * MOD_10_WEIGHTS[index % 2]
                val add = if (mult > 9) 1 + (mult % 10) else mult
                return acc.toInt() + add
            }.toInt()

        val mod = sum % 10

        return if (mod > 0) 10 - mod else 0
    }

    private fun module11(boleto: String): Int {
        var weight = MOD_11_WEIGHTS.first

        val sum = boleto
            .split("")
            .reversed()
            .reduce { acc, digit ->
                val mult = parseInt(digit, 10) * weight
                weight = if (weight < MOD_11_WEIGHTS.last) weight + 1 else MOD_11_WEIGHTS.first

                return acc.toInt() + mult
            }.toInt()

        val mod = sum % 11
        return if (mod == 0 || mod == 1) 1 else 11 - mod

    }

    private fun module11CheckDigit(parseValue: String): Boolean {
        val mod = module11(
            parseValue.slice(CHECK_DIGIT_MOD_11_POSITION)
                    + parseValue.slice(CHECK_DIGIT_MOD_11_POSITION + 1)
        )

        return parseValue[CHECK_DIGIT_MOD_11_POSITION.last] == mod.toChar()
    }

    private fun parseDigitableLine(digitableLine: String) : String {
        var digitable = ""
        DIGITABLE_LINE_TO_BOLETO_CONVERT_POSITIONS.map {
            digitable += digitableLine.substring(it.first, it.last)
        }
        return digitable
    }

    private fun validateDigitableLinePartials(digitableLine: String): Boolean {
        return PARTIALS_TO_VERIFY_MOD_10.all { partial ->
            val mod = module10(digitableLine.substring(partial.first, partial.last))
            return digitableLine[partial.last] == digitableLine[mod]
        }
    }

    private fun validCharacters(boleto: String?): Boolean {
        return boleto?.length == CHARACTER_LENGTH
    }
}