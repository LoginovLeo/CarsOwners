package ru.loginovleo.carsowners.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.loginovleo.carsowners.model.User;

public interface CrudUserRepository extends JpaRepository<User, Integer> {


    @Query("SELECT m from User m join fetch m.garages where m.id = ?1")
    User getWithGarage(int id);

//    @Query("SELECT m from User m left join m.garages left join Automobile where m.id = ?1")
//    User getWithAutomobile(int id);
}
