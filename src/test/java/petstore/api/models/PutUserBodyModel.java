package petstore.api.models;

import lombok.Data;

@Data
public class PutUserBodyModel {

    long id;
    int userStatus;
    String username, firstName, lastName, email, password, phone;

}
