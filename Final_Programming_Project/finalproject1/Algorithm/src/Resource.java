import java.util.ArrayList;


public class Resource {
	
	public int sbandwidth;
	public int resourceno;
	ArrayList<Files> F;
	public Resource()
	{
		sbandwidth=0;
	}

	public ArrayList<Files> getF() {
		return F;
	}

	public void setF(ArrayList<Files> f) {
		F = f;
	}

	public int getResourceno() {
		return resourceno;
	}

	public void setResourceno(int resourceno) {
		this.resourceno = resourceno;
	}

	public Resource(int r,int p) {
		// TODO Auto-generated constructor stub
		sbandwidth=r;
		resourceno=p;
		
	}

	public int getSbandwidth() {
		return sbandwidth;
	}

	public void setSbandwidth(int sbandwidth) {
		this.sbandwidth = sbandwidth;
	}
	
	public void addbandwidth(int a)
	{
		this.sbandwidth=sbandwidth+a;
	}

}
