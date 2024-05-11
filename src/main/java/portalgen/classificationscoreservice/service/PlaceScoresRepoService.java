package portalgen.classificationscoreservice.service;

import portalgen.classificationscoreservice.entity.PlaceScores;

import java.util.List;

public interface PlaceScoresRepoService {
    PlaceScores save(PlaceScores place);

    PlaceScores findByPlaceId(Long placeId);

    List<PlaceScores> findByWorldCityId(Long worldCityId);

    boolean existsByPlaceId(Long placeId);
}
