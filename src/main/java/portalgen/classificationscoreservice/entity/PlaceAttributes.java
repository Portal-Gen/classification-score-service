package portalgen.classificationscoreservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlaceAttributes {
    private boolean hasParking;
    private boolean isKidFriendly;
    private boolean isPetFriendly;
    private boolean isWheelchairAccessible;
    private boolean isFree;
    private boolean isIndoor;
    private boolean isOutdoor;
    private boolean isPublic;
    private boolean isPrivate;
    private boolean isFamily;
    private boolean isSolo;
    private boolean isGroup;
    private boolean isCouple;
    private boolean isPhotography;
    private boolean isHiking;
    private boolean isCamping;
}