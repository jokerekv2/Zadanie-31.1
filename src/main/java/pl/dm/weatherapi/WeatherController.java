package pl.dm.weatherapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.NoSuchElementException;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String home() {
        return "weatherByCityForm";
    }

    @PostMapping("/")
    public String weather(Model model, @RequestParam String cityName) {
        model.addAttribute("weatherInfo", weatherService.getWeatherByCity(cityName));
        return "weatherInfo";
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handleException() {
        return "noData";
    }
}
