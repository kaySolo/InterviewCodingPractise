package LowLevelDesign.LLDSplitwise.group;

import LowLevelDesign.LLDSplitwise.user.User;

import java.util.ArrayList;
import java.util.List;

public class GroupController {

    private final List<Group> groupList;

    public GroupController() {
        this.groupList = new ArrayList<>();
    }

    public Group getGroup(String groupId){
        for(Group group : groupList){
            if(group.getId().equals(groupId)){
                return group;
            }
        }
        return null;
    }

    public void createNewGroup(String groupId, String groupName, User user){
        Group group = new Group();
        group.setId(groupId);
        group.setName(groupName);
        group.addMember(user);

        groupList.add(group);
    }
}
