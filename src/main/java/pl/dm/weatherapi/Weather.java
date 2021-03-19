package pl.dm.weatherapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Weather {

    private String cityName;
    private String mainInfo;
    private String description;
    private BigDecimal temp;
}
