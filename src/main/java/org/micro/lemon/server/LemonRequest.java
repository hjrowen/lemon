package org.micro.lemon.server;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * LemonRequest
 *
 * @author lry
 */
@Data
@Slf4j
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LemonRequest implements Serializable {

    private Object content;
    private final Map<String, Object> headers = new HashMap<>();

    public LemonRequest(Map<String, Object> headers, Object content) {
        this.headers.putAll(headers);
        this.content = content;
    }

    public String getHeaderValue(String headerKey) {
        return headers.containsKey(headerKey) ? String.valueOf(headers.get(headerKey)) : null;
    }

    public String getUri() {
        return this.getHeaderValue(LemonContext.URI_KEY);
    }

    public String getApplicationPath() {
        return this.getHeaderValue(LemonContext.APP_PATH_KEY);
    }

    public String getContextPath() {
        return this.getHeaderValue(LemonContext.CONTEXT_PATH_KEY);
    }

    public String getHttpMethod() {
        return this.getHeaderValue(LemonContext.METHOD_KEY);
    }

    public String getPath() {
        return this.getHeaderValue(LemonContext.PATH_KEY);
    }

}
