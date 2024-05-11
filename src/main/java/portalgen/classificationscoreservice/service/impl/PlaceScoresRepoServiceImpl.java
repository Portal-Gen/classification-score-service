package portalgen.classificationscoreservice.service.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import portalgen.classificationscoreservice.entity.PlaceScores;
import portalgen.classificationscoreservice.exception.BadRequestError;
import portalgen.classificationscoreservice.exception.ResponseException;
import portalgen.classificationscoreservice.repository.PlaceRepository;
import portalgen.classificationscoreservice.service.PlaceScoresRepoService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlaceScoresRepoServiceImpl implements PlaceScoresRepoService {
    private PlaceRepository placeRepository;
    @Override
    public PlaceScores save(PlaceScores place) {
        return placeRepository.save(place);
    }

    @Override
    public PlaceScores findByPlaceId(Long placeId) {
        if (placeId == null) {
            throw new ResponseException(BadRequestError.PLACE_ID_IS_REQUIRED);
        }

        PlaceScores placeScores = placeRepository.findByPlaceId(placeId);

        if (placeScores == null) {
            throw new ResponseException(BadRequestError.PLACE_SCORES_NOT_FOUND);
        }

        return placeScores;
    }

    @Override
    public List<PlaceScores> findByWorldCityId(Long worldCityId) {
        if (worldCityId == null) {
            throw new ResponseException(BadRequestError.WORLD_CITY_ID_IS_REQUIRED);
        }

        List<PlaceScores> placeScores = placeRepository.findByWorldCityId(worldCityId);
        
        if (placeScores == null) {
            throw new ResponseException(BadRequestError.PLACE_SCORES_NOT_FOUND);
        }
        
        return placeScores;
        
        
    }

    @Override
    public boolean existsByPlaceId(Long placeId) {
        return placeRepository.existsByPlaceId(placeId);
    }
}
