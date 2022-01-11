package climatechange;
import java.io.IOException;
import java.util.*;

public interface IClimateAnalyzer {
	public ITemperature getLowestTempByMonth(String country, int month) throws IOException;
	public ITemperature getHighestTempByMonth(String country, int month) throws IOException;
	public ITemperature getLowestTempByYear(String country, int year) throws IOException;
	public ITemperature getHighestTempByYear(String country, int year) throws IOException;
	public TreeSet<ITemperature> getTempWithinRange(String country, double rangeLowTemp, double rangeHighTemp) throws IOException;
	public ITemperature getLowestTempYearByCountry(String country) throws IOException;
	public ITemperature getHighestTempYearByCountry(String country) throws IOException;
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(int month) throws IOException;
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(int month) throws IOException;
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp() throws IOException;
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp() throws IOException;
	public ArrayList<ITemperature> allCountriesGetAllDataWithinTempRange(double lowRangeTemp, double highRangeTemp) throws IOException;
	public ArrayList<ITemperature> allCountriesTop10TempDelta(int month, int year1, int year2) throws IOException;
	public void runClimateAnalyzer() throws IOException;
}
