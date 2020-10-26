import java.util.Scanner;
import java.lang.*;
public class Sjfpreemp
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
		int total=0;
		System.out.print("Enter Burst times of processes: ");
		for(int i=0;i<processes;i++)
		{
			BurstTime[i]=input.nextInt();
			total+=BurstTime[i];
			temp1[i]=BurstTime[i];
		}
		System.out.print("Enter Arrival time of processes: ");
		for(int i=0;i<processes;i++)
			ArrivalTime[i]=input.nextInt();
		int temp=-1,count=0;
		int ii=0;
		int c=0;
		while(ii<total+c)
		{
			int index=-1;
			int minimum=Integer.MAX_VALUE;
			for(int j=0;j<processes;j++)
			{
				if(ii>=ArrivalTime[j] && BurstTime[j]>0)
				{
					if(minimum>BurstTime[j])
					{
					     index=j;
						 minimum=BurstTime[j];
					}
				}
			}
			if(index==-1)
			{
	            c++;
			     ii++;
			}
			    
			else{
			BurstTime[index]-=1;
			if(BurstTime[index]==0)
			{
				TurnaroundTime[index]=ii+1;
			}
			if(ii==0)
			temp=index;
		    else if(temp!=index)
			{
				count++;
				temp=index;
			}
			ii++;
			}	
		}
		for(int i=0;i<processes;i++)
		{
			TurnaroundTime[i]-=ArrivalTime[i];
			ExitTime[i]=TurnaroundTime[i]+ArrivalTime[i];
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
		System.out.println("Number of Content Switching: "+count);	}
}
