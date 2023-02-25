package hiber.dao;

import hiber.model.Car;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CarDao {
    void add(Car car);
    List<Car> list();
}
