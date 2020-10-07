package br.com.lib.brazilian_utils_koltin.cities

import br.com.lib.brazilian_utils_koltin.commons.Cities


object CitiesUtil {

    fun getCitiesByName(name: String) =
        Cities.values().firstOrNull { it.citiesName.contains(name) }

    fun getCitiesByState(city: Cities) = city.citiesName

    fun getAllCities() = Cities.values()

}