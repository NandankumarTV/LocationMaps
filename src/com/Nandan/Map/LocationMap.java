package com.Nandan.Map;

import com.Nandan.MapUtility.Edge;
import com.Nandan.MapUtility.Pair;

import java.util.*;

public class LocationMap {
    private static HashMap<String, List<Edge>> srcAdjList = new HashMap<>();

    private static HashMap<String, String> pointType = new HashMap<>();

    public static boolean addNode(String namePoint, String typeOfPoint) {

        if (srcAdjList.containsKey(namePoint)) {
            return false;
        } else {
            srcAdjList.put(namePoint, new ArrayList<Edge>());
            pointType.put(namePoint, typeOfPoint);
        }
        return true;
    }

    public static boolean CheckEdgePresent(List<Edge> edges, String to) {
        for (Edge edge : edges) {

            if (edge.getTo().equals(to)) {
                return true;
            }
        }
        return false;
    }

    public static boolean addEdge(String start, String to, int time, int distance, int cost) {

        if (srcAdjList.containsKey(start) && srcAdjList.containsKey(to)) {

            List<Edge> edges = srcAdjList.get(start);
            if (CheckEdgePresent(edges, to)) {
                System.out.println("Edges are already present if want to update you can go for update option");
                return true;
            } else {
                Edge newEdge = new Edge(to, time, distance, cost);
                srcAdjList.get(start).add(newEdge);
                newEdge = new Edge(start, time, distance, cost);
                srcAdjList.get(to).add(newEdge);
            }
            return true;
        }
        System.out.println(start+" "+to);
        System.out.println("Make sure points are added before make an connection");
        return false;
    }

    public static void updateEdgeInside(String start, String to, int time, int distance, int cost) {
        for (Edge edge : srcAdjList.get(start)) {
            if (edge.getTo().equals(to)) {
                edge.setTime(time);
                edge.setDistance(distance);
                edge.setCost(cost);
            }
        }
    }

    public static boolean updateEdge(String start, String to, int time, int distance, int cost) {
        if (srcAdjList.containsKey(start) && srcAdjList.containsKey(to)) {
            List<Edge> edges = srcAdjList.get(start);
            if (CheckEdgePresent(edges, to)) {
                updateEdgeInside(start, to, time, distance, cost);
                updateEdgeInside(to, start, time, distance, cost);
            }
        }
        return true;
    }

    public static void deleteEdgeInside(String src, String dest) {
        for (int i = 0; i < srcAdjList.get(src).size(); i++) {
            if (srcAdjList.get(src).get(i).getTo().equals(dest)) {
                srcAdjList.get(src).remove(i);
                return;
            }
        }
        return;
    }

    public static boolean deleteNode(String namePoint) {
        if (srcAdjList.containsKey(namePoint)) {
            for (Edge edge : srcAdjList.get(namePoint)) {
                String src = edge.getTo();
                deleteEdgeInside(src, namePoint);
            }
            srcAdjList.remove(namePoint);
        }
        return true;
    }

    public static boolean deleteEdge(String src, String dest) {
        if (srcAdjList.containsKey(src) && srcAdjList.containsKey(dest)) {
            deleteEdgeInside(src, dest);
            deleteEdgeInside(dest, src);
        }
        return true;
    }

    public static void getAddPoint(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of point");
        String namePoint = sc.nextLine();
        System.out.println("Enter the type of point");
        System.out.println("For road enter : 1 ");
        System.out.println("For rail point enter : 2");
        int typePointOption = sc.nextInt();
        sc.nextLine();
        String typePoint;
        if(typePointOption == 1){
                typePoint = "road";
        }
        else if(typePointOption == 2){
            typePoint = "rail";
        }
        else{
            System.out.println("Not added please try with the valid option");
            return;
        }
        if(addNode(namePoint,typePoint)){
            System.out.println();
            System.out.println("Added successfully");
            System.out.println();
        }
        else{
            System.out.println();
            System.out.println("same name of the point is already present");
            System.out.println();
        }
        return;
    }

    public static void getAddEdge(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting point ; - ");
        String start = sc.nextLine();
        System.out.println("Enter the destination point ; - ");
        String to = sc.nextLine();
        System.out.println("Enter the time taken to reach the destination :- ");
        int time = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the distance ; - ");
        int distance = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the cost fo travel ; - ");
        int cost = sc.nextInt();
        sc.nextLine();
        addEdge(start,to,time,distance,cost);
    }

    public static void getUpdateEdge(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting point ; - ");
        String start = sc.nextLine();
        System.out.println("Enter the destination point ; - ");
        String to = sc.nextLine();
        System.out.println("Enter the time taken to reach the destination :- ");
        int time = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the distance ; - ");
        int distance = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the cost fo travel ; - ");
        int cost = sc.nextInt();
        sc.nextLine();
        updateEdge(start,to,time,distance,cost);
    }

    public static void getDeletePoint(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of point");
        String namePoint = sc.nextLine();
        deleteNode(namePoint);
        return;
    }

    public static void getDeleteEdge(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting point ; - ");
        String start = sc.nextLine();
        System.out.println("Enter the destination point ; - ");
        String to = sc.nextLine();
        deleteEdge(start,to);
    }

    public static void adminWork(){
        while(true) {
            System.out.println();
            System.out.println("---------------------------------Admin work--------------------------------------------");
            System.out.println();
            System.out.println("Option 1 :- To Add Point");
            System.out.println("Option 2 :- To Add Edge");
            System.out.println("Option 3 :- To Update Edge");
            System.out.println("Option 4 :- To delete Point");
            System.out.println("Option 5 :- To delete Edge");
            System.out.println("Option 6 :- To stop the admin work");
            System.out.println();
            System.out.println("Please Enter your option :- ");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            sc.nextLine();
            switch (num){
                case 1 : getAddPoint();
                            break;
                case 2 : getAddEdge();
                             break;
                case 3 : getUpdateEdge();
                            break;
                case 4 : getDeletePoint();
                            break;
                case 5 : getDeleteEdge();
                             break;
                case 6 : return;

                default :  System.out.println("please enter valid option");
            }
        }
    }

    public  static int getFilter(){
        System.out.println("Select the suitable filter");
        System.out.println("Option 1: via road only");
        System.out.println("Option 2: via rail only");
        System.out.println("Option 3: via both rail and road");
        System.out.println("Please enter your option :- ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        return num;
    }

    public static void basedOnTime(){

        int num = getFilter();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting point ; - ");
        String start = sc.nextLine();
        System.out.println("Enter the destination point ; - ");
        String to = sc.nextLine();
        if(num == 1){
            dijikstraAlgo(start,to,0,1);
        }
        else if(num == 2){
            dijikstraAlgo(start, to,0,2);
        }
        else if (num == 3){
            dijikstraAlgo(start, to,0,3);
        }
        else{
            System.out.println("Please enter valid option");
        }
    }


    public static void basedOnDistance(){

        int num = getFilter();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting point ; - ");
        String start = sc.nextLine();
        System.out.println("Enter the destination point ; - ");
        String to = sc.nextLine();
        if(num == 1){
            dijikstraAlgo(start,to,1,1);
        }
        else if(num == 2){
            dijikstraAlgo(start, to,1,2);
        }
        else if (num == 3){
            dijikstraAlgo(start, to,1,3);
        }
        else{
            System.out.println("Please enter valid option");
        }
    }

    public static void basedOnCost(){

        int num = getFilter();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting point ; - ");
        String start = sc.nextLine();
        System.out.println("Enter the destination point ; - ");
        String to = sc.nextLine();
        if(num == 1){
            dijikstraAlgo(start,to,2,1);
        }
        else if(num == 2){
            dijikstraAlgo(start, to,2,2);
        }
        else if (num == 3){
            dijikstraAlgo(start, to,2,3);
        }
        else{
            System.out.println("Please enter valid option");
        }
    }

    public static void initialiseHashMap(HashMap<String,Integer> storeVolume){
        for (String point : srcAdjList.keySet()){
            storeVolume.put(point,(int)1e9);
        }
    }


    public static int getOption(Edge edge,int option){
        if(option == 0){
            return edge.getTime();
        }
        else if (option == 1){
            return edge.getDistance();
        }
        else {
            return edge.getCost();
        }
    }

    public static boolean getFilterOption(String edgeTo, int optionFilter, String to){
           if(optionFilter == 1){
               if(!(edgeTo.equals(to))){
                   if(pointType.get(edgeTo).equals("rail")){
                       return false;
                   }
                   else{
                       return true;
                   }
               }
               return true;
           }
           else if(optionFilter == 2){
               if(pointType.get(edgeTo).equals("rail")){
                   return true;
               }
               else{
                 return false;
               }
           }
           else{
               return true;
           }
    }

    public static void dijikstraAlgo(String start, String to,int optionType,int optionFilter){
        if(start.equals(to)){
            System.out.println("You are already in that place");
            return;
        }
        HashMap<String, Integer> storeVolume = new HashMap<>();
        HashMap<String, String> prevPoint = new HashMap<>();
        prevPoint.put(start,start);
        initialiseHashMap(storeVolume);
        storeVolume.put(start,0);
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        pq.add(new Pair(0,start));

        while(pq.size() != 0){
            int optionPair = pq.peek().getOption();
            String next = pq.peek().getVertex();
            pq.remove();

            for(Edge edge : srcAdjList.get(next)) {
                int edgeOption = getOption(edge, optionType);
                String edgeTo = edge.getTo();
                if (getFilterOption(edgeTo, optionFilter,to)) {
                    if ((edgeOption + optionPair) < storeVolume.get(edgeTo)) {
                        prevPoint.put(edgeTo, next);
                        storeVolume.put(edgeTo, edgeOption + optionPair);
                        pq.add(new Pair(storeVolume.get(edgeTo), edgeTo));
                    }
                }
            }
        }
        PrintPath(prevPoint,to,storeVolume.get(to),optionType);
        return;
    }

    public static void PrintPath(HashMap<String,String> prevPoint,String to,int resultValue,int optionType){
        if(!(prevPoint.containsKey(to))){
            System.out.println("---------------- No path -------------------");
            return;
        }
        System.out.println();
        if(optionType == 0) {
            int min = (resultValue) / 60;
            int hour = (resultValue) % 60;
            System.out.println("---------------------   " + hour +" hr " +min +" min    -----------------------");
        }
        else if (optionType == 1) {
            System.out.println("---------------------   " + resultValue + " Km    -------------------");
        }
        else {
            System.out.println("---------------------   " + resultValue + " Rupees      -------------------");
        }

        List<String> path = new ArrayList<>();
        while (true){
            path.add(to);
            String prevS = prevPoint.get(to);
            if(prevS.equals(to)){
                break;
            }
            else{
                to = prevS;
            }
        }
        Collections.reverse(path);
        printThePath(path);
    }

    public static void printThePath(List<String> path){
        for(int i = 0; i < path.size()-1; i++){
            String first = path.get(i);
            String second = path.get(i+1);
            printRoadOrRail(first,second);
        }
        System.out.println("----------------------- " + path.get(path.size()-1) + " ------------------------");
    }

    public static void printRoadOrRail(String first,String second){
        String typeOfFirst = pointType.get(first);
        String typeOfSecond = pointType.get(second);
        if(typeOfFirst.equals("road") && typeOfSecond.equals("road")){
            printRoad(first);
        }
        else if(typeOfFirst.equals("road") && typeOfSecond.equals("rail")){
            printRoad(first);
        }
        else if(typeOfFirst.equals("rail") && typeOfSecond.equals("road")){
            printRoad(first);
        }
        if(typeOfFirst.equals("rail") && typeOfSecond.equals("rail")){
            printRail(first);
        }
    }

    public static void printRoad(String first){
        System.out.println();
        System.out.println("                        "+first+"                         ");
        System.out.println("                         |    |                          ");
        System.out.println("                         |    |                          ");
        System.out.println("                         |    |                          ");
        System.out.println("                         |    |                          ");
        System.out.println("                         |    |                          ");
        System.out.println("                         |    |                          ");
        System.out.println();
    }

    public static void printRail(String first){
        System.out.println();
        System.out.println("                        "+first+"                         ");
        System.out.println("                         |____|                          ");
        System.out.println("                         |____|                          ");
        System.out.println("                         |____|                          ");
        System.out.println("                         |____|                          ");
        System.out.println("                         |____|                          ");
        System.out.println("                         |____|                          ");
        System.out.println();
    }

    public static void toUseMap(){
        while(true) {
            System.out.println();
            System.out.println("------------------------------- Welcome to path finder App  -------------------------------");
            System.out.println();
            System.out.println("Option 1 :- Based on distance");
            System.out.println("Option 2 :- Based on Cost effective");
            System.out.println("Option 3 :- Based on time");
            System.out.println("Option 4 :- To close the Path finder App");
            System.out.println();
            System.out.println("Please Enter your option :- ");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            sc.nextLine();
            switch (num){
                case 1 : basedOnDistance();
                    break;
                case 2 : basedOnCost();
                    break;
                case 3 : basedOnTime();
                    break;
                case 4 : return;

                default :  System.out.println("please enter valid option");
            }
        }
    }


    public static void initialiseGraph(){

        // added all the points
        addNode("mahadevpura","road");
        addNode("garudacharpalya","road");
        addNode("majestic","road");
        addNode("madugiri","road");
        addNode("theetha","road");
        addNode("koratagere","road");
        addNode("tumkur","rail");
        addNode("hubli","rail");
        addNode("shivamogga","rail");
        addNode("andra","rail");
        addNode("hydrabad","rail");
        addNode("chennai","rail");
        addNode("bangalore","rail");

        // added all the edges
        addEdge("mahadevpura","garudacharpalya",6,8,9);
        addEdge("mahadevpura","majestic",15,10,15);
        addEdge("garudacharpalya","bangalore",10,30,40);
        addEdge("majestic","bangalore",45,50,60);
        addEdge("bangalore","chennai",15,50,100);
        addEdge("bangalore","hydrabad",12,64,120);
        addEdge("chennai","andra",12,55,110);
        addEdge("hydrabad","andra",5,12,50);
        addEdge("andra","shivamogga",10,50,100);
        addEdge("andra","hubli",12,64,120);
        addEdge("shivamogga","tumkur",12,55,110);
        addEdge("hubli","tumkur",5,12,50);
        addEdge("tumkur","theetha",30,26,50);
        addEdge("tumkur","koratagere",20,20,20);
        addEdge("koratagere","theetha",30,12,10);
        addEdge("koratagere","madugiri",10,20,50);
        addEdge("madugiri","theetha",50,33,70);
        
    }
    public static void printingNiegbors() {
        for (String start : srcAdjList.keySet()) {
            System.out.print(start + ":  ");
            for (Edge edge : srcAdjList.get(start)) {
                System.out.print(edge.getTo() + " ");
            }
            System.out.println();
        }
    }
    public static void locationMain(){

        // HardCode the graph
            initialiseGraph();
            System.out.println();
            System.out.println("----------------------------- Initial Set Up fo Graph ------------------------------");
            System.out.println();
            printingNiegbors();
            System.out.println();
            System.out.println("------------------------------- Welcome to Map App ---------------------------------");
            while(true){
                System.out.println("Option 1 :- Admin work");
                System.out.println("Option 2 :- To use the Map");
                System.out.println("Option 3 :- Exit");
                System.out.println();
                System.out.println("Please Enter your option :- ");
                Scanner sc = new Scanner(System.in);
                int num = sc.nextInt();
                sc.nextLine();
                switch (num){
                    case 1 : adminWork();
                                break;
                    case 2 : toUseMap();
                                break;
                    case 3 :
                                //printingNiegbors();
                                System.exit(0);

                    default : System.out.println("Please enter the valid option");
                }
            }
    }
}
