package portalgen.classificationscoreservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import portalgen.classificationscoreservice.entity.PlaceScores;

import java.util.List;

public interface PlaceRepository extends MongoRepository<PlaceScores, String> {
    PlaceScores findByPlaceId(Long placeId);

    List<PlaceScores> findByWorldCityId(long worldCityId);

    boolean existsByPlaceId(Long placeId);
}
