package ru.loginovleo.carsowners.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.loginovleo.carsowners.model.Garage;
import ru.loginovleo.carsowners.service.GarageService;

import java.util.List;

@RestController
@RequestMapping("/garage")
public class GarageController {
    private final GarageService garageService;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @GetMapping("/{id}")
    public Garage getById(@PathVariable int id) {
        logger.info("getById garage {}", id);
        return garageService.getById(id);
    }

    @GetMapping
    public List<Garage> getAll() {
        logger.info("getAll garages");
        return garageService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void save(@RequestBody Garage garage){
        logger.info("save garage {}", garage);
        garageService.save(garage);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        logger.info("delete garage with id {}", id);
        garageService.deleteById(id);
    }

    @GetMapping("/{id}/automobile")
    public Garage getWithAutomobile(@PathVariable int id){
        logger.info("get garage {} with automobiles", id);
        return garageService.getWithAutomobile(id);
    }


}
