package petstore.api.models;

import lombok.Data;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponseModel {

    private long id;
    private int userStatus;
    private String username, firstName, lastName, email, password, phone;

}
