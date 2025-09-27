package com.example.demo.services;

import com.example.demo.entity.Place;
import com.example.demo.repo.PlaceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlaceService {
    private final PlaceRepository repo;

    public PlaceService(PlaceRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Place toggleFavourite(Place place) {
        // If place already exists (by id), update it
        if (place.getId() != null && repo.existsById(place.getId())) {
            Place existing = repo.findById(place.getId()).get();
            existing.setFavourite(!existing.isFavourite());
            return repo.save(existing);
        }
        // If it's new, just flip favourite and save
        place.setFavourite(place.isFavourite());
        return repo.save(place);
    }
}
