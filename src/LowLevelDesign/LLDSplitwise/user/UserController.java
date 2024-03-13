package LowLevelDesign.LLDSplitwise.user;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    private List<User> allUsers;

    public UserController() {
        this.allUsers = new ArrayList<>();
    }

    public void addUser(User user) {
        this.allUsers.add(user);
    }

    public User getUser(String id){
        for(User user : allUsers){
            if(user.getId().equals(id)){
                return user;
            }
        }

        return null;
    }

    public List<User> getAllUsers(){
        return allUsers;
    }
}
