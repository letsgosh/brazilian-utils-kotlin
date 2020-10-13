package br.com.lib.brazilian_utils_koltin

import br.com.lib.brazilian_utils_koltin.documents.DocumentJobUtil
import org.junit.Test
import kotlin.test.assertTrue

class DocumentJobUtilTest {

    @Test
    fun `verify is TituloEleitoral is valid`() {
        assertTrue { DocumentJobUtil.isValidTituloEleitoral("460368240191") }
        assertTrue { DocumentJobUtil.isValidTituloEleitoral("381588010973") }
        assertTrue { DocumentJobUtil.isValidTituloEleitoral("663773020442") }
        assertTrue { DocumentJobUtil.isValidTituloEleitoral("605202862399") }
        assertTrue { DocumentJobUtil.isValidTituloEleitoral("850035812631") }

    }


    @Test
    fun `verify is PIS is valid`() {
        assertTrue { DocumentJobUtil.isValidPIS("565.57247.17-4") }
        assertTrue { DocumentJobUtil.isValidPIS("808.28909.81-2") }
        assertTrue { DocumentJobUtil.isValidPIS("90697810700") }
        assertTrue { DocumentJobUtil.isValidPIS("26166331566") }
    }
}