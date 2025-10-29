package utils.files;

import lombok.experimental.UtilityClass;
import models.Env.EnvConfig;
import utils.helpers.PathsHelper;

@UtilityClass
public class EnvReader {

    public EnvConfig getEnvConfig() {
        if (System.getenv("testEnvironment") == null) {
            throw new RuntimeException("'testEnvironment' environment variable has no value");
        }
        return JsonUtils.deserialize(PathsHelper.ENVIRONMENT_DIRECTORY + System.getenv("testEnvironment") + ".json",
                                     EnvConfig.class);
    }
}
