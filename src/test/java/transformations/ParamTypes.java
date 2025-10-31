package transformations;

import io.cucumber.java.ParameterType;
import models.UserInfo;
import utils.files.UserInfoReader;

public class ParamTypes {

    @ParameterType(".*")
    public UserInfo userInfo(String userStatus) {
        return switch (userStatus.toLowerCase()) {
            case "unregistered" -> UserInfoReader.getUnregisteredUser();
            case "registered" -> UserInfoReader.getRegisteredUser();
            case "invalid" -> UserInfoReader.getRandomUser();
            default -> throw new IllegalArgumentException("No UserInfo file for '%s' status".formatted(userStatus));
        };
    }
}
