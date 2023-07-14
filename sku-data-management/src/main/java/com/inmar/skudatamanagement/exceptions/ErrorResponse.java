package com.inmar.skudatamanagement.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private String statusCode;
    private String message;

    public ErrorResponse(String message) {
        super();
        this.message = message;
    }
}
