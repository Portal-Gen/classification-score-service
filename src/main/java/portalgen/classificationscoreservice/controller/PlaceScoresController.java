package portalgen.classificationscoreservice.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import portalgen.classificationscoreservice.entity.PlaceScores;
import portalgen.classificationscoreservice.model.enums.PlaceType;
import portalgen.classificationscoreservice.model.response.Response;
import portalgen.classificationscoreservice.service.PlaceScoresService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1/place_scores")
@RequiredArgsConstructor
public class PlaceScoresController {
    private final PlaceScoresService placeScoresService;

    @PostMapping
    public Response<PlaceScores> addPlaceScores(@RequestBody PlaceScores place) {
        return new Response<>(placeScoresService.addPlaceScores(place));
    }

    @GetMapping("/place/{placeId}")
    public Response<PlaceScores> getPlaceScores(@PathVariable Long placeId) {
        return new Response<>(placeScoresService.getPlaceScores(placeId));
    }

    @GetMapping("/city_name/{cityName}")
    public Response<List<PlaceScores>> getPlaceScoresByCityName(@PathVariable String cityName) {
        return new Response<>(placeScoresService.getPlaceScoresByCityName(cityName));
    }

    @GetMapping("/place/{placeId}/classification_scores")
    public Response<Map<PlaceType, Float>> getClassificationScores(@PathVariable Long placeId) {
        return new Response<>(placeScoresService.getClassificationScores(placeId));
    }

    @GetMapping("/place/{placeId}/score/{placeType}")
    public Response<Float> getScore(@PathVariable Long placeId, @PathVariable String placeType) {
        return new Response<>(placeScoresService.getScore(placeId, placeType));
    }

    @GetMapping("/place/{placeId}/place_types_above_threshold/{threshold}")
    public Response<List<PlaceType>> getPlaceTypesAboveThreshold(@PathVariable Long placeId, @PathVariable float threshold) {
        return new Response<>(placeScoresService.getPlaceTypesAboveThreshold(placeId, threshold));
    }

    @PutMapping("/place/{placeId}")
    public Response<PlaceScores> updatePlaceScores(@PathVariable Long placeId, @RequestBody PlaceScores placeScores) {
        return new Response<>(placeScoresService.updatePlaceScores(placeId, placeScores));
    }

    @PutMapping("/place/{placeId}/classification_scores")
    public Response<PlaceScores> updateClassificationScores(@PathVariable Long placeId, @RequestBody Map<PlaceType, Float> classificationScores) {
        return new Response<>(placeScoresService.updateClassificationScores(placeId, classificationScores));
    }
}
