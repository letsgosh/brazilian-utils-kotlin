package br.com.lib.brazilian_utils_koltin

import br.com.lib.brazilian_utils_koltin.cities.CitiesUtil
import br.com.lib.brazilian_utils_koltin.commons.Cities
import org.junit.Test
import kotlin.test.assertEquals

class CityUtilTest {

    @Test
    fun `verify is city by name is valid`() {
        assertEquals(Cities.RS, CitiesUtil.getCityByName("Porto Alegre"))
        assertEquals(Cities.PI, CitiesUtil.getCityByName("Acauã"))
        assertEquals(Cities.RN, CitiesUtil.getCityByName("Almino Afonso"))
    }

    @Test
    fun `get is cities of state is valid`() {
        assertEquals("Brasília", CitiesUtil.getCitiesByState(Cities.DF)[0])
        assertEquals("Aperibé", CitiesUtil.getCitiesByState(Cities.RJ)[1])
        assertEquals("Atalaia", CitiesUtil.getCitiesByState(Cities.AL)[2])
    }

}