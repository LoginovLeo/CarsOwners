package ru.loginovleo.carsowners.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "users")
@JsonIgnoreProperties(value = {"roles"})
public class User extends AbstractBaseEntity {

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    private String password;

    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()")
    @NotNull
    private Date registered = new Date();
    @Enumerated(value = EnumType.STRING)
    @Column (name = "role")
    private Role role;

    public User(String name, String email, String password, Date registered, Role role, List<Garage> garages) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.registered = registered;
        this.role = role;
        this.garages = garages;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

//    @Enumerated(EnumType.STRING)
//    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
//            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role"}, name = "uk_user_roles")})
//    @Column(name = "role")
//    @ElementCollection(fetch = FetchType.LAZY)
//    @BatchSize(size = 200)
//    @JoinColumn(name = "user_id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Set<Role> roles;
//
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Garage> garages;

    public User() {
    }

    public User(Integer id, String name, String email, String password, Role role, List<Garage> garage, Role... roles) {
        this(id, name, email, password, new Date(), EnumSet.of(role, roles), garage);
    }

    public User(Integer id, String name, String email, String password, Set<Role> role, List<Garage> garage) {
        this(id, name, email, password, new Date(), role, garage);
    }

    public User(Integer id, String name, String email, String password, Date registered, Collection<Role> roles, Collection<Garage> garages) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.registered = registered;
//        setRoles(roles);
    }

    public List<Garage> getGarages() {
        return garages;
    }

    public void setGarages(List<Garage> garages) {
        this.garages = garages;
    }

//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Collection<Role> roles) {
//        this.roles = CollectionUtils.isEmpty(roles) ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }
}
