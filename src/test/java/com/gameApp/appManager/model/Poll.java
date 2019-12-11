package com.gameApp.appManager.model;


import java.util.List;

public class Poll {
    public String name;
    public String title;
    public Integer totalVotes;
    public List<Results> results;

    @Override
    public String toString() {
        return "\tPoll [" +
                "name: '" + name + '\'' +
                ", title: '" + title + '\'' +
                ", totalVotes: " + totalVotes +
                "] \n\t" + results.toString() + "\n";
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public Integer getTotalVotes() {
        return totalVotes;
    }

    public List<Results> getResults() {
        return results;
    }
}
