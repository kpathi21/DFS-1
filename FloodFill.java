import java.util.LinkedList;
import java.util.Queue;

//Approach-1 : BFS
public class FloodFill {
    int[][] dirs;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        int m = image.length, n = image[0].length;

        int originalColor = image[sr][sc];
        if (originalColor == color)
            return image;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : dirs) {
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];

                if (r >= 0 && c >= 0 && r < m && c < n && image[r][c] == originalColor) {
                    image[r][c] = color;
                    q.add(new int[]{r, c});
                }
            }
        }

        return image;
    }
}

//TC: O(m*n), sc: O(m*n);

//Approach 2: DFS
class Solution {
    int[][] dirs;
    int m, n, originalColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        this.m = image.length;
        this.n = image[0].length;

        this.originalColor = image[sr][sc];
        if (originalColor == color)
            return image;

        dfs(image, sr, sc, color);

        return image;
    }

    private void dfs(int[][] image, int r, int c, int color) {
        image[r][c] = color;

        for (int[] dir : dirs) {
            int i = r + dir[0];
            int j = c + dir[1];
            if (i >= 0 && j >= 0 && i < m && j < n && image[i][j] == originalColor) {
                dfs(image, i, j, color);
            }

        }
    }
}

//TC: O(m*n), sc: O(m*n);