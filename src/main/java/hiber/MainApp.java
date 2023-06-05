package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.pojo.SerialCar;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        //userService.deleteEntity("User");//передаем имя сущность по имени классу, а не таблицы
        //userService.deleteEntity("Car");

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car(carName(), SerialCar.serialNumber())));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car(carName(), SerialCar.serialNumber())));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car(carName(), SerialCar.serialNumber())));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car(carName(), SerialCar.serialNumber())));


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar().getModel() + "Ser = " + user.getCar().getSeries());
            System.out.println();
        }


        User user = userService.getUserByCarModelAndSeries("LADA", "К877ВО93");
        System.out.println("------------------------------");
        System.out.println(user.getId() + " " + user.getFirstName() + " " + user.getLastName());
        System.out.println("_______________________________");
        context.close();
    }

    public static String carName() {
        enum carName {
            Audi, BMW, Chery, Citroen, Ford,
            Geely, Genesis, Haval,
            Honda, Hyundai, Infiniti,
            Jaguar, KIA, LADA,
            LandRover, Lexus, Mazda,
            MercedesBenz, Mitsubishi, Nissan,
            Opel, Peugeot, Renault,
            Skoda, Toyota, Volkswagen,
            Volvo

        }
        return Stream.of(carName.values())
                .skip(new Random().nextInt(carName.values().length))
                .findFirst().get().toString();
    }
}
