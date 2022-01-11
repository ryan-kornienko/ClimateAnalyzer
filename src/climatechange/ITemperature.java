package climatechange;

public interface ITemperature 
{
	public String getCountry();                           // returns country name
	public String getCoutnry3LetterCode();                // returns three letter abbreviation of country name   
	public String getMonth();                             // returns month the data is from
	public int getYear();                                 // returns year the data is data
	public double getTemperature(boolean getFahrenheit);  // returns temperature; if parameter is false, return value is converted to Celsius
	public int getMonthDigit();
}
