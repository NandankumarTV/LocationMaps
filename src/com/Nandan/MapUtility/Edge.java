package com.Nandan.MapUtility;

public class Edge {

    String to;

    int time;

    int distance;

    int cost;

    public Edge(String to, int time, int distance, int cost) {

        this.to = to;

        this.time = time;

        this.distance = distance;

        this.cost = cost;

    }

    public int getCost() {
        return this.cost;
    }

    public String getTo() {
        return this.to;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getTime() {
        return this.time;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setTo(String to) {
        this.to = to;
    }
}


