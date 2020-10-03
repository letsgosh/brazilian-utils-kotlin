package br.com.lib.brazilian_utils_koltin.states

import br.com.lib.brazilian_utils_koltin.commons.States


object StateUtil {

    fun getStateByCode(code: Int) =
        States.values().firstOrNull { it.code == code }

    fun getStateByName(name: String) =
        States.values().firstOrNull { it.stateName == name }

    fun getStateByArea(area: Int) =
        States.values().firstOrNull { it.area.contains(area) }

    fun getAllStates() =
        States.values()

}