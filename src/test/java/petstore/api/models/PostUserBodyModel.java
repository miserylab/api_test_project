package petstore.api.models;

import lombok.Data;

@Data
public class PostUserBodyModel {

    long id;
    int userStatus;
    String username, firstName, lastName, email, password, phone;

}
