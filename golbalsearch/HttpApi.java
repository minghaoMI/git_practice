package com.xiaomi.search.global.cms.goldenset.golbalsearch;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.xiaomi.search.global.cms.goldenset.base.Api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by minghao on 16-7-7.
 */
public class HttpApi extends Api {

    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory(new HttpRequestInitializer() {
        @Override
        public void initialize(HttpRequest httpRequest) throws IOException {
            httpRequest.setParser(new JsonObjectParser(JSON_FACTORY));
        }
    });
    static final JsonFactory JSON_FACTORY = new JacksonFactory();

    public enum HttpMethod { POST, GET }

    protected String url;

    protected HttpMethod method;

    protected Map<String, String> paramater;



    public String run() throws Exception {
        System.out.println("Run in HttpApi");
        String json = null;
        switch (method) {
            case GET :
                String para = getParameterString();
                HttpRequest get_request = requestFactory.buildGetRequest(new GenericUrl(url));
                HttpResponse get_response = get_request.execute();
                json = get_response.parseAsString();
                break;
            case POST :
                HttpContent params = new UrlEncodedContent(paramater);
                HttpRequest post_request = requestFactory.buildPostRequest(new GenericUrl(url), params);
                HttpResponse post_response = post_request.execute();
                json = post_response.parseAsString();
                break;
            default :
                break;
        }
        return json;
    }

    public String getParameterString() {
        String ret = url;
        boolean first = true;
        for (Map.Entry<String, String> entry : paramater.entrySet()) {
            if (first) {
                ret = ret + "?" + entry.getKey() + "=" + entry.getValue();
                first = false;
            } else {
                ret = ret + "&" + entry.getKey() + "=" + entry.getValue();
            }
        }
        return ret;
    }

    public void addParameterPair(String key, String value) {
        paramater.put(key, value);
    }

    public HttpApi() {
        url = null;
        method = HttpMethod.POST;
        paramater = new HashMap<String, String>();
    }

    public HttpApi(String url) {
        this.url = url;
        method = HttpMethod.POST;
        paramater = new HashMap<String, String>();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getParamater() {
        return paramater;
    }

    public void setParamater(Map<String, String> paramater) {
        this.paramater = paramater;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }
}
