package portalgen.classificationscoreservice.exception;

import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;

public enum BadRequestError implements ResponseError {
    UNKNOWN(0, "Unknown error"),
    BAD_REQUEST_ERROR(100, "Bad request error"),
    PLACE_ID_IS_REQUIRED(101, "Place id is required"),
    PLACE_SCORES_NOT_FOUND(102, "Place scores not found"),
    WORLD_CITY_ID_IS_REQUIRED(103, "World city id is required"),
    PLACE_SCORES_ALREADY_EXISTS(104, "Place scores already exists"),
    CITY_NAME_IS_REQUIRED(105, "City name is required"),
    ;


    private final int errorCode;
    private final String message;

    BadRequestError(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getName() {
        return this.name();
    }

    public Integer getCode() {
        return this.errorCode;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public int getStatus() {
        return HttpServletResponse.SC_BAD_REQUEST;
    }
}