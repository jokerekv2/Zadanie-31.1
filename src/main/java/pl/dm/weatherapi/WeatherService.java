package pl.dm.weatherapi;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.dm.weatherapi.dto.WeatherDto;
import pl.dm.weatherapi.dto.WeatherResponseDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class WeatherService {

    private final String URL = "http://api.openweathermap.org/data/2.5/weather";
    private final String API_ID = "c64c9a73b62709960d73d1106c2c6771";

    public Weather getWeatherByCity(String cityName) {

        RestTemplate restTemplate = new RestTemplate();

        try {
            WeatherResponseDto response = restTemplate.getForObject(url(cityName), WeatherResponseDto.class);

            Optional<String> mainInfo = response.getWeather().stream()
                    .map(WeatherDto::getMain)
                    .findFirst();

            Optional<String> description = response.getWeather().stream()
                    .map(WeatherDto::getDescription)
                    .findFirst();

            if (mainInfo.isPresent() && description.isPresent()) {
                BigDecimal tempInCelsius = response.getMain().getTemp().subtract(new BigDecimal("273.15")
                        .setScale(2, RoundingMode.HALF_UP));
                return new Weather(cityName, mainInfo.get(), description.get(), tempInCelsius);
            } else {
                throw new NoSuchElementException("There is no such city");
            }
        } catch (Exception e) {
            throw new NoSuchElementException("There is no such city");
        }
    }

    private String url(String cityName) {
        return String.format(URL.concat("?q=%s").concat("&appid=%s"), cityName, API_ID);
    }
}
