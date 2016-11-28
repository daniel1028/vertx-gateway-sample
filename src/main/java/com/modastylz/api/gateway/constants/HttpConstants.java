package com.modastylz.api.gateway.constants;

public class HttpConstants {

    public static final String HEADER_AUTH = "Authorization";
    public static final String HEADER_WWW_AUTHENTICATE = "WWW-Authenticate";
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
    public static final String HEADER_CONTENT_LENGTH = "Content-Length";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_LOCATION = "Location";
    public static final String HEADER_HOST = "Host";
    public static final String HEADER_REFERER = "referer";
    public static final String BASIC = "Basic";
    public static final String TOKEN = "Token";
    // GLA 2.0
    public static final String GOORU_SESSION_TOKEN = "Gooru-Session-Token";
    public static final String GOORU_API_KEY = "Gooru-ApiKey";
    public static final String SESSION_TOKEN = "sessionToken";

    public enum HttpStatus {

        SUCCESS(200, "Successful"),
        CREATED(201, "Created"),
        ACCEPTED(202, "Accepted"),
        NO_CONTENT(204, "No Content"),
        MOVED_PERMANENTLY(302, "Moved Permanently"),
        NOT_MODIFIED(304, "Not Modified"),
        BAD_REQUEST(400, "Bad Request"),
        UNAUTHORIZED(401, "Unauthorized"),
        FORBIDDEN(403, "Forbidden"),
        NOT_FOUND(404, "Not Found"),
        NOT_ACCEPTABLE(406, "Not Acceptable"),
        TIMED_OUT(408, "Request Timeout"),
        TOO_LARGE(413, "Request Entity Too Large"),
        TOO_MANY_REQUESTS(429, "Too Many Requests"),
        ERROR(500, "Internal Server Error");

        private final int code;
        private final String message;

        HttpStatus(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }

}
