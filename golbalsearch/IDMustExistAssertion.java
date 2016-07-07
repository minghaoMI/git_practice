package com.xiaomi.search.global.cms.goldenset.golbalsearch;

import com.jayway.jsonpath.JsonPath;
import com.xiaomi.search.global.cms.goldenset.base.Assertion;

import java.util.List;

/**
 * Created by minghao on 16-7-7.
 */
public class IDMustExistAssertion extends Assertion {

    private String id;

    public void run(String json) throws Exception {
        System.out.println("Run in IDMustExistAssertion");
        List<String> ids = JsonPath.read(json, "$..id");
        boolean exist = false;
        for (int i = 0; i < ids.size(); ++ i) {
            String val = String.valueOf(ids.get(i));
            if (val.equals(id)) {
                exist = true;
                break;
            }
        }
        if (! exist) {
            throw new Exception("id not in the query result : " + id + "!");
        }
    }

    public IDMustExistAssertion() {
        id = null;
    }

    public IDMustExistAssertion(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
