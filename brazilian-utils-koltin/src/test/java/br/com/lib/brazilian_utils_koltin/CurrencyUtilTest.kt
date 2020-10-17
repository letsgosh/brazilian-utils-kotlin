package br.com.lib.brazilian_utils_koltin

import br.com.lib.brazilian_utils_koltin.currency.CurrencyUtil
import org.junit.Test
import java.math.BigDecimal
import kotlin.test.assertEquals

class CurrencyUtilTest {

    @Test
    fun `verify is currency is valid`() {
        assertEquals("R$ 1,00", CurrencyUtil.formatRealCurrency(1F))
        assertEquals("R$ 1,30", CurrencyUtil.formatRealCurrency(1.3F))
        assertEquals("R$ 10,00", CurrencyUtil.formatRealCurrency(10F))

        assertEquals("R$ 1,00", CurrencyUtil.formatRealCurrency(1.0))
        assertEquals("R$ 1,30", CurrencyUtil.formatRealCurrency(1.3))
        assertEquals("R$ 10,00", CurrencyUtil.formatRealCurrency(10.0))

        assertEquals("R$ 1,00", CurrencyUtil.formatRealCurrency(BigDecimal.valueOf(1.0)))
        assertEquals("R$ 1,30", CurrencyUtil.formatRealCurrency(BigDecimal.valueOf(1.3)))
        assertEquals("R$ 10,00", CurrencyUtil.formatRealCurrency(BigDecimal.valueOf(10.0)))
    }

}