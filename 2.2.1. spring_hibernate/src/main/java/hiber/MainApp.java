package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Daniel", "Brock", "db@mail.ru");
      Car car = new Car("Mercedes", 9);
      user1.setCar(car);
      userService.add(user1);

      User user2 = new User("James", "Glock", "JQ@bk.ru");
      Car car2 = new Car("VAZ", 2110);
      user2.setCar(car2);
      userService.add(user2);

      User user3 = new User("Kolya", "Petrov", "Petrov@gmail.com");
      Car car3 = new Car("VAZ", 2110);
      user3.setCar(car3);
      userService.add(user3);

      List<User> users = userService.findByCar("VAZ",2110);
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car =" +user.getCar());
         System.out.println();
      }

      context.close();
   }
}
