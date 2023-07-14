package com.inmar.skudatamanagement.model;

public class AuthenticationResponse {
//    @JsonProperty("Bearer")
    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
