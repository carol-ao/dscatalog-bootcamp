package com.carol.dscatalog.resources.Exceptions;

import lombok.Data;

import java.time.Instant;

@Data
public class StandardError {
    private Instant timeStamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
