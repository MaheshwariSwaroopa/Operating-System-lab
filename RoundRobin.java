import java.util.Scanner;
import java.lang.*;
public class RoundRobin
{
	public static void main(String args[])
	{
		int processes;
		Scanner input=new Scanner(System.in);
		System.out.print("Enter number of processes: ");
		processes=input.nextInt();
		int[] BurstTime = new int[processes];
		int[] ArrivalTime = new int[processes];
		int[] TurnaroundTime = new int[processes];
		int[] WaitingTime = new int[processes];
		int[] ExitTime = new int[processes];
		int[] temp1=new int[processes];
		float avgturnaround=0;
		float avgwaitingtime=0;
		int quantumtime;
			
		int total=0;
		System.out.print("Enter Burst times of processes: ");
		int count1=0,temp;
		for(int i=0;i<processes;i++)
		{
			BurstTime[i]=input.nextInt();
			temp1[i]=BurstTime[i];
		}
		System.out.print("Enter Arrival time of processes: ");
		for(int i=0;i<processes;i++)
			ArrivalTime[i]=input.nextInt();
		System.out.print("quantumtime: ");
		quantumtime=input.nextInt();
		int currenttime=0,count=0;
		for(int i=0;i<processes;i++)
		{
		temp= BurstTime[i]/quantumtime;	
		if(temp*quantumtime==BurstTime[i])
				count1+=temp;
			else
				count1+=(temp+1);
			total+=BurstTime[i];
		}
		while(count<processes)
		{
			
			for(int i=0;i<processes;i++)
			{
				//System.out.println(BurstTime[i]+" "+i);
				
				if(BurstTime[i]>quantumtime)
				{
					BurstTime[i]-=quantumtime;
					currenttime+=quantumtime;
				}
				else if(BurstTime[i]<=quantumtime && BurstTime[i]!=0)
				{
					currenttime+=BurstTime[i];
					BurstTime[i]=0;
						TurnaroundTime[i]=currenttime;
						count++;
				}
				
		    }
				}
		for(int i=0;i<processes;i++)
		{
			ExitTime[i]=TurnaroundTime[i];
			TurnaroundTime[i]=TurnaroundTime[i]-ArrivalTime[i];
			avgturnaround+=TurnaroundTime[i];
		}
		for(int i=0;i<processes;i++)
		{
			WaitingTime[i]=TurnaroundTime[i]-temp1[i];
			avgwaitingtime+=WaitingTime[i];
		}
		avgturnaround=avgturnaround/processes;
		avgwaitingtime=avgwaitingtime/processes;
		System.out.println("process   \tBursttime\tarrivaltime\tTurnaroundtime\tWaitingtime\tExittime");
		for(int i=0;i<processes;i++)
		  System.out.println("p"+i+"\t\t"+temp1[i]+"\t\t"+ArrivalTime[i]+"\t\t"+TurnaroundTime[i]+"\t\t"+WaitingTime[i]+"\t\t"+ExitTime[i]);
	    System.out.println("Average Turnaround time : "+avgturnaround);
		System.out.println("Average Wating time : "+avgwaitingtime);	
		System.out.println("Number of content Swiches: "+(count1-1));
	}
}