package com.modastylz.api.gateway.responses.auth;

public interface AuthResponseHolder {
    boolean isAuthorized();

    boolean isAnonymous();

}