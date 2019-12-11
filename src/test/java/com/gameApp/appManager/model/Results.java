package com.gameApp.appManager.model;

import java.util.List;

public class Results {
    public String numPlayers;
    public List<Result> result;

    @Override
    public String toString() {
        return "\n\tResults [" +
                " numPlayers: '" + numPlayers + '\'' +
                "],  \n" + result.toString();
    }

    public List<Result> getResult() {
        return result;
    }
}