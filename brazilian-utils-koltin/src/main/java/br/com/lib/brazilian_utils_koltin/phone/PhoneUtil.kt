package br.com.lib.brazilian_utils_koltin.phone

object PhoneUtil {
    private val regexPhone = "^(?:(?:\\+|00)?(55)\\s?)?(?:\\(?([1-9][0-9])\\)?\\s?)?(?:((?:9\\d|[2-9])\\d{3})\\-?(\\d{4}))\$".toRegex()

    fun isValidPhone(phone: String?): Boolean {
        if (phone == null || !phone.matches(regexPhone)) return false
        return true
    }
}