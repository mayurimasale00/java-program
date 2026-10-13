import java.util.*;
public class cubeAquestion {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int nNum = sc.nextInt();
        int[][] range = new int[nNum][3];
        String[] str = new String[nNum];

        for(int i = 0; i <nNum ; i++)
        {
            range[i][0] = sc.nextInt();
            range[i][1]= sc.nextInt();
            str[i] = sc.next();

        }

        int test = sc.nextInt();
        Map<Integer , int[]>p = new HashMap<>();
        p.put(1,new int[]{0,0});

        for(int i = 0;i<nNum;i++)
        {
            int a = range[i][0] , b = range[i][1];
            int[] q =p.get(a);
            int x = q[0] , y = q[1];

            if(str[i].equals("right")) x++;
            if(str[i].equals("left")) x--;
            if(str[i].equals("top")) y++;
            if(str[i].equals("down")) y--;
            p.put(b,new int[]{x,y});
        }

        int[] q = p.get(test);
        int x = q[0] , y = q[1];

        for (int k:new int[]{1,-1,2,-2})
        {
            int ans = -1;
            for(int i : p.keySet())
            {
                int z[] = p.get(i);

                if((k == 1 && z[0]== x && z[1] == y+1 ||
                k == -1 && z[0]== x && z[1] == y-1 ||
                k == 2 && z[0] == x-1 && z[1] == y ||
                k == -2 && z[0]== x+1 && z[1] == y ))
                ans =i;
            }
            System.out.println(ans + " ");
        }
    }
}
