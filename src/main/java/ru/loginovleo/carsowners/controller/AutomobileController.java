package ru.loginovleo.carsowners.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.loginovleo.carsowners.dto.AutomobileDto;
import ru.loginovleo.carsowners.model.Automobile;
import ru.loginovleo.carsowners.service.AutomobileService;
import ru.loginovleo.carsowners.util.AutomobileUtil;

import java.util.List;

@RestController
@RequestMapping("/automobile")
public class AutomobileController {
    private final AutomobileService automobileService;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public AutomobileController(AutomobileService automobileService) {
        this.automobileService = automobileService;
    }

    @GetMapping("/{id}")
    public Automobile getById(@PathVariable int id){
        logger.info("getById automobile {}",id);
        return automobileService.getById(id);
    }

    @GetMapping
    public List<AutomobileDto> getAll(){
        logger.info("getALl automobiles");
        return AutomobileUtil.getDtos(automobileService.getAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void save(Automobile automobile) {
        logger.info("save {}", automobile);
        automobileService.save(automobile);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id){
        logger.info("delete automobile with id {}", id);
        automobileService.deleteById(id);
    }
}
