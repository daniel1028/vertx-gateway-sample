package com.modastylz.api.gateway.responses;

/**
 * This package contains the machinery required to deal with the responses.
 * There are two different kind of responses: 1. The responses which are coming
 * from Message Bus which are to be used to continue the flow of program 2. The
 * responses which are coming from Message Bus which are to be used to send out
 * HTTP response The message bus response is always going to contain a header
 * named MessageConstants.MSG_OP_STATUS. The value of
 * MessageConstants.MSG_OP_STATUS_SUCCESS would imply that the operation is
 * successful. Else the operation has failed.
 * <p>
 * The individual response type if it varies, should be present in its own
 * package-info file, e.g. Auth. // This is what message bus consumer should
 * ideally get from the processor layer { "mb.operation.status": "success",
 * "mb.container" : { "http.status": 200, "http.headers": { "content-type" :
 * "application/json" }, "http.body": { // Either one of below three are used
 * "http.response": { }, "http.error": { }, "http.validation.error": { } } },
 * "mb.event" : { // This will be used to send out event notification // No
 * bearing on response to gateway } } // The message bus consumer will use
 * "mb.operation.status" key and value // from above packet to set the header on
 * message reply // The message body will comprise of whatever is contained in
 * key named // mb.container // The http.status will be used to set the response
 * status // The http.headers will be used to write http headers // The
 * http.body is a container which can contain of three values based // on
 * mb.operation.status. If the status is success, then http.response // is used.
 * If the status is error, then http.error is used. If the status is //
 * error.validation then http.validation.error key is used. // The packet
 * received by gateway would look like this, with one of the three // values in
 * http.body { "http.status": 200, "http.headers": { "content-type" :
 * "application/json" }, "http.body": { // Either one of below three are used
 * "http.response": { }, "http.error": { }, "http.validation.error": { } } }
 */
