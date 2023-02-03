import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("employees.csv");
        Employee[] employees = EmployeeDataReader.readFile(file);

        CompanyStats calcStats = new CompanyStats();

        if (file.exists()) {
            File stats = new File("stats.txt");
            stats.createNewFile();

            FileWriter fileWriter = new FileWriter(stats);
            fileWriter.write("Średnia wypłata: " + calcStats.getAvgSalary(employees) + "\n");
            fileWriter.write("Minimalna wypłata: " + calcStats.getMinSalary(employees) + "\n");
            fileWriter.write("Maksymalna wypłata: " + calcStats.getMaxSalary(employees) + "\n");
            fileWriter.write(calcStats.getDepartmentEmployment(employees, "IT") + "\n");
            fileWriter.write(calcStats.getDepartmentEmployment(employees, "Support") + "\n");
            fileWriter.write(calcStats.getDepartmentEmployment(employees, "Management") + "\n");

            fileWriter.close();
        }

    }
}
