package utils.files;

import com.google.gson.*;
import lombok.experimental.UtilityClass;

import java.io.FileNotFoundException;
import java.io.FileReader;

@UtilityClass
public class JsonUtils {
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public <T> T deserialize(String filePath, Class<T> clazz) {
        try {
            return GSON.fromJson(new FileReader(filePath), clazz);
        } catch (FileNotFoundException | JsonParseException e) {
            throw new RuntimeException("Deserialize attempt failed for file %s.\nCause: %s\n".formatted(filePath, e));
        }
    }
}
