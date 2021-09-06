package ru.loginovleo.carsowners.service;

import org.springframework.stereotype.Service;
import ru.loginovleo.carsowners.model.User;
import ru.loginovleo.carsowners.repository.JpaUserRepositoryImpl;

import java.util.List;

@Service
public class UserService {

    private final JpaUserRepositoryImpl jpaUserRepositoryImpl;

    public UserService(JpaUserRepositoryImpl jpaUserRepositoryImpl) {
        this.jpaUserRepositoryImpl = jpaUserRepositoryImpl;
    }

    public User getUser(int id) {
        return jpaUserRepositoryImpl.getUser(id);
    }

    public List<User> getAll() {
        return jpaUserRepositoryImpl.getAll();
    }

    public void save(User user){
        jpaUserRepositoryImpl.save(user);
    }

    public void deleteById(int id){
        jpaUserRepositoryImpl.deleteById(id);
    }

    public User getWithGarage(int id){
        return jpaUserRepositoryImpl.getWithGarage(id);
    }

}
