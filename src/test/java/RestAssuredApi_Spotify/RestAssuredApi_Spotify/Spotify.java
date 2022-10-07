package RestAssuredApi_Spotify.RestAssuredApi_Spotify;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Spotify {
	String token ;
	String user_id="31dgqcr7w2id7sytthql3wxaytse";
	String playlist_id="5iE3RPUyCc5NyX2UKNHFgI";
	String tracks;
	@BeforeTest
	public void getToken() {
		token ="Bearer BQDGu7lLNUuF1vJ3yCg96EWRAzGIBiv5CSik8tGxgCbmHEG1Az3v2EKHKReOUCDxL0n-vA56MsF0pDvLY5TxCx24zJlLMaQGBAEzto8Fau9_ZJMUV0Z9GmYCC1Phb59molrPXdiQlNEhO24vvIKCH9quzjLP_-NGXMRDF2s7R1lp2KMQGcsyNE7mojn9fNwaXZ5F00M8Cta6hiL8tyTL0A0DVl1ykocnaKkghQ";
	}
	
	@Test(priority=1)
	public void testGet_CurrentUsersProfile() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization", token)
				.when()
				.get(" http://api.spotify.com/v1/me");
		response.prettyPrint();
		response.then().assertThat().statusCode(200);
	}

	@Test(priority=2)
	public void testGet_Users_Profile() {
		Response response =RestAssured.given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization", token)
				.when()
				.get("	https://api.spotify.com/v1/users/"+user_id+"");
		response.prettyPrint();
		response.then().assertThat().statusCode(200);

	}
	//5iE3RPUyCc5NyX2UKNHFgI -play
	/*
	@Test(priority=3)
	public void create_Playlist() {
		Response response =RestAssured.given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization", token)
				.body("{\r\n"
						+ "  \"name\": \"Sahiba Playlist\",\r\n"
						+ "  \"description\": \"New playlist description\",\r\n"
						+ "  \"public\": false\r\n"
						+ "}")
				.when()
				.post("	https://api.spotify.com/v1/users/"+user_id+"/playlists"	);
		response.prettyPrint();
		response.then().assertThat().statusCode(201);
	} 
	@Test(priority=4)
	public void add_Items_to_Playlist() {
		Response response =RestAssured.given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization", token)
				.queryParams("uris", tracks)
			
				.when()
				.post("	https://api.spotify.com/v1/playlists/"+playlist_id+"/tracks");
		response.prettyPrint();
		response.then().assertThat().statusCode(201);

	}
	
	@Test
	public void RemovePlaylistItem() {
		Response response = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization", token)
				.body("{\"tracks\":[{\"uri\":\"spotify:track:72zHuDxFQTjbL51qJQSA7j\"}]}")
				.when()
				.delete("https://api.spotify.com/v1/playlists/"+playlist_id+"/tracks");
response.prettyPrint();
response.then().assertThat().statusCode(200);

	}
	
	
	
	@Test(priority=6)
	public void get_Playlist() {
		Response response =RestAssured.given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization", token)
				.when()
				.get("	https://api.spotify.com/v1/playlists/"+playlist_id+"");
		response.prettyPrint();
		response.then().assertThat().statusCode(200);

	}
	
	@Test(priority=7)
	public void get_Users_Playlists() {
		Response response =RestAssured.given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization", token)
				.when()
				.get("	https://api.spotify.com/v1/users/"+user_id+"/playlists");
		response.prettyPrint();
		response.then().assertThat().statusCode(200);

	}
	
	@Test(priority=8)
	public void get_Playlist_Items() {
		Response response =RestAssured.given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization", token)
				.when()
				.get("	https://api.spotify.com/v1/playlists/"+playlist_id+"/tracks");
		response.prettyPrint();
		response.then().assertThat().statusCode(200);

	}
	
	@Test(priority=9)
	public void get_Current_Users_Playlists() {
		Response response =RestAssured.given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization", token)
				.when()
				.get("https://api.spotify.com/v1/me/playlists");
		response.prettyPrint();
		response.then().assertThat().statusCode(200);

	}
	
	@Test(priority=10)
	public void change_Playlist_Details() {
		Response response =RestAssured.given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization", token)
				.body("{\r\n"
						+ "  \"name\": \"Nikita Playlist Name\",\r\n"
						+ "  \"description\": \"Updated playlist description\",\r\n"
						+ "  \"public\": false\r\n"
						+ "}")
				.when()
				.put("	https://api.spotify.com/v1/playlists/"+playlist_id+"");
		response.prettyPrint();
		response.then().assertThat().statusCode(200);

	}
	
	@Test(priority=11)
	public void update_Playlist_Items() {
		Response response =RestAssured.given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization", token)
				.body("{\r\n"
						+ "  \"range_start\": 1,\r\n"
						+ "  \"insert_before\": 3,\r\n"
						+ "  \"range_length\": 2\r\n"
						+ "}")
				.when()
				.put("	https://api.spotify.com/v1/playlists/"+playlist_id+"/tracks");
		response.prettyPrint();
		response.then().assertThat().statusCode(200);

	}
	
	
	@Test(priority=12)
	public void searchforItem() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization", token)
				.queryParam("q","Arjit singh")
				.queryParam("type","track")
				.when()
				.get("https://api.spotify.com/v1/search");
		response.prettyPrint();
		response.then().assertThat().statusCode(200);
	}
	
	//id-1OeX1bIG5kIHoPDnaNnSx5
	
	@Test(priority=13)
	public void GetTrackAudioAnalysis() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization", token)
				.when()
				.get("https://api.spotify.com/v1/audio-analysis/1OeX1bIG5kIHoPDnaNnSx5");
		response.prettyPrint();
		response.then().assertThat().statusCode(200);
	}
	
	@Test(priority=14)
	public void getTracksAudioFeatures() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization", token)
				.when()
				.get("https://api.spotify.com/v1/audio-features");
		response.prettyPrint();
		response.then().assertThat().statusCode(200);
	}
	
	
	@Test(priority=15)
	public void getTrackAudioFeatures() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization", token)
				.when()
				.get("	https://api.spotify.com/v1/audio-features/1OeX1bIG5kIHoPDnaNnSx5");
		response.prettyPrint();
		response.then().assertThat().statusCode(200);
	}
	
	
	@Test(priority=16)
	public void getSeveralTracks() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization", token)
				.when()
				.get("	https://api.spotify.com/v1/tracks?ids=1OeX1bIG5kIHoPDnaNnSx5");
		response.prettyPrint();
		response.then().assertThat().statusCode(200);
	}
	
	
	@Test(priority=17)
	public void get_Track() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization", token)
				.when()
				.get("	https://api.spotify.com/v1/tracks/1OeX1bIG5kIHoPDnaNnSx5");
		response.prettyPrint();
		response.then().assertThat().statusCode(200);
}
	@Test(priority=18)
	public void getPlaylistCoverImage() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization", token)
				.when()
				.get("https://api.spotify.com/v1/playlists/"+playlist_id+"/images");
		response.prettyPrint();
		response.then().assertThat().statusCode(200);
	}
	

	

	




}
