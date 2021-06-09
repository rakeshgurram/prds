package com.bnpp.nepp.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ErrorList {
    @Getter
    @Setter
    private List<Error> error = new ArrayList();
}
