package petstore.api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PutUserBodyModel {

    private long id;
    private int userStatus;
    private String username, firstName, lastName, email, password, phone;

}
