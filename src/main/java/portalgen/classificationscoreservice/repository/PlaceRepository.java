package portalgen.classificationscoreservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import portalgen.classificationscoreservice.entity.PlaceScores;

import java.util.List;

public interface PlaceRepository extends MongoRepository<PlaceScores, String> {
    PlaceScores findByPlaceId(Long placeId);

    List<PlaceScores> findByCityName(String cityName);

    boolean existsByPlaceId(Long placeId);
}
