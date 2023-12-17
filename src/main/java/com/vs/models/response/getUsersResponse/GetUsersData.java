package com.vs.models.response.getUsersResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetUsersData {

    @JsonProperty("id")
    int id;

    @JsonProperty("email")
    String email;

    @JsonProperty("first_name")
    String first_name;

    @JsonProperty("last_name")
    String last_name;

    @JsonProperty("avatar")
    String avatar;

}
