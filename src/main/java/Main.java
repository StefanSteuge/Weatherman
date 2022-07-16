import config.BotConfig;
import exceptions.IncorrectCityName;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.impl.WeatherServiceImpl;

public class Main {

    public static void main(String[] args) {
        var annotationConfigApplicationContext = new AnnotationConfigApplicationContext(BotConfig.class);
      var weatherService = annotationConfigApplicationContext.getBean(WeatherServiceImpl.class);
        try {
            System.out.println(weatherService.getByCityName("Львів"));
        } catch (IncorrectCityName e) {
            System.out.println(e.getMessage());
        }
    }
}
