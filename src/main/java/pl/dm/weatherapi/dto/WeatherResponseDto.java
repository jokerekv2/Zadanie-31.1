package pl.dm.weatherapi.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class WeatherResponseDto {

    private String cityName;
    private MainDto main;
    private List<WeatherDto> weather;

    @JsonCreator
    public WeatherResponseDto(@JsonProperty("name") String cityName,
                              @JsonProperty("main") MainDto main,
                              @JsonProperty("weather") List<WeatherDto> weather) {
        this.cityName = cityName;
        this.main = main;
        this.weather = weather;
    }
}
