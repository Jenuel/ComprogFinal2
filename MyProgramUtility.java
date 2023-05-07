package proj2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class MyProgramUtility {
    public static void main(String[] args) {
        MyProgramUtility program;

        try {
            program = new MyProgramUtility();
            program.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//end of main method

    public void run() throws Exception {
        List<Citizen> citizens = readDataFileIntoList("data.csv");
        citizens.forEach(System.out::println);
    }//end of run

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
    }//end of readDataFileIntoList
    
     public void showPopulationPerDistrictResidentOrNot(List<Citizen> citizens){
        System.out.println(" Population per district and resident status: ");
        Map<Integer, Map<Boolean , List<Citizen>>> districtInfo=citizens.stream().collect(Collectors.groupingBy(Citizen::getDistrict,Collectors.groupingBy(Citizen::isResident)));
        Set<Integer> districts= districtInfo.keySet();
        for (Integer district : districts){
            System.out.printf("District %d : %n", district);
            Map<Boolean, List<Citizen>> residents= districtInfo.get(district);
            Set<Boolean> isResident= residents.keySet();
            for (Boolean status : isResident){
                List<Citizen> cit = residents.get(status);
                int total = cit.size();
                System.out.printf(" %s : %d%n" , (status? "Resident" : "Not Resident" ) , total );
            }
        }
    } // end of showPopulationPerDistrictResidentOrNot method

    public void showPopulationPerDistrict(List<Citizen> citizens){
        System.out.println("List of districts and corresponding number of citizens");
        Map<Integer, List<Citizen>> districtInfo = citizens.stream().collect(Collectors.groupingBy(Citizen::getDistrict));
        Set<Integer> districts = districtInfo.keySet();
        for (Integer district : districts){
            List<Citizen> cit = districtInfo.get(district);
            int total = cit.size();
            System.out.printf("District %s: %d%n", district, total);
        }
    }//end of method

    public void showFiveYoungestCitizensAccordingToGender(List<Citizen> citizens) {
        System.out.println("Five youngest citizens according to gender:");
        Comparator<Citizen> comparator = (cit1, cit2) -> {
            if (cit1.getAge() > cit2.getAge()) {
                return 1;
            } else if (cit1.getAge() < cit2.getAge()) {
                return -1;
            } else {
                return 0;
            }
        };
        System.out.println("Male");
        citizens
                .stream()
                .filter(cit -> cit.getGender() == 'M').sorted(comparator)
                .limit(5)
                .forEach(System.out::println);
        System.out.println("\nFemale");
        citizens
                .stream()
                .filter(cit -> cit.getGender() == 'F').sorted(comparator)
                .limit(5)
                .forEach(System.out::println);
        System.out.println("=======================================================================================\n");
    }//end of method

    public void showListOfSeniorCitizenInDescendingOrder(List<Citizen> citizens){
        System.out.println("List of senior citizens in descending order:");
        Comparator<Citizen> comparator = (cit1, cit2) -> {
            if (cit1.getAge() > cit2.getAge()){
                return -1;
            } else if (cit1.getAge() < cit2.getAge()) {
                return 1;
            } else {
                return 0;
            }
        };
        citizens.stream().filter(cit -> cit.getAge() > 59).sorted(comparator).forEach(System.out::println);
    }//end of method
}//end of class
