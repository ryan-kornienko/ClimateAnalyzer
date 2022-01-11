package climatechange;
import java.io.IOException;
import java.util.*;

public class ClimateAnalyzer implements IClimateAnalyzer
{
	private ArrayList<ITemperature>		data;
	private WeatherIO					instance;
	
	// Constructs a new climate analyzer object and defines the ArrayList of the total data being analyzed
	public ClimateAnalyzer () throws IOException
	{
		instance = new WeatherIO();
		data = instance.readDataFromFile("data/world_temp_2000-2016.csv");
	}

	// TASK A-1
	// for all data that matches the specified month, get the lowest temperature reading 
	public ITemperature getLowestTempByMonth(String country, int month) throws IOException
	{
		TreeSet<ITemperature> set = new TreeSet<>();
		for(ITemperature t : data)
		{
			if(t.getCountry().equalsIgnoreCase(country) && (t.getMonthDigit() == month))
				{set.add(t);}	
		}
		ITemperature lowest = set.first();
		ArrayList<ITemperature> input = new ArrayList<>();
		input.add(lowest);
		String topic = "Lowest, " + country + ", " + month;
		instance.writeDataToFile("taskA1_climate_info.csv", topic, input);
		return lowest;
	}
	
	// TASK A-1
	// for all data that matches the specified month, get the highest temperature reading 
	public ITemperature getHighestTempByMonth(String country, int month) throws IOException
	{
		TreeSet<ITemperature> set = new TreeSet<>();
		for(ITemperature t : data)
		{
			if(t.getCountry().equalsIgnoreCase(country) && (t.getMonthDigit() == month))
				{set.add(t);}
		}
		ITemperature highest = set.last();
		ArrayList<ITemperature> input = new ArrayList<>();
		input.add(highest);
		String topic = "Highest, " + country + ", " + month;
		instance.writeDataToFile("taskA1_climate_info.csv",topic, input);
		return highest;
	}
	
	
	// TASK A-2
	// for all data that matches the specified year, get the lowest temperature reading
	public ITemperature getLowestTempByYear(String country, int year) throws IOException
	{
		TreeSet<ITemperature> set = new TreeSet<>();
		for(ITemperature t : data)
		{
			if(t.getCountry().equalsIgnoreCase(country) && (t.getYear() == year))
				{set.add(t);}	
		}
		ITemperature lowest = set.first();
		ArrayList<ITemperature> input = new ArrayList<>();
		input.add(lowest);
		String topic = "Lowest, " + country + ", " + year;
		instance.writeDataToFile("taskA2_climate_info.csv", topic, input);
		return lowest;
	}
	
	
	// TASK A-2
	// for all data that matches the specified year, get the highest temperature reading
	public ITemperature getHighestTempByYear(String country, int year) throws IOException
	{
		TreeSet<ITemperature> set = new TreeSet<>();
		for(ITemperature t : data)
		{
			if(t.getCountry().equalsIgnoreCase(country) && (t.getYear() == year))
				{set.add(t);}
		}
		ITemperature highest = set.last();
		ArrayList<ITemperature> input = new ArrayList<>();
		input.add(highest);
		String topic = "Highest, " + country + ", " + year;
		instance.writeDataToFile("taskA2_climate_info.csv", topic, input);
		return highest;
	}
	
	
	// TASK A-3
	// get all temperature data that fall within the given temperature range
	// the set is sorted from lowest to highest temperature
	// input parameter values are in Celsius
	public TreeSet<ITemperature> getTempWithinRange(String country, double rangeLowTemp, double rangeHighTemp) throws IOException
	{
		TreeSet<ITemperature> set = new TreeSet<>();
		for (ITemperature t : data)
		{
			if(t.getCountry().equalsIgnoreCase(country) && t.getTemperature(true) > rangeLowTemp && t.getTemperature(true) < rangeHighTemp)
				{set.add(t);}
		}
		ArrayList<ITemperature> input = new ArrayList<>(set);
		String topic = country + ", " + rangeLowTemp + ", " + rangeHighTemp;
		instance.writeDataToFile("taskA3_climate_info.csv", topic, input);
		return set;
	}
	
	
	// TASK A-4
	// 1. get the lowest temperature reading amongst all data for that country
	public ITemperature getLowestTempYearByCountry(String country) throws IOException
	{
		TreeSet<ITemperature> set = new TreeSet<>();
		for(ITemperature t : data)
		{
			if(t.getCountry().equalsIgnoreCase(country))
				{set.add(t);}	
		}
		ITemperature lowest = set.first();
		ArrayList<ITemperature> input = new ArrayList<>();
		input.add(lowest);
		String topic = "Lowest, " + country;
		instance.writeDataToFile("taskA4_climate_info.csv", topic, input);
		return lowest;
	}
	
	
	// TASK A-4
	// 1. get the highest temperature reading amongst all data for that country
	public ITemperature getHighestTempYearByCountry(String country) throws IOException
	{
		TreeSet<ITemperature> set = new TreeSet<>();
		for(ITemperature t : data)
		{
			if(t.getCountry().equalsIgnoreCase(country))
				{set.add(t);}	
		}
		ITemperature highest = set.last();
		ArrayList<ITemperature> input = new ArrayList<>();
		input.add(highest);
		String topic = "Highest, " + country;
		instance.writeDataToFile("taskA4_climate_info.csv", topic, input);
		return highest;
	}
	
	
	// TASK B-1
	// 1. the return list is sorted from lowest to highest temperature
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(int month) throws IOException
	{
		TreeSet<ITemperature> set = new TreeSet<>();
		for(ITemperature t : data)
		{
			if(t.getMonthDigit() == month)
				{set.add(t);}	
		}
		TreeSet<ITemperature> lowestTS = new TreeSet<>();
		HashSet<String> countriesAdded = new HashSet<>();
		while(lowestTS.size() < 10)
		{
			ITemperature current = set.pollFirst();
			if(countriesAdded.add(current.getCountry()))
				{lowestTS.add(current);}
		}
		ArrayList<ITemperature> lowestAL = new ArrayList<>(lowestTS);
		String topic = "Lowest, " + month;
		instance.writeDataToFile("taskB1_climate_info.csv", topic, lowestAL);
		return lowestAL;
	}
	
	
	// TASK B-1
	// 1. the return list is sorted from lowest to highest temperature
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(int month) throws IOException
	{
		TreeSet<ITemperature> set = new TreeSet<>();
		for(ITemperature t : data)
		{
			if(t.getMonthDigit() == month)
				{set.add(t);}	
		}
		TreeSet<ITemperature> highestTS = new TreeSet<>();
		HashSet<String> countriesAdded = new HashSet<>();
		while(highestTS.size() < 10)
		{
			ITemperature current = set.pollLast();
			if(countriesAdded.add(current.getCountry()))
				{highestTS.add(current);}
		}
		ArrayList<ITemperature> highestAL = new ArrayList<>(highestTS);
		String topic = "Highest, " + month;
		instance.writeDataToFile("taskB1_climate_info.csv", topic, highestAL);
		return highestAL;
	}
	
	
	// TASK B-2
	// 1. the return list is sorted from lowest to highest temperature
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp() throws IOException
	{
		TreeSet<ITemperature> allData = new TreeSet<>(data);
		TreeSet<ITemperature> lowestTS = new TreeSet<>();
		HashSet<String> countriesAdded = new HashSet<>();
		while(lowestTS.size() < 10)
		{
			ITemperature current = allData.pollFirst();
			if(countriesAdded.add(current.getCountry()))
				{lowestTS.add(current);}
		}
		ArrayList<ITemperature> lowestAL = new ArrayList<>(lowestTS);
		instance.writeDataToFile("taskB2_climate_info.csv", "Lowest ", lowestAL);
		return lowestAL;
	}
	
	
	 // TASK B-2
	 // 1. the return list is sorted from lowest to highest temperature
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp() throws IOException
	{
		TreeSet<ITemperature> allData = new TreeSet<>(data);
		TreeSet<ITemperature> highestTS = new TreeSet<>();
		HashSet<String> countriesAdded = new HashSet<>();
		while(highestTS.size() < 10)
		{
			ITemperature current = allData.pollLast();
			if(countriesAdded.add(current.getCountry()))
				{highestTS.add(current);}
		}
		ArrayList<ITemperature> highestAL = new ArrayList<>(highestTS);
		instance.writeDataToFile("taskB2_climate_info.csv", "Highest" , highestAL);
		return highestAL;
	}
	
	
	 // TASK B-3
	 // 1. the return list is sorted from lowest to highest temperature
	public ArrayList<ITemperature> allCountriesGetAllDataWithinTempRange(double lowRangeTemp, double highRangeTemp) throws IOException
	{
		TreeSet<ITemperature> list = new TreeSet<>();
		for(ITemperature t : data)
		{
			if(t.getTemperature(true) > lowRangeTemp && t.getTemperature(true) < highRangeTemp)
				{list.add(t);}
		}
		ArrayList<ITemperature> withinRange = new ArrayList<>(list);
		String topic = "" + lowRangeTemp + ", " + highRangeTemp;
		instance.writeDataToFile("taskB3_climate_info.csv", topic , withinRange);
		return withinRange;
	}
	
	
	// TASK C-1
	// 1. the countries with the largest temperature differences (absolute value)
	// 2. the return list is sorted from lowest to highest temperature delta
	public ArrayList<ITemperature> allCountriesTop10TempDelta(int month, int year1, int year2) throws IOException 
	{
		ArrayList<ITemperature> yearOne = new ArrayList<>();
		ArrayList<ITemperature> yearTwo = new ArrayList<>();
		String hybridYears;
		if(year2 > year1) 
			{hybridYears = "" + year1 + "" + year2;}
		else
			{hybridYears = "" + year2 + "" + year1;}
		int year = Integer.parseInt(hybridYears);
		for(ITemperature t : data)
		{
			if(t.getMonthDigit() == month && t.getYear() == year1)
				{yearOne.add(t);}
		}
		for(ITemperature t: data)
		{
			if(t.getMonthDigit() == month && t.getYear() == year2)
				{yearTwo.add(t);}
		}
		TreeSet<ITemperature> results = new TreeSet<>();
		for(int i =0; i < yearOne.size(); i++)
		{
			double delta = Math.abs(yearOne.get(i).getTemperature(true) - yearTwo.get(i).getTemperature(true));
			results.add(new Temperature(delta, year, yearOne.get(i).getMonth(), yearOne.get(i).getCountry(), yearOne.get(i).getCoutnry3LetterCode()));
		}
		TreeSet<ITemperature> temporary = new TreeSet<>();
		HashSet<String> countriesAdded = new HashSet<>();
		
		while(temporary.size() < 10)
		{
			ITemperature current = results.pollLast();
			if(countriesAdded.add(current.getCountry()))
				{temporary.add(current);}
		}
		ArrayList<ITemperature> top10 = new ArrayList<>(temporary);
		String topic = month + ", " + year1 + ", " + year2;
		instance.writeDataToFile("taskC1_climate_info.csv", topic, top10);
		return top10;
	}
	
	
	
	// Task D-1 allCountriesTop50TempDeltaOverASpan
	// **method that I created and is not a part of the requirement
	// return value is the top 50 temperature changes throughout all of the data
	public ArrayList<ITemperature> allCountriesTop50TempDeltaAllData() throws IOException
	{
		TreeSet<ITemperature> greatestDeltas = new TreeSet<>(); // stores the top 3 deltas from each data point  
		for(int month = 1; month < 13; month++)
		{
			for(int year1 = 2000; year1 < 2016; year1++)
			{
				for(int year2 = 2000; year2 < 2016; year2++) // cycles through every data point
				{
					if(year1 != year2) // does not include when years are equal
					{
						ArrayList<ITemperature> currentTop10 = allCountriesTop10TempDelta(month, year1, year2);
						for (int i = 0; i < 3; i++)
						{
							greatestDeltas.add(currentTop10.remove(currentTop10.size() - 1));
						}
					}
				}
			}
		}
		TreeSet<ITemperature> top50 = new TreeSet<>();
		for(int i = 0; i < 50; i++)
		{
			top50.add(greatestDeltas.pollLast());
		}
		ArrayList<ITemperature> results = new ArrayList<>(top50);
		instance.writeDataToFile("taskD1_climate_info.csv", "", results);
		return results;
	}
	
	
	// Task D-2 allCountriesTop50TempDeltaOverASpan
	// **method that I created and is not a part of the requirement
	// return value is the top 50 temperature changes throughout all of the data over the specified span
	// param yearSpan is the span of years the data is being pulled from 
	// ie yearSpan = 4 evaluates all temp deltas from 2000-2004, 2001-2005, 2002-2006, etc.
	public ArrayList<ITemperature> allCountriesTop50TempDeltaOverASpan(int yearSpan) throws IOException
	{
		TreeSet<ITemperature> greatestDeltas = new TreeSet<>(); // stores the top 3 deltas from each data point  
		for(int month = 1; month < 13; month++)
		{
			for(int year1 = 2000; year1 < 2016; year1++)
			{
				for(int year2 = 2000; year2 < 2016; year2++) // cycles through each data point
				{
					int yearDiff = Math.abs(year1-year2);
					if(year1 != year2 && yearSpan == yearDiff) // data point is only counted unless the years are different and the year difference is the same as the year span
					{
						ArrayList<ITemperature> currentTop10 = allCountriesTop10TempDelta(month, year1, year2);
						for (int i = 0; i < 3; i++)
						{
							greatestDeltas.add(currentTop10.remove(currentTop10.size() - 1));
						}
					}
				}
			}
		}
		TreeSet<ITemperature> top50 = new TreeSet<>();
		if(greatestDeltas.size() > 50)
		{
			for(int i = 0; i < 50; i++)
			{
				top50.add(greatestDeltas.pollLast()); // adds the 50 greatest temperature deltas found from the loop above
			}
		}
		else // if less than 50 temperatures are found, return list is created with the amount of data pieces found
		{
			for(int i = 0; i < greatestDeltas.size(); i++)
			{
				top50.add(greatestDeltas.pollLast());
			}
		}
		ArrayList<ITemperature> results = new ArrayList<>(top50);
		instance.writeDataToFile("taskD2_climate_info.csv", "" + yearSpan, results);
		return results;
	}
	
	
	// **method I created on my own
	// checks if input parameter is a country that has recorded data in the data file
	// only used within ClimateAnalyzer
	private boolean countryIsLegal(String country)
	{
		TreeSet<String> legalCountries = new TreeSet<>();
		for(ITemperature t: data)
			{legalCountries.add(t.getCountry());} //creates a TreeSet of all country names
		for(String s: legalCountries){
			if(s.equalsIgnoreCase(country))
				{return true;} // checks if any of the country names match the input parameter
		}
		return false;
	}
	
	
	// runs all methods of climate analyzer and asks the user for input when needed
	// *except for methods I created
	public void runClimateAnalyzer() throws IOException
	{
		Scanner in = new Scanner(System.in);
		//Task A-1 Highest/LowestTempBy Month
		System.out.print("Task A1: Highest/LowestTempByMonth" + "\n" + "Enter H for highest or L for lowest: ");
		String highOrLowA1 = in.nextLine();
		while(!highOrLowA1.equalsIgnoreCase("H") && !highOrLowA1.equalsIgnoreCase("L"))
		{
			System.out.print("Invalid response, please enter 'h' or 'l'");
			highOrLowA1 = in.nextLine();
		}
		System.out.print("Enter a country: ");
		String countryA1 = in.nextLine();
		if(!countryIsLegal(countryA1))
		{
			while(!countryIsLegal(countryA1))
			{
				System.out.print("Invalid country, please try again ");
				countryA1 = in.nextLine();
			}
		}
		System.out.print("Enter a month (as a digit): ");
		int monthA1 = in.nextInt();
		while(monthA1 > 12 || monthA1 < 0)
		{
			System.out.print("Invalid month, please enter a number between 1 and 12");
			monthA1 = in.nextInt();
		}
		if(highOrLowA1.equalsIgnoreCase("H"))
			{getHighestTempByMonth(countryA1, monthA1);}
		else if(highOrLowA1.equalsIgnoreCase("L"))
			{getLowestTempByMonth(countryA1, monthA1);}
		System.out.print("A1 Completed" + "\n" + "\n");
		
		
		//Task A-2 Highest/LowestTempByYear
		System.out.println("Task A2: Highest/LowestTempByYear");
		System.out.print("Enter H for highest or L for lowest: ");
		String highOrLowA2 = in.next();
		while(!highOrLowA2.equalsIgnoreCase("H") && !highOrLowA2.equalsIgnoreCase("L"))
		{
			System.out.print("Invalid Response, please enter 'h' or 'l'");
			highOrLowA2 = in.next();
		}
		System.out.print("Enter a country: ");
		String countryA2 = in.nextLine();
		while(!countryIsLegal(countryA2))
		{
			countryA2 = in.nextLine();
			if(!countryIsLegal(countryA2))
				{System.out.print("Invalid Country, please try again ");}
		}
		System.out.print("Enter a year: ");
		int yearA2 = in.nextInt();
		while(yearA2 > 2016 || yearA2 < 2000)
		{
			System.out.print("Invalid Year, please enter a year between 2000 and 2016: ");
			yearA2 = in.nextInt();
		}
		if(highOrLowA2.equalsIgnoreCase("H"))
			{getHighestTempByYear(countryA2, yearA2);}
		else if(highOrLowA2.equalsIgnoreCase("L"))
			{getLowestTempByYear(countryA2, yearA2);}
		System.out.print("A2 Completed" + "\n" + "\n");
		
		
		// Task A-3 GetTempWithinRange
		System.out.println("Task A3: GetTempWithinRange");
		System.out.print("Enter a country: ");
		String countryA3 = in.nextLine(); 
		while(!countryIsLegal(countryA3))
		{
			countryA3 = in.nextLine();
			if(!countryIsLegal(countryA3))
				{System.out.print("Invalid Country, please try again");}
		}
		System.out.print("Enter the low temperature for the range: ");
		Double lowA3 = in.nextDouble();
		System.out.print("Enter the high temperature for the range: ");
		Double highA3 = in.nextDouble();
		while(lowA3 > highA3)
		{
			System.out.print("Invalid temperatures, High temperature must be greater than low temperature. Enter new low: ");
			lowA3 = in.nextDouble();
			System.out.print("Enter new high: ");
			highA3 = in.nextDouble();
		}
		getTempWithinRange(countryA3, lowA3, highA3);
		System.out.print("A3 Completed" + "\n" + "\n");

		
		// Task A-4 GetLowest/HighestTempYearByCountry
		System.out.print("Task A4: GetLowest/HighestTempYearByCountry" + "\n" + "Enter H for highest or L for lowest: ");
		String highOrLowA4 = in.next();
		while(!highOrLowA4.equalsIgnoreCase("H") && !highOrLowA4.equalsIgnoreCase("L"))
		{
			System.out.print("Invalid Response, please enter 'h' or 'l'");
			highOrLowA4 = in.next();
		}
		System.out.print("Enter a country: ");
		String countryA4 = in.nextLine();
		while(!countryIsLegal(countryA4))
		{
			countryA4 = in.nextLine();
			if(!countryIsLegal(countryA4))
				{System.out.print("Invalid Country, please try again ");}
		}
		if(highOrLowA4.equalsIgnoreCase("H"))
			{getHighestTempYearByCountry(countryA4);}
		else if(highOrLowA4.equalsIgnoreCase("L"))
			{getLowestTempYearByCountry(countryA4);}
		System.out.print("A4 Completed" + "\n" + "\n");
		
		
		//Task B-1 AllCountriesGetTop10Lowest/HighestTemp
		System.out.print("Task B1: AllCountriesGetTop10Lowest/HighestTemp, based off a month" + "\n" + "Enter H for highest or L for lowest: ");
		String highOrLowB1 = in.next();
		while(!highOrLowB1.equalsIgnoreCase("H") && !highOrLowB1.equalsIgnoreCase("L"))
		{
			System.out.print("Invalid Response, please enter 'h' or 'l' ");
			highOrLowB1 = in.next();
		}
		System.out.print("Enter a month (as a digit): ");
		int monthB1 = in.nextInt();
		while(monthB1 > 12 || monthB1 < 0)
		{
			System.out.print("Invalid Month, please enter a number between 1 and 12 ");
			monthB1 = in.nextInt();
		}
		if(highOrLowB1.equalsIgnoreCase("H"))
			{allCountriesGetTop10HighestTemp(monthB1);;}
		else if(highOrLowB1.equalsIgnoreCase("L"))
			{allCountriesGetTop10LowestTemp(monthB1);}
		System.out.print("B1 Completed" + "\n" + "\n");
		
		
		//Task B-2 AllCountriesGetTop10Lowest/HighestTemp
		System.out.print("Task B2: AllCountriesGetTop10Lowest/HighestTemp" + "\n" + "Enter H for highest or L for lowest: ");
		String highOrLowB2 = in.next();
		while(!highOrLowB2.equalsIgnoreCase("H") && !highOrLowB2.equalsIgnoreCase("L"))
		{
			System.out.print("Invalid Response, please enter 'h' or 'l' ");
			highOrLowB2 = in.next();
		}
		if(highOrLowB2.equalsIgnoreCase("H"))
			{allCountriesGetTop10HighestTemp();}
		else if(highOrLowB2.equalsIgnoreCase("L"))
			{allCountriesGetTop10LowestTemp();}
		System.out.print("B2 Completed" + "\n" + "\n");
		
		
		//Task B-3 AllCountriesGetAllDataWithinTempRange
		System.out.print("Task B3: AllCountriesGetAllDataWithinTempRange" + "\n" + "Enter the low temperature of the range: ");
		Double lowB3 = in.nextDouble();
		System.out.print("Enter the high temperature of the range: ");
		Double highB3 = in.nextDouble();
		while(lowB3 > highB3)
		{
			System.out.print("Invalid temperatures, high temperature must be greater than low temperature" + "\n" + "Enter new low temperature: ");
			lowB3 = in.nextDouble();
			System.out.print("Enter new high temperature: ");
			highB3 = in.nextDouble();
		}
		allCountriesGetAllDataWithinTempRange(lowB3, highB3);
		System.out.print("B3 Completed" + "\n" + "\n");
		
		//Task C-1 allCountriesTop10TempDelta 
		System.out.print("Task C1: AllCountriesTop10TempDelta" + "\n" + "Enter a month: ");
		int monthC1 = in.nextInt();
		while (monthC1 > 12 || monthC1 < 0)
		{
			System.out.print("Invalid month, please enter a number between 1 and 12 ");
			monthC1 = in.nextInt();
		}
		System.out.print("Enter the first year: ");
		int yearC1 = in.nextInt();
		while (yearC1 > 2016 || yearC1 < 2000)
		{
			System.out.print("Invalid year, please enter a year between 2000 and 2016 ");
			yearC1 = in.nextInt();
		}
		System.out.print("Enter the next year: ");
		int yearC2 = in.nextInt();
		while (yearC2 > 2016 || yearC2 < 2000)
		{
			System.out.print("Invalid year, please enter a year between 2000 and 2016 ");
			yearC2 = in.nextInt();
		}
		allCountriesTop10TempDelta(monthC1, yearC1, yearC2);
		System.out.print("C1 Completed" + "\n" + "\n");
		
		System.out.print("DONE");
		in.close();
	}
	
	
	public static void main (String[] args) throws IOException
	{
		ClimateAnalyzer tester = new ClimateAnalyzer();
		tester.runClimateAnalyzer();
	}
}
