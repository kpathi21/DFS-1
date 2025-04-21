import java.util.LinkedList;
import java.util.Queue;

public class NearestZero {
        int[][] dirs;
        int m, n;

        public int[][] updateMatrix(int[][] mat) {
            this.dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
            this.m = mat.length;
            this.n = mat[0].length;

            Queue<int[]> q = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 0) {
                        q.add(new int[] { i, j });
                    } else {
                        mat[i][j] *= -1;
                    }
                }
            }

            int dist = 1;

            while (!q.isEmpty()) {
                int size = q.size();
                for (int k = 0; k < size; k++) {
                    int[] curr = q.poll();
                    for (int[] dir : dirs) {
                        int r = dir[0] + curr[0];
                        int c = dir[1] + curr[1];

                        if (r >= 0 && c >= 0 && r < m && c < n && mat[r][c] == -1) {
                            q.add(new int[] { r, c });
                            mat[r][c] = dist;
                        }
                    }
                }
                dist++;
            }

            return mat;
        }
    }

//TC: O(m*n), SC: O(m*n)
