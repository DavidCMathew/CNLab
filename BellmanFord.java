import java.util.Scanner;

public class BellmanFord {
    static int D[];
    static int vert;
    static int max = 999;

    public static void evaluate(int src,int[][]A){
        D = new int[vert+1];
        for(int i=1;i<=vert;i++)
            D[i]=max;
        D[src]=0;
        for(int n=1;n<=vert;n++)
            for(int s=1;s<=vert;s++)
                for(int d=1;d<=vert;d++)
                    if(A[s][d]!=max)
                        if(D[d]>D[s]+A[s][d])
                            D[d]=D[s]+A[s][d];

        for(int n=1;n<=vert;n++)
            for(int s=1;s<=vert;s++)
                for(int d=1;d<=vert;d++)
                    if(A[s][d]!=max)
                        if(D[d]>D[s]+A[s][d])
                            System.out.println("Negative edge cycle found");

        for(int v=1;v<=vert;v++)
            System.out.println("Distance from "+v+" to "+src+" is "+D[v]);
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter number of nodes ");
        vert=in.nextInt();
        int A[][]=new int[vert+1][vert+1];
        System.out.println("Enter the adjacency matrix ");
        for(int i=1;i<=vert;i++)
            for(int j=1;j<=vert;j++)
                A[i][j] = in.nextInt();
        System.out.println("Enter the source vertex");
        int src = in.nextInt();

        evaluate(src,A);
    }
}
