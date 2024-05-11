package portalgen.classificationscoreservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import portalgen.classificationscoreservice.entity.PlaceScores;
import portalgen.classificationscoreservice.exception.BadRequestError;
import portalgen.classificationscoreservice.exception.ResponseException;
import portalgen.classificationscoreservice.model.enums.PlaceType;
import portalgen.classificationscoreservice.service.PlaceScoresRepoService;
import portalgen.classificationscoreservice.service.PlaceScoresService;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PlaceScoresServiceImpl implements PlaceScoresService {
    private PlaceScoresRepoService placeScoresRepoService;

    @Override
    public PlaceScores addPlaceScores(PlaceScores place) {
        handleAddPlaceScores(place);
        return placeScoresRepoService.save(place);
    }

    @Override
    public PlaceScores getPlaceScores(Long placeId) {
        return placeScoresRepoService.findByPlaceId(placeId);
    }

    @Override
    public Map<PlaceType, Float> getClassificationScores(Long placeId) {
        PlaceScores placeScores = placeScoresRepoService.findByPlaceId(placeId);
        return placeScores.getClassificationScores();
    }

    @Override
    public Float getScore(Long placeId, int placeTypeCode) {
        PlaceScores placeScores = placeScoresRepoService.findByPlaceId(placeId);
        return placeScores.getScore(placeTypeCode);
    }

    @Override
    public Float getScore(Long placeId, String placeType) {
        PlaceScores placeScores = placeScoresRepoService.findByPlaceId(placeId);
        return placeScores.getScore(placeType);
    }

    @Override
    public List<PlaceType> getPlaceTypesAboveThreshold(Long placeId, float threshold) {
        PlaceScores placeScores = placeScoresRepoService.findByPlaceId(placeId);
        return placeScores.getPlaceTypesAboveThreshold(threshold);
    }

    @Override
    public List<PlaceScores> getPlaceScoresByWorldCityId(Long worldCityId) {
        return placeScoresRepoService.findByWorldCityId(worldCityId);
    }

    @Override
    public PlaceScores updateClassificationScores(Long placeId, Map<PlaceType, Float> classificationScores) {
        PlaceScores placeScores = placeScoresRepoService.findByPlaceId(placeId);
        placeScores.setClassificationScores(classificationScores);
        return placeScoresRepoService.save(placeScores);
    }

    @Override
    public PlaceScores updatePlaceScores(Long placeId, PlaceScores placeScores) {
        PlaceScores existingPlaceScores = placeScoresRepoService.findByPlaceId(placeId);
        if (placeScores.getAttributes() != null) {
            existingPlaceScores.setAttributes(placeScores.getAttributes());
        }

        if (placeScores.getClassificationScores() != null) {
            existingPlaceScores.setClassificationScores(placeScores.getClassificationScores());
        }

        if (placeScores.getLocation() != null) {
            existingPlaceScores.setLocation(placeScores.getLocation());
        }

        if (placeScores.getPriceLevel() != null) {
            existingPlaceScores.setPriceLevel(placeScores.getPriceLevel());
        }

        return placeScoresRepoService.save(existingPlaceScores);
    }

    private void handleAddPlaceScores(PlaceScores place) {
        handlePlaceScores(place);
        if (placeScoresRepoService.existsByPlaceId(place.getPlaceId())) {
            throw new ResponseException(BadRequestError.PLACE_SCORES_ALREADY_EXISTS);
        }
    }

    private void handlePlaceScores(PlaceScores place) {

    }


}
