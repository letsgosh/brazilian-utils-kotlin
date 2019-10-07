package br.com.lib.brazilian_utils_koltin

import br.com.lib.brazilian_utils_koltin.documents.DocumentUtil
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DocumentUtilTest {

    @Test
    fun `verify is CPF is valid`() {
       assertTrue { DocumentUtil.isValidCpf("028.194.240-40") }
       assertTrue { DocumentUtil.isValidCpf("75187482823") }
       assertTrue { DocumentUtil.isValidCpf("66604730506") }
       assertTrue { DocumentUtil.isValidCpf("29306435363") }
       assertTrue { DocumentUtil.isValidCpf("67675769309") }
       assertTrue { DocumentUtil.isValidCpf("27562366837") }
       assertTrue { DocumentUtil.isValidCpf("51226177590") }
    }

    @Test
    fun `verify is CNPJ is valid`() {
        assertTrue { DocumentUtil.isValidCNPJ("89453200000103") }
        assertTrue { DocumentUtil.isValidCNPJ("02771852000108") }
        assertTrue { DocumentUtil.isValidCNPJ("66406251000189") }
        assertTrue { DocumentUtil.isValidCNPJ("89453200000103") }
        assertTrue { DocumentUtil.isValidCNPJ("89453200000103") }
        assertTrue { DocumentUtil.isValidCNPJ("89453200000103") }
        assertTrue { DocumentUtil.isValidCNPJ("89453200000103") }
        assertTrue { DocumentUtil.isValidCNPJ("89453200000103") }
    }

    @Test
    fun `verify is not CPF is valid`() {
        assertFalse { DocumentUtil.isValidCpf("11111111111")  }
        assertFalse { DocumentUtil.isValidCpf("22222222222")  }
        assertFalse { DocumentUtil.isValidCpf("33333333333")  }
        assertFalse { DocumentUtil.isValidCpf("44444444444")  }
        assertFalse { DocumentUtil.isValidCpf("55555555555")  }
        assertFalse { DocumentUtil.isValidCpf("66666666666")  }
        assertFalse { DocumentUtil.isValidCpf("77777777777")  }
        assertFalse { DocumentUtil.isValidCpf("88888888888")  }
        assertFalse { DocumentUtil.isValidCpf("99999999999")  }
        assertFalse { DocumentUtil.isValidCpf("000000000000")  }
    }

    @Test
    fun `verify is not CNPJ is valid`() {
        assertFalse { DocumentUtil.isValidCNPJ("11111111111111")  }
        assertFalse { DocumentUtil.isValidCNPJ("22222222222222")  }
        assertFalse { DocumentUtil.isValidCNPJ("33333333333333")  }
        assertFalse { DocumentUtil.isValidCNPJ("44444444444444")  }
        assertFalse { DocumentUtil.isValidCNPJ("55555555555555")  }
        assertFalse { DocumentUtil.isValidCNPJ("66666666666666")  }
        assertFalse { DocumentUtil.isValidCNPJ("77777777777777")  }
        assertFalse { DocumentUtil.isValidCNPJ("88888888888888")  }
        assertFalse { DocumentUtil.isValidCNPJ("99999999999999")  }
        assertFalse { DocumentUtil.isValidCNPJ("00000000000000")  }
    }

}