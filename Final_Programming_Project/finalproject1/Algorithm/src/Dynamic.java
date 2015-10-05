import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;


public class Dynamic {
	//public static int array1[]={10,20,30,40,70,52};

	public static int Bmax=400;
	public static void main(String[] args) throws IOException {
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
	       ArrayList<Suboptimalsolution> S1=new ArrayList<Suboptimalsolution>();
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
	       
	       
	       int s1=F1.size();
	       int s2=R1.size();
	       int ss;
	      
	     if(s1<=s2)
	     { int l=0;
	       for(int i=0;i<s1;i++){
	    	   
	    	   
	    	   Files f=new Files();
	    	   Resource r=new Resource();
	    	   f=F1.get(i);
	    	   int k=f.fbandwidth;
	    	   r=R1.get(i);
	    	   int k1=r.sbandwidth;
	    	   int k2=k+k1;
	    	   if(k2<=Bmax)
	    	   {
	    		   l++;
	    	   r.addbandwidth(f.fbandwidth);
	    	   R1.set(i,r);
	    	  Resource g= Collections.max(R1,new Mycomparator2());
			    //int optimal= R1.get(s2-1).sbandwidth;
			    Suboptimalsolution o=new Suboptimalsolution();
			    o.setNumberoffiles(l);
			    o.setOptimalsolution(g.getSbandwidth());
			    S1.add(o);
	    	   }
	    	   else{
	    		   //System.out.println("The following file cannot be added "+f.filenumber);
	    	   }
	    	   
	       }
	      /* for(Iterator<Resource> it = R1.iterator(); it.hasNext();) {
	    	   Resource r=it.next();
	           System.out.println("The bandwidth of resource"+r.getResourceno() +"is"+r.getSbandwidth());
	       }*/
	       Collections.sort(R1,new Mycomparator1());
		    int optimal= R1.get(s2-1).sbandwidth;
		    System.out.println("The optimal solution is terms of max(Bj) "+optimal);
		    
		   /* for(Iterator<Suboptimalsolution> it = S1.iterator(); it.hasNext();) {
		    	Suboptimalsolution s6=it.next();
		           System.out.println("The number of files "+s6.getNumberoffiles() +" sub-optimal solution is "+s6.getOptimalsolution());
		    
		    }*/ }
	     else{
	    	 int l=0;
	    	 int index = 0;
	    	 for(int i=0;i<s2;i++){
		    	   
		    	   Files f=new Files();
		    	   Resource r=new Resource();
		    	   f=F1.get(i);
		    	   int k=f.fbandwidth;
		    	   r=R1.get(i);
		    	   int k1=r.sbandwidth;
		    	   int k2=k+k1;
		    	   if(k2<=Bmax)
		    	   {
		    		   l++;
		    	   r.addbandwidth(f.fbandwidth);
		    	   R1.set(i,r);
		    	   Resource g=Collections.max(R1,new Mycomparator2());
				    //int optimal= R1.get(s2-1).sbandwidth;
				    Suboptimalsolution o=new Suboptimalsolution();
				    o.setNumberoffiles(l);
				    o.setOptimalsolution(g.getSbandwidth());
				    S1.add(o);
		    	   }
		    	   else{
		    		   System.out.println("The following file cannot be added "+f.filenumber);
		    	   }
		    	   index++;
		       }
	    	// System.out.println("The index is"+index);
	    	 /*for(Iterator<Resource> it = R1.iterator(); it.hasNext();) {
		    	   Resource r=it.next();
		           System.out.println("The bandwidth of resource"+r.getResourceno() +"is"+r.getSbandwidth());
		       }*/
	    	 for(int i=index;i<s1;i++)
	    	 {
	    		 Files f=new Files();
	    		 f=F1.get(i);
	    		 int k=f.fbandwidth;
	    	@SuppressWarnings("unchecked")
			ArrayList<Resource> R = (ArrayList<Resource>)R1.clone();
	    	Collections.sort(R,new Mycomparator1());
	    	/*for(Iterator<Resource> it = R.iterator(); it.hasNext();) {
		    	   Resource r=it.next();
		           System.out.println("The bandwidth of resource"+r.getResourceno() +"is"+r.getSbandwidth());
		       }
	    	System.out.println();*/
	    	int k1=R.get(0).sbandwidth;
	    	int k2=k1+k;
	    	if(k2<=Bmax){
	    		l++;
	    		R.get(0).addbandwidth(f.fbandwidth);	
	    		 Resource g=Collections.max(R1,new Mycomparator1());
				   // int optimal= R1.get(s2-1).sbandwidth;
				    Suboptimalsolution o=new Suboptimalsolution();
				    o.setNumberoffiles(l);
				    o.setOptimalsolution(g.getSbandwidth());
				    S1.add(o);
	    	}
	    	else{
	    		System.out.println("The following file cannot be added "+f.filenumber);
	    	}
	    	
	    	 }
	    	 for(Iterator<Resource> it = R1.iterator(); it.hasNext();) {
		    	   Resource r=it.next();
		           System.out.println("The bandwidth of resource"+r.getResourceno() +"is"+r.getSbandwidth());
		       }
	    	 Collections.sort(R1,new Mycomparator1());
			    int optimal= R1.get(s2-1).sbandwidth;
			    System.out.println("The optimal solution is terms of max(Bj) "+optimal);
	    	 
			    for(Iterator<Suboptimalsolution> it = S1.iterator(); it.hasNext();) {
			    	Suboptimalsolution s6=it.next();
			           System.out.println("The number of files "+s6.getNumberoffiles() +" sub-optimal solution is "+s6.getOptimalsolution());
			    
			    }
	     
	     }

	       
	     long endTime = System.currentTimeMillis();
		    System.out.println("Took "+(endTime - startTime) + " ns");   
	}
}
