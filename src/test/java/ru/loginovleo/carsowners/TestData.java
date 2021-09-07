package ru.loginovleo.carsowners;

import ru.loginovleo.carsowners.model.Automobile;
import ru.loginovleo.carsowners.model.Garage;
import ru.loginovleo.carsowners.model.Role;
import ru.loginovleo.carsowners.model.User;

import java.util.List;
import java.util.Set;

public class TestData {

    //Automobiles
    public static final Automobile AUTOMOBILE1 = new Automobile(100012, "Audi", "A6", 225, 2500000.00, 100009);
    public static final Automobile AUTOMOBILE2 = new Automobile(12, "BMW", "318", 190, 1900000.00, 100009);
    public static final List<Automobile> AUTOMOBILES = List.of(AUTOMOBILE1, AUTOMOBILE2);

    // Garages
    public static final Garage GARAGEWITHOUTCARS1 = new Garage(100009, "SuperGARAGE");
    public static final Garage GARAGEWITHOUTCARS2 = new Garage(100010, "AmazingGarage");
    public static final List<Garage> GARAGES = List.of(GARAGEWITHOUTCARS1, GARAGEWITHOUTCARS2);

    public static final Garage GARAGEWITHCARS = new Garage(100009, "SuperGARAGE", AUTOMOBILES);

    //Users
    public static final Set<Role> ROLES = Set.of(Role.USER, Role.ADMIN);
    public static final User USER = new User(100002, "Arnold", "Arnoldoviche@gm.ru", "1234568", ROLES, GARAGES);
}
