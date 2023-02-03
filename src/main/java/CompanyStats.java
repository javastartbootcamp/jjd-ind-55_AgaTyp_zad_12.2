public class CompanyStats {
    public double getAvgSalary(Employee[] employees) {
        double totalSalary = 0;
        int employeesNo = 0;

        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
            employeesNo++;
        }

        try {
            return totalSalary / employeesNo;
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    public double getMinSalary(Employee[] employees) {
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

    public double getMaxSalary(Employee[] employees) {
        double maxSalary = 0;

        for (Employee employee : employees) {
            if (maxSalary < employee.getSalary()) {
                maxSalary = employee.getSalary();
            }
        }
        return maxSalary;
    }

    public String getDepartmentEmployment(Employee[] employees, String department) {
        int employeeNo = 0;
        for (Employee employee : employees) {
            if (department.equals(employee.getDepartment())) {
                employeeNo++;
            }
        }
        return "Liczba pracowników " + department + ": " + employeeNo;
    }

}
