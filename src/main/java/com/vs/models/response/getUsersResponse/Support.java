package com.vs.models.response.getUsersResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Support {

    @JsonProperty("text")
    String text;

    @JsonProperty("url")
    String url;
}
