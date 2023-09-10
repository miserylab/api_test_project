package petstore.api.models;

import lombok.Data;

@Data
public class LogoutUserResponseModel {
    String code, type, message;
}
