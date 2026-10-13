import java.util.*;

public class bricksByEx {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

int size = sc.nextInt();

char[][] grid = new char[size][size];
int[][] ID = new int[size][size];

int bricks = 0;
int source = 0;
int destination = 0;

for (int row = 0; row < size; row++) {

String s = sc.next();
int col = 0;

for (int i = 0; i < s.length();) {

int len = 0;

while (i < s.length() && Character.isDigit(s.charAt(i))) {
len = len * 10 + (s.charAt(i) - '0');
i++;
}

char ch = s.charAt(i++);

for (int k = 0; k < len; k++) {

grid[row][col] = ch;
ID[row][col] = bricks;

if (ch == 'S')
source = bricks;

if (ch == 'D')
destination = bricks;

col++;
}

bricks++;
}
}

int[] dist = new int[bricks];
Arrays.fill(dist, Integer.MAX_VALUE);

ArrayDeque q = new ArrayDeque<>();

dist[source] = 0;
q.add(source);

int[] drow = {-1, 1, 0, 0};
int[] dcol = {0, 0, -1, 1};

while (!q.isEmpty()) {

int u = q.poll();

for (int row = 0; row < size; row++) {

for (int col = 0; col < size; col++) {

if (ID[row][col] != u)
continue;

for (int k = 0; k < 4; k++) {

int nrow = row + drow[k];
int ncol = col + dcol[k];

if (nrow < 0 || nrow >= size ||
ncol < 0 || ncol >= size)
continue;

int v = ID[nrow][ncol];

if (v == u || grid[nrow][ncol] == 'R')
continue;
}
}
}
}}}