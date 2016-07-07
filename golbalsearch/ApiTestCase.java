package com.xiaomi.search.global.cms.goldenset.golbalsearch;

import com.xiaomi.search.global.cms.goldenset.base.Api;
import com.xiaomi.search.global.cms.goldenset.base.Assertion;
import com.xiaomi.search.global.cms.goldenset.base.Case;
import com.xiaomi.search.global.cms.goldenset.base.Result;

/**
 * Created by minghao on 16-7-7.
 */
public class ApiTestCase extends Case {

    protected Api api;

    protected Assertion assertion;

    public Result run() {
        System.out.println("Run in ApiTestSuit");
        HttpResult result = new HttpResult();
        try {
            String json = api.run();
            result.setJson(json);
            assertion.run(json);
        } catch (Exception e) {
            result.setStatus(Result.RunStatus.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    public ApiTestCase() {
        this.name = null;
    }

    public ApiTestCase(String name) {
        this.name = name;
    }

    public Api getApi() {
        return api;
    }

    public void setApi(Api api) {
        this.api = api;
    }

    public Assertion getAssertion() {
        return assertion;
    }

    public void setAssertion(Assertion assertion) {
        this.assertion = assertion;
    }
}
