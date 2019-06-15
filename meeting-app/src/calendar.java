public interface calendar {
	final int year = 365;
	
	//days elapsed
	final int jan = 0;
	final int feb = 31;
	final int mar = 59;
	final int apr = 90;
	final int may = 120;
	final int jun = 150;
	final int jul = 181;
	final int aug = 212;
	final int sep = 242;
	final int oct = 273;
	final int nov = 303;
	final int dec = 334;

	public int findMonth(int month);
	
	public double meetingsLeft(int day,int monthday);	
}