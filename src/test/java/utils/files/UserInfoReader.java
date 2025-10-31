package utils.files;

import lombok.experimental.UtilityClass;
import models.UserInfo;
import utils.RandomUtils;
import utils.helpers.PathsHelper;

@UtilityClass
public class UserInfoReader {

    public UserInfo getUnregisteredUser() {
        return JsonUtils.deserialize(PathsHelper.UNREGISTERED_USER_FILE, UserInfo.class);
    }

    public UserInfo getRegisteredUser() {
        return JsonUtils.deserialize(PathsHelper.REGISTERED_USER_FILE, UserInfo.class);
    }

    public UserInfo getRandomUser() {
        String password = RandomUtils.generatePassword(10);
        String username = RandomUtils.generateAlphabeticString(10);
        String email = RandomUtils.generateEmail(10, 5);
        return new UserInfo(username, email, password, null);
    }
}
