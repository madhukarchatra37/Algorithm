import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;


public class Heuristic {

	public Heuristic() {
		// TODO Auto-generated constructor stub
	}
    //public static int array1[]={50,11,20,8,40,50};
   
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		   
		long startTime = System.currentTimeMillis();
		   System.out.println("Enter the number of files");
	       Scanner s=new Scanner(System.in);
	       
	       String input=s.nextLine();
	       int n=Integer.parseInt(input);
           int array1[]=new int[n];
	       
	       BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Madhukar\\Desktop\\input.txt"));
			String line;
			int h=0;
			while ((line = br.readLine()) != null) {
			   int i=Integer.parseInt(line);
			  // System.out.println(i);
			   array1[h]=i;
			   h++;
			   if(h==n)
			   {
				   break;
			   }
			  // System.out.println(array1[h]);
			   
			}
			br.close();
	       System.out.println("Enter the number of servers");
	       String input1=s.nextLine();
	       int m=Integer.parseInt(input1);
	       ArrayList<Files> F1=new ArrayList<Files>();
	       ArrayList<Resource> R1=new ArrayList<Resource>();
	       for(int i=1;i<=m;i++)
	       {
	    	   Resource r=new Resource(0,i);
	    	   R1.add(r);
	       }
	    	   
	       for(int i=0;i<n;i++)
	       {
	           Files f=new Files(array1[i],i+1);
	           F1.add(f);
	           
	       }
	       
	       Collections.sort(F1,new Mycomparator());
	       
	      for(Iterator<Files> it = F1.iterator(); it.hasNext();) {
	    	   Files f=it.next();
	           System.out.println("The list contents of file"+f.getFilenumber() +"is"+f.getFbandwidth());
	       }
	       
	       for(Iterator<Resource> it = R1.iterator(); it.hasNext();) {
	    	   Resource r=it.next();
	           System.out.println("The bandwidth of resource"+r.getResourceno() +"is"+r.getSbandwidth());
	       }
	       int i,j;
	       int i1,j1;
	       int s1=F1.size();
	       int s2=R1.size();
	      // int s3=(int) Math.ceil(s1/s2);
	      // System.out.println("length"+s3);
	       
	       for(i=0,j=0;i<=s1&&j<=s2;i++,j++){
	    	   i1=i+1;
	    	   j1=j+1;
	    	  
	    	  if(i1>s1){
	    		   break;
	    	   }
	    	   if(j1>s2)
	    	   {
	    		   j=0;
	    		   
	    		  // continue Loop;
	    	   }
	    	   //int a=F1.get(i).fbandwidth;
	    	   //int b=F1.get(i).filenumber;
	    	  // System.out.println("bandwidth"+a);
	    	  // System.out.println("file number"+b);
	    	   //Files f=new Files(a,b);*/
	    	   Files f=new Files();
	    	   Resource r=new Resource();
	    	   f=F1.get(i);
	    	   
	    	   r=R1.get(j);
	    	   r.addbandwidth(f.fbandwidth);
	    	   R1.set(j,r);
	    	   
	    	   //R1.get(j).addbandwidth(a);
	    	   //R1.get(j).F.add(f);
	    	  
	    	  
	    	   //System.out.println("Loop....");
	    	   }
	       
	      for(Iterator<Resource> it = R1.iterator(); it.hasNext();) {
	    	   Resource r=it.next();
	           System.out.println("The bandwidth of resource"+r.getResourceno() +"is"+r.getSbandwidth());
	       
	       
	}
	       Collections.sort(R1,new Mycomparator1());
		    int optimal= R1.get(s2-1).sbandwidth;
		    System.out.println("The optimal solution is terms of max(Bj) "+optimal);
		    
		    long endTime = System.currentTimeMillis();
		    System.out.println("Took "+(endTime - startTime) + " ns"); 
	}

}
