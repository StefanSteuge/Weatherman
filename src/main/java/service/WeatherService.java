package service;

import exceptions.IncorrectCityName;
import model.Weather;

import static service.ApiConstants.CITY_REGEX;

public interface WeatherService {

    Weather getByCityName(String city);

    default void validationCityName(String city) {
//        if (!city.matches(CITY_REGEX)) {
//            throw new IncorrectCityName(String.format("Incorrect city name %s",city));
//        }
    }
}
