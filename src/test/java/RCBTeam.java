import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import com.utility.ReadJson;

public class RCBTeam {
	
	ArrayList<String> playerList ;
	ReadJson readJson = new ReadJson();
	JSONObject jsonObject;
	int foreignPlayerCount;
	int wicketKeeperCount;
	JSONArray jsonArray;
	
	
	@Test
	public void listofForeignPlayers() throws IOException {
		String json = readJson.readRCBjsonFile();
		playerList = new ArrayList<String>();
		jsonObject = new JSONObject(json);

		JSONArray jsonArray = jsonObject.getJSONArray("player");

		for(int i=0 ; i<jsonArray.length() ; i++) {
			JSONObject countryInfo = jsonArray.getJSONObject(i);
			if(!countryInfo.getString("country").equals("India")) {
				playerList.add(countryInfo.getString("name"));
				foreignPlayerCount = playerList.size(); 
			}
		}
		assertEquals(4, foreignPlayerCount);
			
	}
	
	@Test
	public void atLeastOnrWicket() throws IOException {

		String json = readJson.readRCBjsonFile();
		playerList = new ArrayList<String>();
		jsonObject = new JSONObject(json);

		JSONArray jsonArray = jsonObject.getJSONArray("player");

		for(int i=0 ; i<jsonArray.length() ; i++) {
			JSONObject countryInfo = jsonArray.getJSONObject(i);
			if(countryInfo.getString("role").equals("Wicket-keeper")) {
				playerList.add(countryInfo.getString("role"));
				wicketKeeperCount = playerList.size(); 
			}
		}
		assertEquals(1, wicketKeeperCount);
	}
}
