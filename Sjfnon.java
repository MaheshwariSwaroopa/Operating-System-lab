import java.util.Scanner;
import java.lang.*;
public class Sjfnon
{
	public static void main(String args[])
	{
		Scanner input=new Scanner(System.in);
		int processes;
		System.out.print("Enter number of processes: ");
		processes=input.nextInt();
		int[] BurstTime = new int[processes];
		int[] ArrivalTime = new int[processes];
		int[] temp1=new int[processes];
		int[] temp2=new int[processes];
		int[] TurnaroundTime = new int[processes];
		int[] WaitingTime = new int[processes];
		int[] ExitTime = new int[processes];
		float avgturnaround=0;
		float avgwaitingtime=0;
		int index,temp,currenttime,minimum;
		minimum=Integer.MAX_VALUE;
		currenttime=0;
		System.out.print("Enter Burst times of processes: ");
		for(int i=0;i<processes;i++)
		{
			BurstTime[i]=input.nextInt();
			temp1[i]=BurstTime[i];
		}	
		System.out.print("Enter Arrival time of processes: ");
		for(int i=0;i<processes;i++)
		{
			ArrivalTime[i]=input.nextInt();
			temp2[i]=ArrivalTime[i];
		}
		int ii=0;
		while(ii<processes)
		{
			temp=currenttime;
			index=-1;
			minimum=Integer.MAX_VALUE;
			for(int j=0;j<processes;j++)
			{
				if(temp>=ArrivalTime[j] && ArrivalTime[j]!=-1)
				{
					if(minimum> BurstTime[j])
					{
						minimum=BurstTime[j];
						index=j;
						
					}
				}
			}
			if(index==-1)
				currenttime+=1;
			else{
				ii++;
			TurnaroundTime[index]=currenttime+BurstTime[index]-ArrivalTime[index];
			avgturnaround+=TurnaroundTime[index];
			WaitingTime[index]=TurnaroundTime[index]-temp1[index];
			avgwaitingtime+=WaitingTime[index];
			currenttime+=BurstTime[index];
			ExitTime[index]=TurnaroundTime[index]+ArrivalTime[index];
			ArrivalTime[index]=-1;
			BurstTime[index]=-1;
			}
			
		}
		avgturnaround=avgturnaround/processes;
		avgwaitingtime=avgwaitingtime/processes;
		System.out.println("process   \tBursttime\tarrivaltime\tTurnaroundtime\tWaitingtime\tExittime");
		for(int i=0;i<processes;i++)
		  System.out.println("p"+i+"\t\t"+temp1[i]+"\t\t"+temp2[i]+"\t\t"+TurnaroundTime[i]+"\t\t"+WaitingTime[i]+"\t\t"+ExitTime[i]);
	    System.out.println("Average Turnaround time : "+avgturnaround);
		System.out.println("Average Wating time : "+avgwaitingtime);
		System.out.println("Number of Context Switches: "+(processes-1));	}
}
