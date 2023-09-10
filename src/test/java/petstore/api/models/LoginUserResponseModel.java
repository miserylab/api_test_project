package petstore.api.models;

import lombok.Data;

@Data
public class LoginUserResponseModel {
    String code, type, message;
}
