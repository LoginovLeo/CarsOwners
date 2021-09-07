package ru.loginovleo.carsowners.repository;

import org.springframework.stereotype.Repository;
import ru.loginovleo.carsowners.model.Garage;

import java.util.List;

@Repository
public class JpaGarageRepositoryImpl {

    private final CrudGarageRepository crudGarageRepository;


    public JpaGarageRepositoryImpl(CrudGarageRepository crudGarageRepository) {
        this.crudGarageRepository = crudGarageRepository;
    }

    public Garage getGarage(int id) {
        return crudGarageRepository.findById(id).orElse(null);
    }

    public void save(Garage garage) {
        crudGarageRepository.save(garage);
    }

    public List<Garage> getAll() {
        return crudGarageRepository.findAll();
    }

    public void deleteById(int id) {
        crudGarageRepository.deleteById(id);
    }

    public Garage getWithAutomobile(int id) {
        return crudGarageRepository.getWithAutomobile(id);
    }

}
