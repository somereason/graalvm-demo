package sqs.example.graalvmdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class HomeController {
    AtomicInteger count = new AtomicInteger(0);

    @Autowired
    CarRepository carRepository;

    @GetMapping("/indexjson")
    @ResponseBody
    private String indexJson() {
        return "Hello world, request count: " + count.addAndGet(1);
    }

    @GetMapping("/random_car")
    @ResponseBody
    private CarEntity randomCar() {
        long count = carRepository.count();
        Random r = new Random();
        Optional<CarEntity> car = carRepository.findById(r.nextInt((int) count));
        return car.orElse(CarEntity.nullObject());
    }

    @GetMapping("/")
    private ModelAndView index() {
        return new ModelAndView("index");
    }
}
