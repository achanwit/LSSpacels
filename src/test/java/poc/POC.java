package poc;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class POC {

	public POC() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws FileNotFoundException {
		long Begin = System.currentTimeMillis();
		String LSSPACELS = "LSSPACELS";
		// TODO Auto-generated method stub
		String inputFilePath = "/home/chanwit/Documents/LSSpace/A.Input/InputLarg_TH.txt";
		String outputFilePath = "/home/chanwit/Documents/LSSpace/A.Input/OutputLarg_TH.txt";
		
		FileInputStream inputString = new FileInputStream(inputFilePath);
		
		DataInputStream in = new DataInputStream(inputString);
		BufferedReader br1 = new BufferedReader(new InputStreamReader(in));
		StringBuffer inputBuf = new StringBuffer();
		
		try {
			String line = null;
			while ((line = br1.readLine()) != null){
				byte[] byteArrray = line.getBytes();
				String inPutUTF8 = new String(byteArrray, StandardCharsets.UTF_8.name());
				

				String outputTemp = inPutUTF8.replace(" ", "");
				outputTemp = outputTemp.replace(LSSPACELS, " ");

				
//				System.out.println("line: "+outputTemp);
				writeFile(outputTemp, outputFilePath);
			}
		}catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (br1 != null)
					br1.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		long End = System.currentTimeMillis();
		long Total = End - Begin;
		System.out.println("Total Time Use: "+Total);
		
		
		
		
		

	}
	
	/*** Common method for create new file ***/
	public static void writeFile(String result, String outFilePath) {
		File file = new File(outFilePath);	
		try {
			if(file.createNewFile()) {
				writeLineinFile(result, outFilePath, file);
			}else {
				writeLineinFile(result, outFilePath, file);
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	/*** Common method for write file ***/
	private static void writeLineinFile(String result, String outFilePath, File file) {
		
		FileWriter writer;
		try {
			writer = new FileWriter(file, true);
			writer.write(result+"\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
