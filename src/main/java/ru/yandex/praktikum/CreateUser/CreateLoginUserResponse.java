package ru.yandex.praktikum.CreateUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateLoginUserResponse {

    private boolean success;
    private User user;
    private String accessToken;
    private String refreshToken;

}
