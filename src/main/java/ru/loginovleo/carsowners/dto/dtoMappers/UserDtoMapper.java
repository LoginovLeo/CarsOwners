package ru.loginovleo.carsowners.dto.dtoMappers;

import ru.loginovleo.carsowners.dto.UserDto;
import ru.loginovleo.carsowners.model.User;

public class UserDtoMapper {
    public static UserDto createUserDto(User user){
        return new UserDto(user.getName(), user.getEmail(), user.getPassword(), user.getRegistered());
    }
}
