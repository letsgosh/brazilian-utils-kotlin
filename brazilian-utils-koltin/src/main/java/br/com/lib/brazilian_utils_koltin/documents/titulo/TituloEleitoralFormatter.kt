package br.com.lib.brazilian_utils_koltin.documents.titulo

import br.com.lib.brazilian_utils_koltin.commons.BaseFormatter

class TituloEleitoralFormatter {

    private val base: BaseFormatter = BaseFormatter(
        TituloEleitoralValidator.FORMATED,
        "$1/$2",
        TituloEleitoralValidator.UNFORMATED,
        "$1$2"
    )

    fun format(value: String?): String? {
        return base.format(value)
    }

    fun unformat(value: String?): String? {
        return base.unformat(value)
    }

    fun isFormatted(value: String?): Boolean {
        return base.isFormatted(value)
    }

    fun canBeFormatted(value: String?): Boolean {
        return base.canBeFormatted(value)
    }

}