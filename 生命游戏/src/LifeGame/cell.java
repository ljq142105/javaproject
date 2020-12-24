package LifeGame;

import java.util.Random;

public class cell {
	int row;
	int col;
	int cellArray[][];
	
public void  init() 
{
	int a;
	int b;
	for(int i=0;i<row+2;i++) 
	{
		for(int j=0;j<col+2;j++)
		{
			cellArray[i][j]=0;
		}
	}
	Random ra =new Random();
	for(int i=0;i<row*col/4;i++) 
	{
		a=(ra.nextInt(100)+1)%(row)+1;
		b=(ra.nextInt(100)+1)%(col)+1;
		cellArray[a][b]=1;
	
    }
}	
public void change()
{
	int num;
	int mycell2[][]=new int[row+2][col+2];
	for(int i=1;i<row+1;i++) 
	{
		for(int j=1;j<col+1;j++)
		{
				num=cellArray[i-1][j-1]+cellArray[i-1][j]+cellArray[i-1][j+1]
					+cellArray[i][j-1]+cellArray[i][j+1]
					+cellArray[i+1][j-1]+cellArray[i+1][j]+cellArray[i+1][j+1];
				if(num==3)
					mycell2[i][j]=1;
				else if(num==2&&cellArray[i][j]==1)
					mycell2[i][j]=1;
				else
					mycell2[i][j]=0;
			
		
		}
	}
	for(int i=1;i<row+1;i++) 
	{
		for(int j=1;j<col+1;j++)
		{
			cellArray[i][j]=mycell2[i][j];	
		}
	}
}
}

