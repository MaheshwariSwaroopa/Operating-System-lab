import java.util.*;

class Fcfs
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		//Declaring a variable for number of processes
		int number;
		System.out.println("Enter number of processes");
		number=sc.nextInt();
		//Declaring an integer array for arrival time of length number of processes
		int arrival[]=new int[number];
		//Declaring an integer array for burst time of length number of processes
		int burst[]=new int[number];
		//Declaring an integer array for turnaround time of length number of processes
		int turnaround[]=new int[number];
		//Declaring an integer array for waiting time of length number of processes
		int waiting[]=new int[number];
		//Declaring an integer array for completion time of length number of processes +1
		int completion[]=new int[number+1];
		//Declaring a float variable and assigning it to zero
		float averageturnaround=0;
		//Declaring a float variable and assigning it to zero
		float averagewaiting=0;
		System.out.println("Enter burst time of process ");
		for(int i=0;i<number;i++)
		{
			burst[i]=sc.nextInt();
		}
		System.out.println("Enter the arrival time of process ");
		for(int i=0;i<number;i++)
		{
			arrival[i]=sc.nextInt();
		}
		
		completion[0]=0;
		for(int i=1;i<number+1;i++)
		{
			completion[i]=completion[i-1]+burst[i-1];
		}
		for(int i=0;i<number;i++)
		{
			turnaround[i]=completion[i+1]-arrival[i];
			waiting[i]=completion[i]-arrival[i];
		}
		System.out.println("Grantt Chart\n");
		System.out.println("Process"+"		"+"Bursttime"+"		"+"Arrivaltime"+"		"+"Turnaroundtime"+"		"+"Waitingtime"+"		"+"Exittime");
		for(int i=0;i<number;i++)
		{
			System.out.println(i+1+"		"+burst[i]+"			"+arrival[i]+"			"+turnaround[i]+"			"+waiting[i]+"			"+completion[i+1]);
		}
		
		for(int i=0;i<number;i++)
		{
			averageturnaround+=turnaround[i];
			averagewaiting+=waiting[i];
		}
		System.out.println("Average Turnaround time "+(averageturnaround/number));
		System.out.println("Average waiting time "+(averagewaiting/number));
		System.out.println("Number of context Switches "+number-1);
    }
}