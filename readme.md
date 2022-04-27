# Depth-First Search Algorithm (DFS)

This algorithm gets a graph as an adjacency matrix input and discovers all reachable nodes by using DFS.

**Inputs**
* Dimensions of the adjacency matrix
* Values of the adjacency matrix
* Start node for the search

In a regular DFS, when a node has multiple neighbors, next node can be any of these neighbors. However, for the
consistency between answers, here the node with the smallest number is selected.

**Sample Input**

5\
1 0 0 1 0\
0 0 0 0 1\
0 0 1 0 0\
1 1 1 1 0\
0 0 1 0 0\
3

Input graph:

<img src="https://user-images.githubusercontent.com/36201330/165468833-2e6fd4c3-08e0-4865-a332-a62b4e251472.png" width=400>

5 means that the input matrix has a size of 5x5.
Then, the following 25 values are read.
3 denotes the starting point of DFS.

**Sample Output**

3 0 1 2 4