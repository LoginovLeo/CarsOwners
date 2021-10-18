package ru.loginovleo.carsowners.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.loginovleo.carsowners.dto.UserDto;
import ru.loginovleo.carsowners.dto.dtoMappers.UserDtoMapper;
import ru.loginovleo.carsowners.model.User;
import ru.loginovleo.carsowners.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        logger.info("get {}", id);
        return userService.getById(id);
    }
    @Cacheable("users")
    @GetMapping()
    public List<UserDto> getAll() {
        List<User> all = userService.getAll();
        List<UserDto> userDtos = all.stream().map(UserDtoMapper::createUserDto).toList();
        logger.info("getAll users");
        return userDtos;
    }

    @GetMapping("/{id}/garage")
    public User getWithGarage(@PathVariable int id) {
        logger.info("get user {} with garages", id);
        return userService.getWithGarage(id);
    }
    @CacheEvict(value = "users", allEntries = true)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody User user) {
        logger.info("Save {}", user);
        userService.save(user);
    }
    @CacheEvict(value = "users", allEntries = true)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        logger.info("Delete user with id {}", id);
        userService.deleteById(id);
    }
}

