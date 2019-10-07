package br.com.lib.brazilian_utils_koltin.extensions


fun String?.removeCharacters(): String? {
    return this?.replace("[-/.,()*]".toRegex(), "")
}