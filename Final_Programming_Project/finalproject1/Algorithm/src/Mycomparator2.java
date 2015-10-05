import java.util.Comparator;


public class Mycomparator2 implements Comparator<Resource>{

	public int compare(Resource r1, Resource r2) {
		// TODO Auto-generated method stub
		 if (r1.getSbandwidth()>r2.getSbandwidth())
	            return 1;
	        else if (r1.getSbandwidth() < r2.getSbandwidth())
	            return -1;
	        return 0;
	}

}
