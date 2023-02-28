package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      CarService carService = context.getBean(CarService.class);

      UserService userService = context.getBean(UserService.class);
      userService.deleteUsers();
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      Car car1 = new Car("Audi", 5);
      user1.setCar(car1);
      car1.setUser(user1);
      userService.add(user1);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      Car car2 = new Car("BMW", 7);
      user2.setCar(car2);
      car2.setUser(user2);
      userService.add(user2);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      Car car3 = new Car("Tesla", 2);
      user3.setCar(car3);
      car3.setUser(user3);
      userService.add(user3);

      /*userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Audi", 5)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("BMW", 7)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Tesla", 2)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("AM", 3)));


      List<User> listUsers = userService.listUsers();
      List<Car> listCar = carService.list();
      int i = 0;
      for (User user : listUsers) {
         user.setCar(listCar.get(i));
         ++i;
      }*/
      /*carService.add(new Car("Audi", 5));
      carService.add(new Car("BMW", 7));
      carService.add(new Car("Tesla", 2));
      carService.add(new Car("AM", 3));*/


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      System.out.println("Поиск пользователя: ");
      System.out.println(userService.getUserByCar("Tesla", 2));

      context.close();
   }
}
