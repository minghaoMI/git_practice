package com.xiaomi.search.global.cms.goldenset.golbalsearch;

import com.xiaomi.search.global.cms.goldenset.base.Result;

/**
 * Created by minghao on 16-7-7.
 */
public class HttpResult extends Result {

    protected String json;

    public HttpResult() {
        super();
        json = null;
    }

    public HttpResult(String json) {
        super();
        this.json = json;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
