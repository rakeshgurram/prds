package com.bnpp.nepp.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class Error {

    @Getter
    @Setter
    private String errorId;

    @Getter @Setter
    private String message;

}
