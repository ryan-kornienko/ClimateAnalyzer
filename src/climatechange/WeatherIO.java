package climatechange;
import java.util.*;
import java.io.*;

public class WeatherIO implements IWeatherIO
{
	private PrintWriter  pw;
	
	// reads all data from the weather data file
	public ArrayList<ITemperature> readDataFromFile(String fileName) throws IOException
	{
		File data = new File(fileName);
		FileReader fr = new FileReader(data);
		BufferedReader br = new BufferedReader(fr); //takes file in and assigns it to a buffered reader
		
		ArrayList<ITemperature> collection = new ArrayList<ITemperature>();
		br.readLine();
		String currentLine = br.readLine();
		while(currentLine != null)//reads lines until the last line of the file
		{
			String[] currentLineSplit= currentLine.split(", "); //splits each line into each of its parts
			double temp = Double.parseDouble(currentLineSplit[0]);
			int year = Integer.parseInt(currentLineSplit[1]); //converts temperature and year values from string to double and integer values
			ITemperature currentTemp = new Temperature(temp, year, currentLineSplit[2], currentLineSplit[3], currentLineSplit[4]); //creates new temperature objects for each line
			collection.add(currentTemp);
			currentLine = br.readLine();
		}
		br.close();
		fr.close();
		return collection;
	}
	
	
	// writes the subject header before dumping data returned from each ClimateAnalyzer method 
	public void writeSubjectHeaderInFile(String filename, String subject)
	{
		String[] contents = subject.split(", "); // subject is typically a custom string I create for each task which fits into the blanks when writing the header
		if(filename.equalsIgnoreCase("A1"))
		{
			pw.println("Task A1: " + contents[0] + " temperature in " + contents[1] + " in the month " + convertMonth(Integer.parseInt(contents[2])));
		}
		else if(filename.equalsIgnoreCase("A2"))
		{
			pw.println("Task A2: " + contents[0] + " temperature in " + contents[1] + " in the year " + contents[2]);
		}
		else if(filename.equalsIgnoreCase("A3"))
		{
			pw.println("Task A3: Temperatures for " + contents[0] + " within " + contents[1] + "-" + contents[2]);
		}
		else if(filename.equalsIgnoreCase("A4"))
		{
			pw.println("Task A4: " + contents[0] + " temperature in " + contents[1]);
		}
		else if(filename.equalsIgnoreCase("B1"))
		{
			pw.println("Task B1: " + contents[0] + " temperatures of all countries in " + convertMonth(Integer.parseInt(contents[1])));
		}
		else if(filename.equalsIgnoreCase("B2"))
		{
			pw.println("Task B2: " + contents[0] + " temperatures of all countries");
		}
		else if(filename.equalsIgnoreCase("B3"))
		{
			pw.println("Task B3: Temperatures of all contries within " + contents[0] + "-" + contents[1]);
		}
		else if(filename.equalsIgnoreCase("C1"))
		{
			pw.println("Task C1: Countries in " + convertMonth(Integer.parseInt(contents[0])) + " with the highest temperature differences from the year " + contents[1] + "-" + contents[2]);
		}
		else if(filename.equalsIgnoreCase("D1"))
		{
			pw.println("Task D1: Top 50 temperature deltas throughout all data");
		}
		else if(filename.equalsIgnoreCase("D2"))
		{
			pw.println("Task D2: Top 50 temperature deltas over a " + contents[0] + " year span");
		}
		pw.println("Temperature,Year,Month,Country_Code");
	}
		
	
	// **method that I created and is not a part of the requirement
	// method that converts input month to the string form of the month as a three letter abbreviation
	// only used within WeatherIO
	private String convertMonth(int m)
	{
		if(m == 1)
			{return "Jan";}
		else if(m == 2)
			{return "Feb";}
		else if(m == 3)
			{return "Mar";}
		else if(m == 4)
			{return "Apr";}
		else if(m == 5)
			{return "May";}
		else if(m == 6)
			{return "Jun";}
		else if(m == 7)
			{return "Jul";}
		else if(m == 8)
			{return "Aug";}
		else if(m == 9)
			{return "Sep";}
		else if(m == 10)
			{return "Oct";}
		else if(m == 11)
			{return "Nov";}		
		else if(m == 12)
			{return "Dec";}
		else
			{return "";}
	}
	
	// writes data found by Climate Analyzer methods into its own specific file
	public void writeDataToFile(String filename, String topic, ArrayList<ITemperature> theWeatherList) throws IOException
	{
		File data = new File("data/" + filename);
		data.createNewFile();
		FileWriter fr = new FileWriter(data);
		pw = new PrintWriter(fr);
		String taskName = filename.substring(4,6);
		writeSubjectHeaderInFile(taskName, topic);
		for(ITemperature t : theWeatherList)
		{
			pw.println(t.toString());
		}
		fr.close();
		pw.close();
	}
}
