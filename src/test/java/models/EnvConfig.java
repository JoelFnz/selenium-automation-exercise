package models;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Model class for the config files stored in the environment directory.
 */
@Getter
@NoArgsConstructor
public class EnvConfig {
    private String host;
}
