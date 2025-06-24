package com.Nandan.MapUtility;

public class Pair implements Comparable<Pair>{
        String vertex;
        int option;

        public Pair(int option, String vertex) {
            this.vertex = vertex;
            this.option = option;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.option, other.option);
        }

    public int getOption() {
        return option;
    }

    public String getVertex() {
        return vertex;
    }
}
