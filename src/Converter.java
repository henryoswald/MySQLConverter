import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Converter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		try {
			StringBuffer sqlBuf = new StringBuffer();
			Scanner inputFile = new Scanner(new File("DataFile.txt"));
			
			//put entire SQL into string buffer
			while(inputFile.hasNextLine()) {
				sqlBuf.append(inputFile.nextLine());
			}
			
			//convert to String
			String sql = sqlBuf.toString();
			
			sql = sql.replaceAll("'","\"");
			sql = sql.replaceAll("VARCHAR","VARCHAR2");
			sql = sql.replaceAll("NOT NULL","NOT NULL ENABLE");
			sql = sql.replaceAll("INT","NUMBER(10,0)");
			sql = sql.replaceAll("ENGINE = \\w*;",";");//remove the engine type
			sql = sql.replaceAll("ENGINE = \\w*;",";");//remove the engine type
			sql = sql.replaceAll("IF NOT EXISTS `\\w*`\\.","");//remove the engine type

			
			
			
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
