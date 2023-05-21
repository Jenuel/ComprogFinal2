//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package prog2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyProgramUtility {


    public static void main(String[] args) {
        try {
            MyProgramUtility program = new MyProgramUtility();
            program.run();
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public void run() throws Exception {
        List<Citizen> citizens = this.readDataFileIntoList("data.csv");
        showPopulationPerDistrict(citizens);
        showFiveYoungestCitizensAccordingToGender(citizens);
        showListOfSeniorCitizenInDescendingOrder(citizens);
    }

    private List<Citizen> readDataFileIntoList(String filename) throws IOException {

        List<Citizen> citizens = new ArrayList();
        BufferedReader reader = new BufferedReader(new FileReader("data.csv"));

        while(true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }

            String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

            String strContent = data[3];
            String strPattern = "\"([^\"]*)\"";
            String addressPOBox = "";

            if (strContent.charAt(0) == '\"') {
                Pattern pattern = Pattern.compile(strPattern);
                Matcher matcher = pattern.matcher(strContent);
                while (matcher.find()) {
                    addressPOBox = matcher.group(1);
                }
            } else {
                addressPOBox = strContent;
            }

            Citizen citizen = new Citizen(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]), Boolean.parseBoolean(data[5]), Integer.parseInt(data[6]), data[7].charAt(0));
            citizens.add(citizen);

        }
        reader.close();
        return citizens;

    }

    public void showPopulationPerDistrictResidentOrNot(List<Citizen> citizens) {
        System.out.println(" Population per district and resident status: ");
        Map<Integer, Map<Boolean, List<Citizen>>> districtInfo = (Map)citizens.stream().collect(Collectors.groupingBy(Citizen::getDistrict, Collectors.groupingBy(Citizen::isResident)));
        Set<Integer> districts = districtInfo.keySet();
        Iterator var4 = districts.iterator();

        while(var4.hasNext()) {
            Integer district = (Integer)var4.next();
            System.out.printf("District %d : %n", district);
            Map<Boolean, List<Citizen>> residents = (Map)districtInfo.get(district);
            Set<Boolean> isResident = residents.keySet();
            Iterator var8 = isResident.iterator();

            while(var8.hasNext()) {
                Boolean status = (Boolean)var8.next();
                List<Citizen> cit = (List)residents.get(status);
                int total = cit.size();
                System.out.printf(" %s : %d%n", status ? "Resident" : "Not Resident", total);
            }
        }

    }

    public void showPopulationPerDistrict(List<Citizen> citizens) {
        System.out.println("List of districts and corresponding number of citizens");
        Map<Integer, List<Citizen>> districtInfo = (Map)citizens.stream().collect(Collectors.groupingBy(Citizen::getDistrict));
        Set<Integer> districts = districtInfo.keySet();
        Iterator var4 = districts.iterator();

        while(var4.hasNext()) {
            Integer district = (Integer)var4.next();
            List<Citizen> cit = (List)districtInfo.get(district);
            int total = cit.size();
            System.out.printf("District %s: %d%n", district, total);
        }

    }

    public void showFiveYoungestCitizensAccordingToGender(List<Citizen> citizens) {
        System.out.println("Five youngest citizens according to gender:");
        Comparator<Citizen> comparator = (cit1, cit2) -> {
            if (cit1.getAge() > cit2.getAge()) {
                return 1;
            } else {
                return cit1.getAge() < cit2.getAge() ? -1 : 0;
            }
        };
        System.out.println("\nMale");
        Stream var10000 = citizens.stream().filter((cit) -> {
            return cit.getGender() == 'M';
        }).sorted(comparator).limit(5L);
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        var10000.forEach(var10001::println);
        System.out.println("\nFemale");
        var10000 = citizens.stream().filter((cit) -> {
            return cit.getGender() == 'F';
        }).sorted(comparator).limit(5L);
        var10001 = System.out;
        Objects.requireNonNull(var10001);
        var10000.forEach(var10001::println);
        System.out.println("=======================================================================================\n");
    }

    public void showListOfSeniorCitizenInDescendingOrder(List<Citizen> citizens) {
        System.out.println("List of senior citizens in descending order:");
        Comparator<Citizen> comparator = (cit1, cit2) -> {
            if (cit1.getAge() > cit2.getAge()) {
                return -1;
            } else {
                return cit1.getAge() < cit2.getAge() ? 1 : 0;
            }
        };
        Stream var10000 = citizens.stream().filter((cit) -> {
            return cit.getAge() > 59;
        }).sorted(comparator);
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        var10000.forEach(var10001::println);
    }
}
