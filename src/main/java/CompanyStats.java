import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CompanyStats {
    public Stats getStats(Employee[] employees) {
        return new Stats(getAvgSalary(employees), getMinSalary(employees), getMaxSalary(employees),
                getDepartmentEmployment(employees, "IT"), getDepartmentEmployment(employees, "Support"),
                getDepartmentEmployment(employees, "Management"));
    }

    private double getAvgSalary(Employee[] employees) {
        double totalSalary = 0;
        int employeesNo = 0;

        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
            employeesNo++;
        }

        if (employeesNo != 0) {
            return totalSalary / employeesNo;
        } else {
            return 0;
        }
    }

    private double getMinSalary(Employee[] employees) {
        double minSalary = 0;

        for (int i = 0; i < employees.length; i++) {
            if (i == 0) {
                minSalary = employees[i].getSalary();
            } else if (minSalary > employees[i].getSalary()) {
                minSalary = employees[i].getSalary();
            }
        }
        return minSalary;
    }

    private double getMaxSalary(Employee[] employees) {
        double maxSalary = 0;

        for (Employee employee : employees) {
            if (maxSalary < employee.getSalary()) {
                maxSalary = employee.getSalary();
            }
        }
        return maxSalary;
    }

    private int getDepartmentEmployment(Employee[] employees, String department) {
        int employeeNo = 0;
        for (Employee employee : employees) {
            if (department.equals(employee.getDepartment())) {
                employeeNo++;
            }
        }
//        return "Liczba pracowników " + department + ": " + employeeNo;
        return employeeNo;
    }

    public static void saveStats(Stats stats, File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(stats.toString());
        fileWriter.close();
    }

}
