package petstore.api.models;

import lombok.Data;

@Data
public class PutUserResponseModel {
    String code, type, message;
}
