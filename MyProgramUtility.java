package prog2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MyProgramUtility {
    public static void main(String[] args) {
        MyProgramUtility program;

        try {
            program = new MyProgramUtility();
            program.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run() throws Exception {
        List<Citizen> citizens = readDataFileIntoList("data.csv");
        citizens.forEach(System.out::println);
    }

    private List<Citizen> readDataFileIntoList(String filename) {
        try {
            List<Citizen> citizens = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                String[] data = line.split(",");
                boolean resident = data[5].equalsIgnoreCase("resident");
                Citizen cit = new Citizen(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]), resident,
                        Integer.parseInt(data[6]), data[7].charAt(0));
                citizens.add(cit);
            }
            reader.close();
            return citizens;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
