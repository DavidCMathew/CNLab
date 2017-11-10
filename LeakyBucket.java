import java.util.Scanner;

public class LeakyBucket {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter bucket size");
        int bucket=in.nextInt();

        System.out.println("Enter the number of groups");
        int groups=in.nextInt();

        int[] packets = new int[groups];
        int[] bandwidth = new int[groups];

        int total_packets=0;
        int total_bandwidth=0;
        for(int i=0;i<groups;i++){
            System.out.print("\nEnter the packets for group "+(i+1)+":");
            packets[i]=in.nextInt();

            while(packets[i]+total_packets>bucket){
                System.out.println("Bucket overflow:Enter a value smaller than "+(bucket-total_packets+1));
                packets[i]=in.nextInt();
            }

            System.out.print("\nEnter the bandwidth for group "+(i+1)+":");
            bandwidth[i]=in.nextInt();

            total_packets+=packets[i];
            total_bandwidth+=packets[i]*bandwidth[i];
        }

        System.out.println("Total number of packets is "+total_packets);
        System.out.println("Total bandwidth needed is "+total_bandwidth);

        System.out.println("Enter the output bandwidth");
        int out_bw=in.nextInt();

        while(total_bandwidth>out_bw&&total_packets>0){
            System.out.println("Data Sent");
            System.out.println("Packets Remaining= "+(--total_packets));
            System.out.println("Bandwidth remaining = "+(total_bandwidth-=out_bw));
            if(total_bandwidth<out_bw&&total_packets>0)
                System.out.println(total_packets+" discarded due to insufficient bandwidth");
        }

    }
}
