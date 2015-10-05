import java.util.Comparator;


public class Mycomparator implements Comparator<Files> {

	public int compare(Files f1, Files f2) {
		// TODO Auto-generated method stub
		if(f1.getFbandwidth()<f2.getFbandwidth())
		{
			return 1;
		}
		else 
		{
			return -1;
		}
	}

	

}
