package petstore.api.utils;

import petstore.api.models.*;

import java.util.HashMap;
import java.util.Map;

public class TestData {
    RandomUtils random = new RandomUtils();
    public PostUserBodyModel createUserData = new PostUserBodyModel();
    {
        createUserData.setId(random.getRandomNumber());
        createUserData.setUsername(random.getRandomUserName());
        createUserData.setFirstName(random.getRandomFirstName());
        createUserData.setLastName(random.getRandomLastName());
        createUserData.setEmail(random.getRandomEmail());
        createUserData.setPassword(random.getRandomPassword());
        createUserData.setPhone(random.getRandomPhone());
        createUserData.setUserStatus(random.getRandomNumber());
    }

//    public PostUserBodyModel updateData = new PostUserBodyModel();
//    {
//        updateData.setName(random.getRandomUserName());
//        updateData.setJob(random.getRandomJob());
//    }

    public String getUserId() {
        return "2";
    }

    public String getNonExistedUserId() {
        return "23";
    }

    public String getPage() {
        return "1";
    }

    public Map<String,String> user_get_data = new HashMap<>();
    {
        user_get_data.put("id", "2");
        user_get_data.put("email", "janet.weaver@reqres.in");
        user_get_data.put("first_name", "Janet");
        user_get_data.put("last_name", "Weaver");
        user_get_data.put("avatar", "https://reqres.in/img/faces/2-image.jpg");
    }

    public Map<String,String> user_list_data = new HashMap<>();
    {
        user_list_data.put("page", "1");
        user_list_data.put("per_page", "6");
        user_list_data.put("total", "12");
        user_list_data.put("total_pages", "2");
    }

}
