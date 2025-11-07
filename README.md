# 🗺️ Location Map

A Java-based **path-finding and network management system** built using **IntelliJ IDEA**.  
It allows **admins** to manage a set of interconnected locations (points) and **users** to find the best route between them based on **distance, cost, or time**, with road and rail filters.

---

## 📖 Overview

**Location Map** simulates a virtual map system where you can:
- Add and connect locations (nodes and edges)
- Calculate shortest paths using **Dijkstra’s algorithm**
- Filter routes based on travel type (road/rail/both)
- Choose optimization criteria — **time**, **distance**, or **cost**

The program runs entirely on the console with an **interactive menu** for both admin and user roles.

---

## 🧰 Tech Stack

- **Language:** Java  
- **IDE:** IntelliJ IDEA  
- **Core Concepts:** Collections, Dijkstra’s Algorithm, Object-Oriented Programming  

---

## 👥 Interfaces

### 🧑‍💼 Admin
Admin can:
- Add a new location point  
- Add connections (edges) between points  
- Update existing routes  
- Delete points or connections  

### 👤 User
User can:
- View available routes  
- Choose start and destination points  
- Apply filters (road, rail, or both)  
- Find shortest path based on:
  - Time  
  - Distance  
  - Cost  

---

## ⚙️ Features

✅ Add, update, or delete locations dynamically  
✅ Connect two points with parameters — time, distance, and cost  
✅ Dijkstra’s algorithm to find optimal path  
✅ Multiple filters: road-only, rail-only, or mixed  
✅ Console-based visual output for roads and rails  
✅ Predefined initial graph setup  

---

## 🧩 Project Structure

```
LocationMap/
 ├─ src/
 │   ├─ com/Nandan/Map/
 │   │   ├─ LocationMap.java
 │   │   └─ (other helper classes)
 │   └─ com/Nandan/MapUtility/
 │       ├─ Edge.java
 │       └─ Pair.java
 └─ README.md
```

---

## 🚀 How to Run

1. Open the project in **IntelliJ IDEA** (or any Java IDE).  
2. Ensure your JDK (Java 17 or above) is set up.  
3. Run the `locationMain()` method from the `LocationMap` class.  
4. Choose your role from the menu:
   - **Admin work**
   - **Use the map**
   - **Exit**

---

## 🧮 Algorithms Used

- **Dijkstra’s Algorithm** for shortest path calculation  
  - Can be based on **time**, **distance**, or **cost**  
  - Supports filters for **road**, **rail**, or **both**  
- **Priority Queue (Min-Heap)** for efficient shortest-path computation  

---

## 🗺️ Example Console Flow

**Main Menu**
```
------------------------------- Welcome to Map App ---------------------------------
Option 1 :- Admin work
Option 2 :- To use the Map
Option 3 :- Exit
```

**Admin Menu**
```
Option 1 :- To Add Point
Option 2 :- To Add Edge
Option 3 :- To Update Edge
Option 4 :- To delete Point
Option 5 :- To delete Edge
Option 6 :- To stop the admin work
```

**User Menu**
```
Option 1 :- Based on distance
Option 2 :- Based on Cost effective
Option 3 :- Based on time
Option 4 :- To close the Path finder App
```

---

## 📊 Sample Output
```
---------------------  2 hr 30 min  -----------------------
mahadevpura
   |    |
garudacharpalya
   |____|
bangalore
   |____|
chennai
----------------------- andra ------------------------
```

---

## 🧠 Concepts Covered

- Graph data structures  
- Adjacency list representation  
- Bidirectional edge creation  
- Interactive console-based menu system  
- Object-oriented modular design  

---

## 👨‍💻 Author

**Nandan Kumar T V**  
🔗 [GitHub](https://github.com/NandankumarTV)

---


