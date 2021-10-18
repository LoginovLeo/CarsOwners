package ru.loginovleo.carsowners.repository;

import org.springframework.stereotype.Repository;
import ru.loginovleo.carsowners.model.User;

import java.util.List;

@Repository
public class JpaUserRepositoryImpl {

    private final CrudUserRepository crudUserRepository;

    public JpaUserRepositoryImpl(CrudUserRepository crudUserRepository) {
        this.crudUserRepository = crudUserRepository;
    }

    public User getUser(int id) {
        return crudUserRepository.findById(id).orElse(null);
    }

    public List<User> getAll() {
        return crudUserRepository.findAll();
    }

    public void save(User user) {
        crudUserRepository.save(user);
    }

    public void deleteById(int id) {
        crudUserRepository.deleteById(id);
    }

    public User getWithGarage(int id) {
        return crudUserRepository.getWithGarage(id);
    }

    public User findByEmail(String email){
       return crudUserRepository.findByEmail(email);
    }
}
