package petstore.api.models;

import lombok.Data;

@Data
public class PostUserResponseModel {
    String code, type, message;
}
