package com.example.gfa.myapplication.model;

import java.util.List;

public class WorksBySubjectResponse {

    String subjectType;
    String name;
    String key;
    int ebookCount;
    List<Work> works;


    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getEbookCount() {
        return ebookCount;
    }

    public void setEbookCount(int ebookCount) {
        this.ebookCount = ebookCount;
    }

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }
}
