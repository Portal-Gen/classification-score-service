package portalgen.classificationscoreservice.service;

import portalgen.classificationscoreservice.entity.PlaceScores;
import portalgen.classificationscoreservice.model.enums.PlaceType;

import java.util.List;
import java.util.Map;

public interface PlaceScoresService {
    PlaceScores addPlaceScores(PlaceScores place);

    PlaceScores getPlaceScores(Long placeId);

    Map<PlaceType, Float> getClassificationScores(Long placeId);

    Float getScore(Long placeId, int placeTypeCode);

    Float getScore(Long placeId, String placeType);

    List<PlaceType> getPlaceTypesAboveThreshold(Long placeId, float threshold);

    List<PlaceScores> getPlaceScoresByCityName(String cityName);

    PlaceScores updateClassificationScores(Long placeId, Map<PlaceType, Float> classificationScores);

    PlaceScores updatePlaceScores(Long placeId, PlaceScores placeScores);

}
