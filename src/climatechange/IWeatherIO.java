package climatechange;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public interface IWeatherIO 
{
		public ArrayList<ITemperature> readDataFromFile(String fileName) throws FileNotFoundException, IOException; 	         //reads all data from the weather data file
		public void writeSubjectHeaderInFile(String filename, String subject);                               					 //adds a header to the data
		public void writeDataToFile(String filename, String topic, ArrayList<ITemperature> theWeatherList) throws IOException;   //names the files specific for the task
}
