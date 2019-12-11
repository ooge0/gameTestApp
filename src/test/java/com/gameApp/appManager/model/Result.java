package com.gameApp.appManager.model;

public class Result {
    public String level;
    public String value;
    public Integer numVotes;

    @Override
    public String toString() {
        return "\t\tResult { " +
                "level='" + level + '\'' +
                ", value='" + value + '\'' +
                ", numVotes=" + numVotes +
                " }\n";
    }

    public String getLevel() {
        return level;
    }

    public String getValue() {
        return value;
    }

    public Integer getNumVotes() {
        return numVotes;
    }
}
