package com.FoolishFridge.FoolishFridge.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import com.FoolishFridge.FoolishFridge.models.FoolishFridge;
import com.FoolishFridge.FoolishFridge.models.FoolishFridgeData;

@Service
public class FoolishFridgeService {

    DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private MongoOperations mongoOperations;

    public FoolishFridge newFoolishFridgeEntry(FoolishFridgeData foolishFridgeData) {
        System.out.println("I service är varning: " + foolishFridgeData.getWarning());
        LocalDateTime dateTime = LocalDateTime.now();
        int warning = Integer.valueOf(foolishFridgeData.getWarning());
        int time = Integer.valueOf(foolishFridgeData.getDoorOpenTime());

        FoolishFridge foolishFridge = new FoolishFridge(warning, time, formatDateTime.format(dateTime));
        return mongoOperations.save(foolishFridge);

    }

    public List<FoolishFridge> getFoolishFridge() {

        return mongoOperations.findAll(FoolishFridge.class);
    }

}
