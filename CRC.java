import java.util.Arrays;
import java.util.Scanner;

public class CRC {
    static int[] computeCRC(int[] mesg,int[] gen){
        int current=0;
        int [] temp=new int[mesg.length];
        for (int i = 0; i < mesg.length; i++)
            temp[i]=mesg[i];

        while(true){
            for(int i=0;i<gen.length;i++)
                temp[i+current]^=gen[i];
            while(current<mesg.length&&temp[current]==0)
                current++;
            if(temp.length-current<gen.length)
                break;
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter number of message bits");
        int msg_bits=in.nextInt();
        int[] msg=new int[msg_bits];
        System.out.println("Enter the message bits");
        for(int i=0;i<msg_bits;i++)
            msg[i]=in.nextInt();

        System.out.println("Enter number of generator bits");
        int gen_bits=in.nextInt();
        int[] gen=new int[gen_bits];
        System.out.println("Enter the generator bits");
        for(int i=0;i<gen_bits;i++)
            gen[i]=in.nextInt();

        int tot_bits=msg_bits+gen_bits-1;
        int fullMessage[]=new int[tot_bits];
        int sentMessage[]=new int[tot_bits];
        int rem[];

        for(int i=0;i<msg_bits;i++)
            fullMessage[i]=msg[i];

        System.out.println("The message is ");
        for(int i:msg)
            System.out.print(i);

        System.out.println("\nThe generator is ");
        for(int i:gen)
            System.out.print(i);

        System.out.println("\nThe appended message is ");
        for(int i:fullMessage)
            System.out.print(i);

        rem=computeCRC(fullMessage,gen);

        for(int i=0;i<tot_bits;i++)
            sentMessage[i]=(fullMessage[i]^rem[i]);
        System.out.println("\nThe sent message is ");
        for(int i:sentMessage)
            System.out.print(i);


        int[] recv_msg=new int[tot_bits];
        System.out.println("\nEnter the "+tot_bits+" bit message recieved ");
        for(int i=0;i<tot_bits;i++)
            recv_msg[i]=in.nextInt();

        System.out.println("The recieved message is ");
        for(int i:recv_msg)
            System.out.print(i);
        rem=computeCRC(recv_msg,gen);
        if(Arrays.binarySearch(rem,1)<0)
            System.out.println("\nNo error");
        else
            System.out.println("\nError found");
    }
}
