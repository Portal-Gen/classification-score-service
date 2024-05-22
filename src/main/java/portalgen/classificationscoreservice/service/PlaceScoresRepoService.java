package portalgen.classificationscoreservice.service;

import portalgen.classificationscoreservice.entity.PlaceScores;

import java.util.List;

public interface PlaceScoresRepoService {
    PlaceScores save(PlaceScores place);

    PlaceScores findByPlaceId(Long placeId);

    List<PlaceScores> findByCityName(String cityName);

    boolean existsByPlaceId(Long placeId);
}
