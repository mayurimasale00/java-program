import java.util.*;

public class bBricks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[][] grid = new char[n][n];

        int startRow = 0, startCol = 0;

       
        for (int r = 0; r < n; r++) {
            String s = sc.next();
            int col = 0;

            for (int i = 0; i < s.length();) {
                int len = 0;

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    len = len * 10 + (s.charAt(i) - '0');
                    i++;
                }

                char type = s.charAt(i++);

                for (int k = 0; k < len; k++) {
                    grid[r][col] = type;

                    if (type == 'S') {
                        startRow = r;
                        startCol = col;
                    }

                    col++;
                }
            }
        }

       
        int[][] brickId = new int[n][n];
        for (int[] row : brickId)
            Arrays.fill(row, -1);

        int id = 0;

        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                if (grid[r][c] == 'G' && brickId[r][c] == -1) {
                    int end = c;

                    while (end + 1 < n && grid[r][end + 1] == 'G')
                        end++;

                    if (end > c) {
                        for (int k = c; k <= end; k++)
                            brickId[r][k] = id++;

                    }
                }
            }
        }

        
        for (int c = 0; c < n; c++) {
            for (int r = 0; r < n; r++) {

                if (grid[r][c] == 'G' && brickId[r][c] == -1) {
                    int end = r;

                    while (end + 1 < n &&
                           grid[end + 1][c] == 'G' &&
                           brickId[end + 1][c] == -1)
                        end++;

                    for (int k = r; k <= end; k++)
                        brickId[k][c] = id;

                    id++;
                }
            }
        }

        
        int[][] distance = new int[n][n];

        for (int[] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);

        Deque<int[]> queue = new ArrayDeque<>();

        distance[startRow][startCol] = 0;
        queue.add(new int[]{startRow, startCol});

        int[] rowMove = {-1, 1, 0, 0};
        int[] colMove = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int[] current = queue.pollFirst();
            int r = current[0];
            int c = current[1];

            if (grid[r][c] == 'D') {
                System.out.println(distance[r][c]);
                return;
            }

            for (int d = 0; d < 4; d++) {

                int nr = r + rowMove[d];
                int nc = c + colMove[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                    continue;

                if (grid[nr][nc] == 'R')
                    continue;

                int cost = 0;

               
                if (grid[nr][nc] == 'G' &&
                    brickId[r][c] != brickId[nr][nc]) {
                    cost = 1;
                }

                if (distance[r][c] + cost < distance[nr][nc]) {

                    distance[nr][nc] = distance[r][c] + cost;

                    if (cost == 0)
                        queue.addFirst(new int[]{nr, nc});
                    else
                        queue.addLast(new int[]{nr, nc});
                }
            }
        }
    }
}
