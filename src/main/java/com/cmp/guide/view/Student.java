package com.cmp.guide.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Student {
    @JsonProperty("id")
    Integer id;
    @JsonProperty("name")
    String name;
}
