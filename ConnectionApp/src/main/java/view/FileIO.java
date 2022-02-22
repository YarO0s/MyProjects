package view;

import model.ItemNotFoundException;

import java.io.*;

public class FileIO {

    public String read(String source) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(source));
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                line = reader.readLine();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void write(String destination, String message) throws FileNotFoundException {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(destination));
            writer.write(message);
            writer.close();
        } catch(Exception e){
            e.printStackTrace();

        }
    }
}
