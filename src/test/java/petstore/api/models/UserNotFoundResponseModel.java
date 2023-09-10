package petstore.api.models;

import lombok.Data;

@Data
public class UserNotFoundResponseModel {
    String code, type, message;
}
