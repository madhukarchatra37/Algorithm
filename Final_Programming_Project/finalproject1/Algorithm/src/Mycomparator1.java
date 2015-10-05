import java.util.Comparator;


public class Mycomparator1 implements Comparator<Resource>{

	public int compare(Resource r1, Resource r2) {
		// TODO Auto-generated method stub
		if(r1.getSbandwidth()>r2.getSbandwidth())
		{
			return 1;
		}
		else 
		{
			return -1;
		}
	}

	
}
