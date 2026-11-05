
public class Assignment01Q05 {

    public static int findShortestPath(int[][] m, int i, int j) {

        int n = m.length;

        // The shortest path from a vertex to itself is 0
        if (i == j) {
            return 0;
        }

        // Store distances from the starting vertex
        int[] distance = new int[n];

        for (int k = 0; k < n; k++) {
            distance[k] = -1;
        }

        // Implement a queue using an array
        int[] queue = new int[n];
        int front = 0;
        int rear = 0;

        // Start BFS from vertex i
        queue[rear++] = i;
        distance[i] = 0;

        while (front < rear) {

            int current = queue[front++];

            // Check all possible neighbors
            for (int neighbor = 0; neighbor < n; neighbor++) {

                if (m[current][neighbor] == 1 &&
                    distance[neighbor] == -1) {

                    distance[neighbor] = distance[current] + 1;

                    if (neighbor == j) {
                        return distance[neighbor];
                    }

                    queue[rear++] = neighbor;
                }
            }
        }

        // No path exists
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1));
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1));
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2));
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2));
    }
}
