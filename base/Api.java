package com.xiaomi.search.global.cms.goldenset.base;

/**
 * Created by minghao on 16-7-7.
 */
public abstract class Api {

    protected String name;

    public abstract String run() throws Exception;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
