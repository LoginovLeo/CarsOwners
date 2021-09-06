package ru.loginovleo.carsowners.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "garage")
public class Garage extends AbstractBaseEntity {

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "user_id")
    @NotBlank
    private int user_id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "garage_id", referencedColumnName = "id")
    private List<Automobile> cars;

    public Garage() {
    }

    public Garage(int id, String name, List<Automobile> cars) {
        super(id);
        this.name = name;
        this.cars = cars;
    }

    public Garage(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
