package br.com.lib.brazilian_utils_koltin

import br.com.lib.brazilian_utils_koltin.documents.DocumentUtil
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ZipCodeUtilTest {

    @Test
    fun `verify is ZipCode is valid`() {
        assertTrue { ZipCodeUtil.isValidZipCode("91060-530") }
        assertTrue { ZipCodeUtil.isValidZipCode("69900-520") }
        assertTrue { ZipCodeUtil.isValidZipCode("69009-700") }
        assertTrue { ZipCodeUtil.isValidZipCode("91060-530") }
    }

    @Test
    fun `verify is not ZipCode is valid`() {
        assertFalse { ZipCodeUtil.isValidZipCode("91060530") }
        assertFalse { ZipCodeUtil.isValidZipCode("69900520") }
        assertFalse { ZipCodeUtil.isValidZipCode("69009700") }
        assertFalse { ZipCodeUtil.isValidZipCode("91060530") }
    }
}