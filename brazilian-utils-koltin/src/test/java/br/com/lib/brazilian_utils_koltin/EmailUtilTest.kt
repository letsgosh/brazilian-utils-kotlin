package br.com.lib.brazilian_utils_koltin

import br.com.lib.brazilian_utils_koltin.email.EmailUtil
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class EmailUtilTest {

    @Test
    fun `verify is email is valid`() {
        assertTrue { EmailUtil.isValidateEmail("adsda@gmail.com") }
        assertTrue { EmailUtil.isValidateEmail("adsda@hotmail.com") }
        assertTrue { EmailUtil.isValidateEmail("adsda@123.com") }
        assertTrue { EmailUtil.isValidateEmail("a@gmail.com") }
        assertTrue { EmailUtil.isValidateEmail("123@gmail.com") }
        assertTrue { EmailUtil.isValidateEmail("adsda@hotmail.com.br") }
        assertTrue { EmailUtil.isValidateEmail("adsda@empresa.com.br") }
    }

    @Test
    fun `verify is email is not valid`() {
        assertFalse { EmailUtil.isValidateEmail("adsda@gmail") }
        assertFalse { EmailUtil.isValidateEmail("adsdagmail.com") }
        assertFalse { EmailUtil.isValidateEmail("adsda123.com") }
    }
}