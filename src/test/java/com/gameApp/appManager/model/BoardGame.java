package com.gameApp.appManager.model;

import java.util.List;

public class BoardGame {
    public Integer objectId;
    public List<Poll> poll;

    @Override
    public String toString() {
        return "BoardGame objectId: " + objectId +
                ", pollList: " + poll.toString() +
                '}';
    }

    public List<Poll> getPoll() {
        return poll;
    }

    public Integer getObjectId() {
        return objectId;
    }
}