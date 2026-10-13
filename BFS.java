import java.util.*;
public class BFS{
static int n,m;
static ArrayList<Integer>[] graph;
static int startA,startB,destination;
static ArrayList<Integer> pathsA=new ArrayList<>();
static ArrayList<Integer> pathsB=new ArrayList<>();
static void findPaths(int cur,int end,int visit,ArrayList<Integer> list){
if(cur==end){
list.add(visit);
return;
}
for(int x:graph[cur]){
if((visit&(1<<x))==0){
findPaths(x,end,visit|(1<<x),list);
}
}
}
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
n=sc.nextInt();
m=sc.nextInt();
graph=new ArrayList[n+2];
for(int i=0;i<graph.length;i++) graph[i]=new ArrayList<>();
for(int i=0;i<m;i++){
int a=sc.nextInt();
int b=sc.nextInt();
graph[a].add(b);
graph[b].add(a);
}
startA=sc.nextInt();
startB=sc.nextInt();
destination=sc.nextInt();
findPaths(startA,destination,1<<startA,pathsA);
findPaths(startB,destination,1<<startB,pathsB);
int ans=Integer.MAX_VALUE;
for(int a:pathsA){
for(int b:pathsB){
int same=a&b&~(1<<destination);
if(same==0){
int count=Integer.bitCount((a|b)&~(1<<destination));
if(count<ans) ans=count;
}
}
}
if(ans==Integer.MAX_VALUE) System.out.println("Impossible");
else System.out.println(ans);
sc.close();
}
}