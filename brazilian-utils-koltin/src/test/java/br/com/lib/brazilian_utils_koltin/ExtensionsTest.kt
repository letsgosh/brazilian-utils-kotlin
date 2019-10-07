package br.com.lib.brazilian_utils_koltin

import br.com.lib.brazilian_utils_koltin.extensions.removeCharacters
import org.junit.Test
import kotlin.test.assertEquals

class ExtensionsTest {

    @Test
    fun `remove characters the string`() {
        assertEquals("02819424040", "028.194.240-40".removeCharacters())
        assertEquals("89453200000103", "89.453.200/0001-03".removeCharacters())
    }
}