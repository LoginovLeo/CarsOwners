package ru.loginovleo.carsowners.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "garage")
public class Garage extends AbstractBaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "user_id")
    private int userId;

    @Column(name ="capacity")
    private int capacity;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "garage_id", referencedColumnName = "id")
    private List<Automobile> cars;

    public Garage() {
    }



    public Garage(int id, String name, int userId) {
        super(id);
        this.name = name;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int user_id) {
        this.userId = user_id;
    }
}
