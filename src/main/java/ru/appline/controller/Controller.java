package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Boundaries;
import ru.appline.logic.CompasModel;
import ru.appline.logic.Side;

import java.util.Map;

@RestController
public class Controller {

    private static final CompasModel compasModel = CompasModel.getInstance();


    @PostMapping(value = "/range", consumes = "application/json", produces = "application/json")
    public Map<String, Boundaries> setRange(@RequestBody Map<String, Boundaries> range) {
        for(Map.Entry<String, Boundaries> entry: range.entrySet()) {
            if(compasModel.containsKey(entry.getKey())) {
                compasModel.add(entry.getKey(), entry.getValue());
            }
        }
        return compasModel.getModel();
    }

    @GetMapping(value = "/side", consumes = "application/json", produces = "application/json")
    public Side computeSide(@RequestBody Map<String, Integer>  degree) {
        return compasModel.getSide(degree.get("Degree"));
    }
}
