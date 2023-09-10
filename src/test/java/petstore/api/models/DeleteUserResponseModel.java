package petstore.api.models;

import lombok.Data;

@Data
public class DeleteUserResponseModel {
    String code, type, message;
}
