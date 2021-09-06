package ru.loginovleo.carsowners.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.loginovleo.carsowners.model.Automobile;

public interface CrudAutoRepository extends JpaRepository<Automobile, Integer> {

}
