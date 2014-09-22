package jph_hockey;
import java.sql.*;
import java.lang.String;

public class JPHdb {
	
	private static Connection dbConnect(){
		String dbName = "jph_hockey.db"; // assumes that the working directory contains this file
		
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection( "jdbc:sqlite:".concat(dbName) );
			return(c);
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
			return(null);
		}
	}
	
	public static boolean addShot(String shotType, long time, String team){
		try{
			Connection conn = dbConnect();
			Statement stmt = conn.createStatement();
			
			String timeStr = String.valueOf(time);
			
			String sql = "INSERT INTO shots (time, shotType, team) " + 
					"VALUES ('" + timeStr + "', '" + shotType + "', '" + team + "');";
			
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
			
			System.out.println("Time: " + timeStr + " || Shot type: " + shotType + " || Team: " + team);
			
			return true;
		} catch (Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
			return false;
		}
	}
	
	public static boolean addNeutralZone(String time, boolean success, String team){
		try{
			Connection conn = dbConnect();
			Statement stmt = conn.createStatement();
			
			String timeStr = String.valueOf(time);
			String successStr = "FALSE";
			
			if (success){ successStr = "TRUE"; }
			
			String sql = "INSERT INTO neutral (time, success, team) " + 
					"VALUES ('" + timeStr + "', '" + successStr + "', '" + team + "');";
			
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
			
			System.out.println("Time: " + timeStr + " || Success: " + successStr + " || Team: " + team);
			
			return true;
		} catch (Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
			return false;
		}
	}
	
	public static void addShift(long time, String player, String playing){
		try{
			Connection conn = dbConnect();
			String timeStr = String.valueOf(time);
			Statement stmt = conn.createStatement();
			
			String sql = "INSERT INTO shift (time, player, playing) " + 
					"VALUES ('" + timeStr + "', '" + player + "', '" + playing + "');";
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
			
			System.out.println("Time: " + timeStr + " || Player: " + player + " || Playing: " + playing);
		} catch (Exception e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}
	
	public static void createTables(){
		
		try{
			Connection conn = dbConnect();
			Statement stmt = conn.createStatement();
			String shots_sql =  "CREATE TABLE IF NOT EXISTS shots (time TEXT, shotType TEXT, team TEXT);";
			String neutral_sql =  "CREATE TABLE IF NOT EXISTS neutral (time TEXT, success INTEGER, team TEXT);";
			String shift_change =  "CREATE TABLE IF NOT EXISTS shift (time TEXT, player INTEGER, playing TEXT);";
			
			stmt.executeUpdate(shots_sql);
			stmt.executeUpdate(shift_change);
			stmt.executeUpdate(neutral_sql);
			
			System.out.println("Tables created if needed.");
			conn.close();
		} catch (Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		
	}
}