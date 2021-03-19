package pl.dm.weatherapi.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WeatherDto {

    private String main;
    private String description;

    @JsonCreator
    public WeatherDto(@JsonProperty("main") String main,
                      @JsonProperty("description") String description) {
        this.main = main;
        this.description = description;
    }
}
