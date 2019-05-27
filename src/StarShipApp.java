
import java.util.*;


public class StarShipApp {

	public static void main(String[]args) {
		
		StarShipApp ssA = new StarShipApp();
		
		ssA.startApp();
		
	}
	
	
	public void startApp() {
		
		Station homebase = new Station();
		
		Scanner kb = new Scanner(System.in);
		
		
		homebase.userMenu(kb);
		
		
		
		
		
		kb.close();
		
		
		
	}
}
