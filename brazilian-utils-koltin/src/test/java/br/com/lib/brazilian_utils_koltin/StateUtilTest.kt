package br.com.lib.brazilian_utils_koltin

import br.com.lib.brazilian_utils_koltin.commons.States
import br.com.lib.brazilian_utils_koltin.states.StateUtil
import org.junit.Test
import kotlin.test.assertEquals

class StateUtilTest {

    @Test
    fun `verify is state by name is valid`() {
        assertEquals(States.RS, StateUtil.getStateByName("Rio Grande do Sul"))
        assertEquals(States.AC, StateUtil.getStateByName("Acre"))
        assertEquals(States.BA, StateUtil.getStateByName("Bahia"))
    }

    @Test
    fun `verify is state by cod is valid`() {
        assertEquals(States.RS, StateUtil.getStateByCode(0))
        assertEquals(States.AC, StateUtil.getStateByCode(2))
        assertEquals(States.BA, StateUtil.getStateByCode(5))
    }

    @Test
    fun `verify is state by area is valid`() {
        assertEquals(States.RS, StateUtil.getStateByArea(51))
        assertEquals(States.AC, StateUtil.getStateByArea(68))
        assertEquals(States.BA, StateUtil.getStateByArea(71))
    }

}