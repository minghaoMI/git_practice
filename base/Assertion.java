package com.xiaomi.search.global.cms.goldenset.base;

/**
 * Created by minghao on 16-7-7.
 */
public abstract class Assertion {

    protected String name;

    public abstract void run(String json) throws Exception;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
