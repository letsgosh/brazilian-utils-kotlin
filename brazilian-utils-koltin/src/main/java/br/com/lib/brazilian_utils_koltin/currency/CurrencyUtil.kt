package br.com.lib.brazilian_utils_koltin.currency

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

object CurrencyUtil {

    fun formatRealCurrency(value: Double)=
        NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
            .format(value)

    fun formatRealCurrency(value: BigDecimal)=
        NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
            .format(value)

    fun formatRealCurrency(value: Float)=
        NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
            .format(value)
}