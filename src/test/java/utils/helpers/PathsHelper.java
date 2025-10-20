package utils.helpers;

import lombok.experimental.UtilityClass;

/**
 * <p>Stores all the resource paths as public constants.</p>
 * <p>Use this class to avoid hardcoded paths in the code.</p>
 */
@UtilityClass
public class PathsHelper {
    public final String RESOURCES_DIRECTORY = "src/test/resources/";
    public final String ENVIRONMENT_DIRECTORY = RESOURCES_DIRECTORY + "environment/";
    public final String ENV_FILE = RESOURCES_DIRECTORY + "env.json";
}
