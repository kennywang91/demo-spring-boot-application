package com.example.demo.controllers;


import com.example.demo.entity.Place;
import com.example.demo.services.PlaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class PlaceController {
    private final PlaceService service;

    public PlaceController(PlaceService service) {
        this.service = service;
    }

    @PostMapping("/favourites")
    public ResponseEntity<Place> toggleFavourite(@RequestBody Place place) {
        Place updated = service.toggleFavourite(place);
        return ResponseEntity.ok(updated);
    }
}
