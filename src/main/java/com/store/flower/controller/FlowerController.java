package com.store.flower.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.store.flower.Flower;
import com.store.flower.FlowerColor;
import com.store.flower.FlowerType;

@RestController
@RequestMapping("/flowers")
public class FlowerController {

    @GetMapping("/flowerlist")
    public List<Flower> getItems() {
        return List.of(
                new Flower(0.5, FlowerColor.BLUE, 2, FlowerType.ROSE)
        );
    }
}
