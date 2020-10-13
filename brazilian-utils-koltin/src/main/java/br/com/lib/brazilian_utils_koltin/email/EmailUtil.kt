package br.com.lib.brazilian_utils_koltin.email

import java.util.regex.Pattern

object EmailUtil {

    private var EMAIL_ADDRESS = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    fun isValidateEmail(email: String)=
        EMAIL_ADDRESS.matcher(email).matches()
}