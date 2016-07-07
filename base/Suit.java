package com.xiaomi.search.global.cms.goldenset.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minghao on 16-7-7.
 */
public class Suit {

    protected String name;

    protected List<Case> cases;

    public Suit() {
        name = null;
        cases = new ArrayList<Case>();
    }

    public Suit(String name) {
        this.name = name;
        this.cases = new ArrayList<Case>();
    }

    public List<Result> run() {
        System.out.println("Run in suit");
        List<Result> results = new ArrayList<Result>();
        for (int i = 0; i < cases.size(); ++ i) {
            results.add(cases.get(i).run());
        }
        return results;
    }

    public void addCase(Case cas) {
        cases.add(cas);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }
}
