package portalgen.classificationscoreservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import portalgen.classificationscoreservice.model.enums.PlaceType;
import portalgen.classificationscoreservice.model.enums.PriceLevel;

import java.util.List;
import java.util.Map;

@Document(collection = "place_scores")
@NoArgsConstructor
@Getter
@Setter
public class PlaceScores {
    @Id
    private String id;
    private String cityName;
    private String country;
    private Long placeId;
    private Map<PlaceType, Float> classificationScores;
//    private PlaceAttributes attributes;
//    private PriceLevel priceLevel;
//    private Location location;

    public float getScore(int placeTypeCode) {
        return classificationScores.get(PlaceType.fromCode(placeTypeCode));
    }

    public float getScore(String placeType) {
        return classificationScores.get(PlaceType.valueOf(placeType));
    }

    public List<PlaceType> getPlaceTypesAboveThreshold(float threshold) {
        return classificationScores.entrySet().stream()
                .filter(entry -> entry.getValue() >= threshold)
                .map(Map.Entry::getKey)
                .toList();
    }
}