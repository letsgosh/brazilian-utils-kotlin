package br.com.lib.brazilian_utils_koltin

import br.com.lib.brazilian_utils_koltin.payment.PaymentUtil
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PaymentUtilTest {

    @Test
    fun `verify is boleto is valid`() {
        assertTrue { PaymentUtil.isValidBoleto("00190000090114971860168524522114675860000102656") }
        assertTrue { PaymentUtil.isValidBoleto("0019000009 01149.718601 68524.522114 6 75860000102656") }

    }

    @Test
    fun `verify is boleto is not valid`() {
        assertFalse { PaymentUtil.isValidBoleto("") }
        assertFalse { PaymentUtil.isValidBoleto("0019fasdfds20114971860168524522114675860000102656") }
        assertFalse { PaymentUtil.isValidBoleto("00190000020114971860168524522114675860000102656") }
        assertFalse { PaymentUtil.isValidBoleto("00190000020114971860168524522") }
        assertFalse { PaymentUtil.isValidBoleto("00190000090114971860168524522114975860000102656") }

    }
}