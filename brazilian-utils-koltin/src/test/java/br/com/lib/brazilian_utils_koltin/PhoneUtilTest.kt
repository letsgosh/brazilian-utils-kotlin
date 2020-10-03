package br.com.lib.brazilian_utils_koltin

import br.com.lib.brazilian_utils_koltin.phone.PhoneUtil
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PhoneUtilTest {

    @Test
    fun `verify is phone is valid`() {
        assertTrue { PhoneUtil.isValidPhone("+55 (11) 98888-8888") }
        assertTrue { PhoneUtil.isValidPhone("9999-9999") }
        assertTrue { PhoneUtil.isValidPhone("21 98888-8888") }
        assertTrue { PhoneUtil.isValidPhone("51 98316-0766") }
        assertTrue { PhoneUtil.isValidPhone("21 98888-8888") }
        assertTrue { PhoneUtil.isValidPhone("5511988888888") }
        assertTrue { PhoneUtil.isValidPhone("551198888-8888") }
        assertTrue { PhoneUtil.isValidPhone("3333-3333") }
        assertTrue { PhoneUtil.isValidPhone("55 51 33333333") }
    }

    @Test
    fun `verify is not phone is valid`() {
        assertFalse { PhoneUtil.isValidPhone("55 1 98888-8888") }
        assertFalse { PhoneUtil.isValidPhone(" 1 98888-8888") }
        assertFalse { PhoneUtil.isValidPhone("55 122 98888-8888") }
        assertFalse { PhoneUtil.isValidPhone("555 (121) 9888-8888") }
        assertFalse { PhoneUtil.isValidPhone("") }
        assertFalse { PhoneUtil.isValidPhone("33333-333") }
        assertFalse { PhoneUtil.isValidPhone("9333-333") }
        assertFalse { PhoneUtil.isValidPhone("9333333") }
        assertFalse { PhoneUtil.isValidPhone("55 51 9333333") }
    }
}