import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;

public class csvFinal {
    public class ReadCSVData {
        public static final String actors
                = "..\\..\\Files\\actors.csv";
        public static final String films
                = "..\\..\\Files\\films.csv";
        public static final String generes
                = "..\\..\\Files\\generes.csv";
    }

    public static void main (String[] args) {
        System.out.println("Read Data Line by Line with Header \n");
        ArrayList<String> actors = readDataLineByLine(ReadCSVData.actors);
        ArrayList<String> films = readDataLineByLine(ReadCSVData.films);
        ArrayList<String> generes = readDataLineByLine(ReadCSVData.generes);
        System.out.println("___________________________________");
        for (int i = 0; i < actors.size() - 1; i++) {
            System.out.println(actors.get(i) + " | " + films.get(i) + " | " + generes.get(i));
        }
    }

    public static ArrayList<String> readDataLineByLine (String file) {

        ArrayList<String> Result = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(file);
            CSVReader csvReader = new CSVReader(fileReader);
            String[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    Result.add(cell);
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return Result;
    }
}
