package org.micro.lemon.server;

import org.micro.lemon.common.LemonStatusCode;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * Lemon Context
 *
 * @author lry
 */
@Data
@Slf4j
@ToString
public class LemonContext implements MessageCallback {

    public final static String LEMON_ID_KEY = "X-Lemon-Id";
    public final static String URI_KEY = "X-Lemon-Uri";
    public final static String APP_PATH_KEY = "X-Lemon-ApplicationPath";
    public final static String CONTEXT_PATH_KEY = "X-Lemon-ContextPath";
    public final static String PATH_KEY = "X-Lemon-Path";
    public final static String METHOD_KEY = "X-Lemon-HttpMethod";
    public final static String KEEP_ALIVE_KEY = "X-Lemon-KeepAlive";
    public final static String CONTENT_LENGTH_KEY = "X-Lemon-ContentLength";

    public final static String LEMON_CODE_KEY = "X-Lemon-Code";
    public final static String LEMON_CODE_MESSAGE = "X-Lemon-Message";

    public final static String URL_DELIMITER = "/";
    public final static String HEADER_PREFIX = "X-";
    public final static String INVALIDATE_CACHE = "X-Invalidate-Cache";
    public final static String LEMON_TOKEN = "X-Lemon-Token";

    private LemonRequest request;
    private LemonResponse response;

    public LemonContext(LemonRequest request) {
        this.request = request;
        this.response = new LemonResponse();
    }

    public void onCallback(LemonStatusCode statusCode) {
        callback(statusCode, statusCode.getMessage(), null);
    }

    public void onCallback(LemonStatusCode statusCode, String message) {
        callback(statusCode, message, null);
    }

    public void onCallback(LemonStatusCode statusCode, String message, Object body) {
        callback(statusCode, message, body);
    }

}
