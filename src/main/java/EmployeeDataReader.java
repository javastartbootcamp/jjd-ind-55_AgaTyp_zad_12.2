import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmployeeDataReader {

    public static Employee[] readFile(File file) throws FileNotFoundException {
        final int linesNo = countLines(file);
        Employee[] employees = new Employee[linesNo];

        try (Scanner sc = new Scanner(file)) {
            for (int i = 0; i < linesNo; i++) {
                String employeeLine = sc.nextLine();
                employees[i] = createEmployeeRecordFromLine(employeeLine);
            }
        }
        return employees;
    }

    private static Employee createEmployeeRecordFromLine(String employeeLine) {
        String[] data = employeeLine.split(";");
        String firstName = data[0];
        String lastName = data[1];
        long pesel = Long.parseLong(data[2]);
        String department = data[3];
        double salary = Double.parseDouble(data[4]);

        return new Employee(firstName, lastName, pesel, department, salary);
    }

    private static int countLines(File file) throws FileNotFoundException {
        int lines = 0;
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                sc.nextLine();
                lines++;
            }
        }
        return lines;
    }
}
