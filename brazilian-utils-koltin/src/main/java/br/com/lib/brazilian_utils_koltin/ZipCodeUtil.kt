package br.com.lib.brazilian_utils_koltin

object ZipCodeUtil {

    // ZIPCODE
    private val regexZipCode = "\\d{5}[-]\\d{3}".toRegex()

    fun isValidZipCode(zipCode: String?): Boolean {
        if (zipCode == null || !zipCode.matches(regexZipCode)) return false
        return true
    }
}