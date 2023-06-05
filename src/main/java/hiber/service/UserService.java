package hiber.service;

import hiber.model.User;
import org.hibernate.query.Query;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getUserByCarModelAndSeries(String model, String series);

    void deleteEntity(String entityName);
}
