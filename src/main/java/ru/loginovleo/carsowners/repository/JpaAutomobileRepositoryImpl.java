package ru.loginovleo.carsowners.repository;

import org.springframework.stereotype.Repository;
import ru.loginovleo.carsowners.model.Automobile;

import java.util.List;

@Repository
public class JpaAutomobileRepositoryImpl {

    private final CrudAutoRepository autoRepository;

    public JpaAutomobileRepositoryImpl(CrudAutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    public Automobile getById(int id) {
        return autoRepository.findById(id).orElse(null);
    }

    public List<Automobile> getALL() {
        return autoRepository.findAll();
    }

    public void deleteById(int id) {
        autoRepository.deleteById(id);
    }

    public void save(Automobile automobile) {
        autoRepository.save(automobile);
    }
}
