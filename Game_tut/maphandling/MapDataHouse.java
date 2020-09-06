import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapDataHouse extends MapData{

//	public ArrayList<String> map_array = new ArrayList<String>();
	
	public MapDataHouse() {
		map_array = new ArrayList<String>();
		doorArray = new ArrayList<String>();
		
		this.mapName = "HOUSE";
		
		this.mapWidth = 32;
		this.mapHeigth = 32;
		
		File map_file = new File("maps/house.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(map_file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR LOADING MAPFILE:");
			e.printStackTrace();
		}
		 
		String row = "";
		try {
			while ((row = br.readLine()) != null) {
//				System.out.println(row);
				if(row.charAt(1) == '-') 
				{
					if(row.charAt(0) == 'd') {
						System.out.println("Added door: " + row.substring(2));
						this.doorArray.add(row.substring(2));
					}
				}
				else {
					map_array.add(row);					
				}
			} 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR READING MAPFILE:");
			e.printStackTrace();
		}
		
		
		
		
	}
}
