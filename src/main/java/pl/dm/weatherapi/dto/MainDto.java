package pl.dm.weatherapi.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MainDto {

    private BigDecimal temp;

    @JsonCreator
    public MainDto(@JsonProperty("temp") BigDecimal temp) {
        this.temp = temp;
    }
}
