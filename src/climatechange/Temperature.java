package climatechange;

public class Temperature implements ITemperature, Comparable<Temperature>
{
	private String          country;
	private String          countryCode;
	private String          month;
	private int             year;
	private double          temperature; 
	
	
	// ITemperature creates an object that has a temperature, year, month, country and country code
	// this relates to the temperature of countries for the particular year and month
	public Temperature(double temperature, int year, String month, String country, String countryCode)
	{
		this.temperature = temperature;
		this.year = year;
		this.month = month;
		this.country = country;
		this.countryCode = countryCode;
	}
	
	
	// returns country name
	public String getCountry()
	{
		return country;
	}
	
	
	// returns three letter abbreviation of country name
	public String getCoutnry3LetterCode() 
	{
		return countryCode;
	}
	
	
	// returns month the data is from
	public String getMonth()
	{
		return month;
	}
	
	
	 // returns year the data is data
	public int getYear() 
	{
		return year;
	}
	
	
	// **method that I created and is not a part of the requirement
	// returns month as a digit
	public int getMonthDigit()
	{
		if(month.equalsIgnoreCase("Jan"))
			{return 1;}
		else if(month.equalsIgnoreCase("Feb"))
			{return 2;}
		else if(month.equalsIgnoreCase("Mar"))
			{return 3;}
		else if(month.equalsIgnoreCase("Apr"))
			{return 4;}
		else if(month.equalsIgnoreCase("May"))
			{return 5;}
		else if(month.equalsIgnoreCase("Jun"))
			{return 6;}
		else if(month.equalsIgnoreCase("Jul"))
			{return 7;}
		else if(month.equalsIgnoreCase("Aug"))
			{return 8;}
		else if(month.equalsIgnoreCase("Sep"))
			{return 9;}
		else if(month.equalsIgnoreCase("Oct"))
			{return 10;}
		else if(month.equalsIgnoreCase("Nov"))
			{return 11;}
		else if(month.equalsIgnoreCase("Dec"))
			{return 12;}
		else
			{return 0;}
	}
	
	// returns temperature
	// if parameter is true, temperature returned remains Celsius, if parameter is false, return value is converted to Fahrenheit
	public double getTemperature(boolean getFahrenheit)
	{
		if(!getFahrenheit)
		{
			return ((temperature*1.8)+32);
		}		
		return temperature;
	}
	
	
	@Override
	// will sort low temperatures first, then compares country name, year, and month
	public int compareTo(Temperature other)
	{
		if(this.temperature > other.temperature)
			{return 1;}
		else if (this.temperature < other.temperature)
			{return -1;}
		else if (!this.country.equals(other.country))
			{return this.country.compareTo(other.country);}
		else if (this.year > other.year)
			{return 1;}
		else if (this.year < other.year)
			{return -1;}
		else if (this.getMonthDigit() > other.getMonthDigit())
			{return 1;}
		else if (this.getMonthDigit() < other.getMonthDigit())
			{return 1;}
		else
			{return 0;}
	}
	
	
	@Override
	// formats a temperature object to string by having the temperature in Celsius and Fahrenheit along with the year, month, country and country code
	public String toString()
	{
		return (double)Math.round(temperature*100)/100 + "(C) " + (double)Math.round(getTemperature(false)*100)/100 + "(F)," + year + "," +  month + "," + country +  "," + countryCode;  
	}
}
