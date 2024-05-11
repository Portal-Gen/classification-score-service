package portalgen.classificationscoreservice.model.enums;

import lombok.Getter;

@Getter
public enum PriceLevel {
    FREE(0),
    CHEAP(1),
    MODERATE(2),
    EXPENSIVE(3),
    VERY_EXPENSIVE(4);

    private final int value;

    PriceLevel(int value) {
        this.value = value;
    }

}
