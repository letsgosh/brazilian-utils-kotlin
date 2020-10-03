package br.com.lib.brazilian_utils_koltin.commons

import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class BaseFormatter(
    formatted: Pattern,
    formattedReplacement: String,
    unformatted: Pattern,
    unformattedReplacement: String
) {
    private val formatted: Pattern
    private val formattedReplacement: String
    private val unformatted: Pattern
    private val unformattedReplacement: String
    @Throws(IllegalArgumentException::class)
    fun format(value: String?): String? {
        val result: String?
        requireNotNull(value) { "Value may not be null." }
        val matcher: Matcher = unformatted.matcher(value)
        result = matchAndReplace(matcher, formattedReplacement)
        return result
    }

    @Throws(IllegalArgumentException::class)
    fun unformat(value: String?): String? {
        val result: String?
        requireNotNull(value) { "Value may not be null." }
        val unformattedMatcher: Matcher = unformatted.matcher(value)
        if (unformattedMatcher.matches()) {
            return value
        }
        val matcher: Matcher = formatted.matcher(value)
        result = matchAndReplace(matcher, unformattedReplacement)
        return result
    }

    fun isFormatted(value: String?): Boolean {
        return formatted.matcher(value).matches()
    }

    fun canBeFormatted(value: String?): Boolean {
        return unformatted.matcher(value).matches()
    }

    private fun matchAndReplace(matcher: Matcher, replacement: String): String? {
        var result: String? = null
        result = if (matcher.matches()) {
            matcher.replaceAll(replacement)
        } else {
            throw IllegalArgumentException("Value is not properly formatted.")
        }
        return result
    }

    init {
        this.formatted = formatted
        this.formattedReplacement = formattedReplacement
        this.unformatted = unformatted
        this.unformattedReplacement = unformattedReplacement
    }
}