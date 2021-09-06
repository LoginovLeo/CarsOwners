package ru.loginovleo.carsowners.util;

import ru.loginovleo.carsowners.dto.AutomobileDto;
import ru.loginovleo.carsowners.model.Automobile;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class AutomobileUtil {
    public static List<AutomobileDto> getDtos(Collection<Automobile> automobiles) {
       return automobiles.stream()
                .map(AutomobileUtil::createDTo)
                .sorted(Comparator.comparing(AutomobileDto::getPrice).reversed())
                .toList();
    }

public static AutomobileDto createDTo(Automobile automobile){
return new AutomobileDto(automobile.getId(), automobile.getBrand(), automobile.getModel(), automobile.getPower(), automobile.getPrice());
}
}
