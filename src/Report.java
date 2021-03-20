public class Report {
    String disRep;
    String nameRep;
    String surnameRep;
    int idRep;
    int groupRep;
    int markRep;

    public Report(String disRep, String nameRep, String surnameRep, int idRep, int groupRep, int markRep) {
        this.disRep = disRep;
        this.nameRep = nameRep;
        this.surnameRep = surnameRep;
        this.idRep = idRep;
        this.groupRep = groupRep;
        this.markRep = markRep;
    }
    public Report() {
        disRep="";
        nameRep="";
        surnameRep="";
        idRep=0;
        groupRep=0;
        markRep=0;
    }

    public int getMarkRep() {
        return markRep;
    }

    public void setMarkRep(int markRep) {
        this.markRep = markRep;
    }

    @Override
    public String toString() {
        return "Report{" +
                "discipline='" + disRep + '\'' +
                ", name='" + nameRep + '\'' +
                ", surname='" + surnameRep + '\'' +
                ", id=" + idRep +
                ", group=" + groupRep +
                ", mark=" + markRep +
                '}';
    }
}
