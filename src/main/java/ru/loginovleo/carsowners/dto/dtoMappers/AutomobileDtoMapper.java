package ru.loginovleo.carsowners.dto.dtoMappers;

import ru.loginovleo.carsowners.dto.AutomobileDto;
import ru.loginovleo.carsowners.model.Automobile;

public class AutomobileDtoMapper {
    public static AutomobileDto createDTo(Automobile automobile) {
        return new AutomobileDto(automobile.getId(), automobile.getBrand(), automobile.getModel(), automobile.getPower(), automobile.getPrice());
    }
}
