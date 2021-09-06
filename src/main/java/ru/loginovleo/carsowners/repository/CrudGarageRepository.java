package ru.loginovleo.carsowners.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.loginovleo.carsowners.model.Garage;
import ru.loginovleo.carsowners.model.User;

public interface CrudGarageRepository extends JpaRepository<Garage, Integer> {

    @Query("SELECT m from Garage m join fetch m.cars where m.id = ?1")
    Garage getWithAutomobile(int id);
}
