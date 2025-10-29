package utils.helpers;

import lombok.experimental.UtilityClass;

/**
 * <p>Stores all the resource paths as public constants.</p>
 */
@UtilityClass
public class PathsHelper {
    public final String RESOURCES_DIRECTORY = "src/test/resources/";
    public final String ENVIRONMENT_DIRECTORY = RESOURCES_DIRECTORY + "environment/";
    public final String TEST_DATA_DIRECTORY = RESOURCES_DIRECTORY + "testData/";

    public final String REGISTERED_USER_FILE = TEST_DATA_DIRECTORY + "registered-user.json";
    public final String UNREGISTERED_USER_FILE = TEST_DATA_DIRECTORY + "unregistered-user.json";
}
