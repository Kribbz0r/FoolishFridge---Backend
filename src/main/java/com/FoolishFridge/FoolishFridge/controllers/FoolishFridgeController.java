package com.FoolishFridge.FoolishFridge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FoolishFridge.FoolishFridge.models.FoolishFridge;
import com.FoolishFridge.FoolishFridge.models.FoolishFridgeData;
import com.FoolishFridge.FoolishFridge.services.FoolishFridgeService;

@RestController
@CrossOrigin("*")
public class FoolishFridgeController {

    @Autowired
    private FoolishFridgeService foolishFridgeService;

    @PostMapping("/FoolishFridge")
    public FoolishFridge newFoolishFridgeEntry(@RequestBody FoolishFridgeData foolishFridgeData) {

        System.out.println("Detta är varning: " + foolishFridgeData.getWarning());
        System.out.println("Detta är tiden: " + foolishFridgeData.getDoorOpenTime());

        return foolishFridgeService.newFoolishFridgeEntry(foolishFridgeData);
    }

    @GetMapping("/FoolishFridge")
    public List<FoolishFridge> getFoolishFridge() {
        System.out.println("Här hämtas det");
        return foolishFridgeService.getFoolishFridge();
    }

}
