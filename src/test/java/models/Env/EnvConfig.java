package models.Env;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EnvConfig {
    private String host;
    private int implicitWait;
}
