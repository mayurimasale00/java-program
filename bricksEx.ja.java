import java.util.*;
public class bricksEx {

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();


        char[][] charater = new char[size][size];
        int[][] ID = new int[size][size];
        int bricks = 0 , sourse = 0 , destination = 0;
        
        for(int row = 0 ; row <size ; row++){
            String sour = sc.next();
            int col = 0 ;
        
        for(int i = 0 ; i<sour.length()){
            int len = 0 ;
            while(i<sour.length() && Charatcter.isDigit(sour.charAt(i)))
            len=len*10+sour.charAt(i++) -'0';
            char ch = sour.charAt(i++);
            

            for(int k = 0; k<len;k++){
                charater[row][col] = ch;
                if(ch == 'S') source = bricks;
                if ch(ch =='D')destination = bricks;
                col++;
            }
            bricks++;

        }

        }

        int[] dist = new int[bricks];
        Arrays.fill(dist , Integer.MAX_VALUE);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[S] = 0 ;
        q.add(S);
        int[] drow = {-1 , 1, 0 , 0};
        
        int[] dcol ={0 , 0 , -1 , 1};

        while(!q.isEmpty()){
            int u = q.pop();
            for(int row = 0 ; row < size ; row ++)
            {
                for(int col = 0 ; col < size ; col++ )
                {
                    if(id[row][col] ! = u)
                    continue;
                    for(int k = 0 ; k < 4 ; k++){

                        int nrow = row + drow[k] , ncol = col +dcol[k];

                        if(nrow < 0 || nrow >= size || ncol < 0 || ncol>= size) continue ;
                        int v = ID[nrow][ncol];

                        if(v==u || charater[nrow][ncol] == 'R') continue;
                       int const = type[nrow][ncol] == 'G' ? 1 :0 ;

                       if(dist[u] + cost < dist[v]){
                        dist[v] dist[u] + cost ;
                        if(cost == 0)
                        q.addFirst(v);
                        else
                        q.addLast(v);
                       }
                    
                }
            }
        }
       
    }
     System.out.println(dist[D]);
}
}