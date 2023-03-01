package hiber.service;

import hiber.dao.CarDao;
import hiber.dao.CarDaoImp;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
public class CarServiceImp implements CarService {

    private CarDao carDao;
    @Autowired
    public CarServiceImp(CarDao carDao) {this.carDao = carDao;}


    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);

    }
    @Transactional(readOnly = true)
    @Override
    public List<Car> list() {
        return carDao.list();
    }
}
