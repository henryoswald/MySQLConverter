
import java.io.*;
import java.util.*;


public class Converter {


	public static void main(String[] args) {
		

		try {
			StringBuffer sqlBuf = new StringBuffer();
			Scanner inputFile = new Scanner(new File("test.sql"));
			
			//put entire SQL into string buffer
			while(inputFile.hasNextLine()) {
				sqlBuf.append(inputFile.nextLine());
				sqlBuf.append("\n");
			}
			
			//convert to String
			String sql = sqlBuf.toString();
			
			sql = sql.replaceAll("`","\"");
			sql = sql.replaceAll("VARCHAR","VARCHAR2");
			sql = sql.replaceAll("NOT NULL","NOT NULL ENABLE");
			sql = sql.replaceAll(" INT "," NUMBER ");
			sql = sql.replaceAll("ENGINE = \\w*;",";");//remove the engine type
			sql = sql.replaceAll("IF NOT EXISTS .\\w*.\\.","");//remove the engine type
			sql = sql.replaceAll("DATETIME;","TIMESTAMP");//remove the engine type

			//remove the crap at the top
			sql = sql.replaceAll("CREATE SCHEMA.*?;","");//remove the engine type
			sql = sql.replaceAll("USE.*?;","");//remove the engine type
			sql = sql.replaceAll("SET.*?;","");//remove the engine type

			

	        BufferedWriter writer = new BufferedWriter(new FileWriter("oracle.sql"));
	        
	        writer.append(sql);
	        writer.flush();
			
			

		} catch (FileNotFoundException e) {
			System.err.println("file not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("there was an IO exeption");
			e.printStackTrace();
		}
	}

}
