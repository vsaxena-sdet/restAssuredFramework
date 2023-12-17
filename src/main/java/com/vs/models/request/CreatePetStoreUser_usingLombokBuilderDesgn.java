package com.vs.models.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder(setterPrefix = "set")
@ToString
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreatePetStoreUser_usingLombokBuilderDesgn {
//using builder method
    int id;
    String username;
    String firstName;
    String lastName;
    String email;
    String password;
    String phone;
    int userStatus;
}
