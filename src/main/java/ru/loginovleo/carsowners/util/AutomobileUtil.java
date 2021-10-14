package ru.loginovleo.carsowners.util;

import ru.loginovleo.carsowners.dto.AutomobileDto;
import ru.loginovleo.carsowners.dto.dtoMappers.AutomobileDtoMapper;
import ru.loginovleo.carsowners.model.Automobile;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class AutomobileUtil {


    public static List<AutomobileDto> getFilteredByPrice(Collection<Automobile> automobiles) {
        return automobiles.stream()
                .map(AutomobileDtoMapper::createDTo)
                .sorted(Comparator.comparing(AutomobileDto::getPrice).reversed())
                .toList();
    }

    public static AutomobileDto getAuto (Automobile automobile){
        return AutomobileDtoMapper.createDTo(automobile);
    }

}
