package ru.loginovleo.carsowners.service;

import org.springframework.stereotype.Service;
import ru.loginovleo.carsowners.model.Garage;
import ru.loginovleo.carsowners.repository.JpaGarageRepositoryImpl;

import java.util.List;

@Service
public class GarageService {
    private final JpaGarageRepositoryImpl jpaGarageRepository;

    public GarageService(JpaGarageRepositoryImpl jpaGarageRepository) {
        this.jpaGarageRepository = jpaGarageRepository;
    }

    public Garage getById(int id) {
        return jpaGarageRepository.getGarage(id);
    }

    public List<Garage> getAll() {
        return jpaGarageRepository.getAll();
    }

    public void save(Garage garage) {
        jpaGarageRepository.save(garage);
    }

    public void deleteById(int id) {
        jpaGarageRepository.deleteById(id);
    }

    public Garage getWithAutomobile(int id) {
        return jpaGarageRepository.getWithAutomobile(id);
    }

}
