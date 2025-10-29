package utils.files;

import lombok.experimental.UtilityClass;
import models.UserInfo;
import utils.helpers.PathsHelper;

@UtilityClass
public class UserInfoReader {

    public UserInfo getUnregisteredUser() {
        return JsonUtils.deserialize(PathsHelper.UNREGISTERED_USER_FILE, UserInfo.class);
    }

    public UserInfo getRegisteredUser() {
        return JsonUtils.deserialize(PathsHelper.REGISTERED_USER_FILE, UserInfo.class);
    }
}
