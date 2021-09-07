package ru.loginovleo.carsowners.service;

import org.springframework.stereotype.Service;
import ru.loginovleo.carsowners.model.Automobile;
import ru.loginovleo.carsowners.repository.JpaAutomobileRepositoryImpl;

import java.util.List;

@Service
public class AutomobileService {

    private final JpaAutomobileRepositoryImpl jpaAutomobileRepository;

    public AutomobileService(JpaAutomobileRepositoryImpl jpaAutomobileRepository) {
        this.jpaAutomobileRepository = jpaAutomobileRepository;
    }

    public Automobile getById(int id) {
        return jpaAutomobileRepository.getById(id);
    }

    public List<Automobile> getAll() {
        return jpaAutomobileRepository.getALL();
    }

    public void save(Automobile automobile) {
        jpaAutomobileRepository.save(automobile);
    }

    public void deleteById(int id) {
        jpaAutomobileRepository.deleteById(id);
    }
}
