package com.vs.models.response.getUsersResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Setter
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Root {

    @JsonProperty("data")
    ArrayList<GetUsersData> data;

    @JsonProperty("page")
     int page;

    @JsonProperty("per_page")
    int per_page;

    @JsonProperty("total")
    int total;

    @JsonProperty("total_pages")
    int total_pages;

    @JsonProperty("support")
    Support support;
}
