package utils.files;

import lombok.experimental.UtilityClass;
import models.EnvConfig;
import models.EnvData;
import utils.helpers.PathsHelper;

/**
 * <p>File reader for environment configuration.</p>
 */
@UtilityClass
public class EnvReader {

    /**
     * @return an EnvConfig instance for the indicated environment in the env.json file.
     */
    public EnvConfig getEnvConfig() {
        return JsonUtils.deserialize(PathsHelper.ENVIRONMENT_DIRECTORY + getCurrentEnvironment() + ".json", EnvConfig.class);
    }

    private String getCurrentEnvironment() {
        return JsonUtils.deserialize(PathsHelper.ENV_FILE, EnvData.class).getEnvironment();
    }
}
