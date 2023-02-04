public class Stats {
    private double avgSalary;
    private double minSalary;
    private double maxSalary;
    private int itEmployers;
    private int supportEmployers;
    private int managementEmployers;

    public Stats(double avgSalary, double minSalary, double maxSalary, int itEmployers, int supportEmployers, int managementEmployers) {
        this.avgSalary = avgSalary;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.itEmployers = itEmployers;
        this.supportEmployers = supportEmployers;
        this.managementEmployers = managementEmployers;
    }

    @Override
    public String toString() {
        String result = "Średnia wypłata: " + avgSalary + "\n" +
                "Minimalna wypłata: " + minSalary + "\n" +
                "Maksymalna wypłata: " + maxSalary + "\n";
        if (itEmployers != 0) {
            result += "Liczba pracowników IT: " + itEmployers + "\n";
        }
        if (supportEmployers != 0) {
            result += "Liczba pracowników Support: " + supportEmployers + "\n";
        }
        if (managementEmployers != 0) {
            result += "Liczba pracowników Management: " + managementEmployers + "\n";
        }
        return result;

    }

}
