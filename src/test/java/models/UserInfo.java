package models;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfo {
    private String username;
    private String email;
    private SignupInfo signupInfo;
}
