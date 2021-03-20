import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Discipline {
    String name;
    int lecHours;
    int praHours;
    int numGroup;

    public Discipline(String name, int lecHours, int praHours, int numGroup) {
        this.name = name;
        this.lecHours = lecHours;
        this.praHours = praHours;
        this.numGroup = numGroup;
    }
    public Discipline() {
        name="";
        lecHours=0;
        praHours=0;
        numGroup=0;
    }
    public void havingLessonForOneGroup(ArrayList<Discipline> a) {
        int groupSc;
        String disciplineSc;
        int numOfLessonSc;
        int chooserChecker;
        Scanner scanner2=new Scanner(System.in);
        System.out.print("Write discipline:");
        disciplineSc=scanner2.nextLine();
        System.out.print("Write group:");
        Scanner scannerGr=new Scanner(System.in);
        groupSc=scannerGr.nextInt();
        Discipline disGet=new Discipline();
        for(int i=0;i<a.size();i++) {
            disGet=a.get(i);
            if(disGet.name.equals(disciplineSc)&&groupSc==disGet.numGroup) {
                System.out.println(a.get(i));
                System.out.print("Write count lessons:");
                Scanner scannerLs=new Scanner(System.in);
                numOfLessonSc=scannerLs.nextInt();
                do {
                System.out.print("If you want to teach a lesson (write 1), practise lesson (write 2):");
                Scanner scannerCh=new Scanner(System.in);
                chooserChecker=scannerCh.nextInt();

                    if (chooserChecker == 1) {
                        disGet.lecHours += numOfLessonSc;
                    } else if (chooserChecker == 2) {
                        disGet.praHours += numOfLessonSc;
                    }
                    else chooserChecker=0;
                }
                while (!(chooserChecker==1||chooserChecker==2));

                System.out.println(a.get(i));

                break;
            }
            else if(!(disGet.name.equals(disciplineSc))&&i==a.size()-1) {
                System.out.println("There is no such discipline");
                System.exit(0);

            }
        }
    }
    public void havingLessonForSeveralGroup(ArrayList<Discipline> a) {
        int scannerGr;
        String disciplineSc;
        int numOfLessonSc;
        int chooserChecker;
        int[] arrForGroup=new int[a.size()];
        Scanner scanner2=new Scanner(System.in);
        System.out.print("Write discipline:");
        disciplineSc=scanner2.nextLine();
        for (int i=0;i<a.size();i++) {
            System.out.print("Write group(if you wrote all groups write 0):");
            Scanner scanner=new Scanner(System.in);
            scannerGr=scanner.nextInt();
            System.out.println(scannerGr);
            if(scannerGr>0) {
                arrForGroup[i]=scannerGr;
            }
            else break;
        }
        System.out.print("Write count lessons:");
        Scanner scannerLs = new Scanner(System.in);
        numOfLessonSc = scannerLs.nextInt();
        System.out.print("If you want to teach a lesson (write 1), practise lesson (write 2):");
        Scanner scannerCh = new Scanner(System.in);
        chooserChecker = scannerCh.nextInt();
        do {
            Discipline disGet = new Discipline();
            for(int i=0;i<arrForGroup.length;i++) {
                for (int j=0;j<a.size();j++) {
                    disGet=a.get(j);
                    if(disGet.name.equals(disciplineSc)&&arrForGroup[i]==disGet.numGroup) {
                        if (chooserChecker == 1) {
                            System.out.println("Before changed="+a.get(j));
                            disGet.lecHours += numOfLessonSc;
                            System.out.println("After changed="+a.get(j));
                        } else if (chooserChecker == 2) {
                            System.out.println("Before changed="+a.get(j));
                            disGet.praHours += numOfLessonSc;
                            System.out.println("After changed="+a.get(j));
                        }
                        else chooserChecker=0;
                    }
                }
            }
        } while (!(chooserChecker == 1 || chooserChecker == 2)) ;
    }
    @Override
    public String toString() {
        return "Discipline{" +
                "name='" + name + '\'' +
                ", lecHours=" + lecHours +
                ", praHours=" + praHours +
                ", numGroup=" + numGroup +
                '}';
    }
}
class Mark {
    String date;
    String teacherOrDiscipline;
    int studentId;
    int mark;
    String commentOrExercise;

    public Mark(String date, String Discipline, int studentId, int mark, String commentOrExercise) {
        this.date = date;
        this.teacherOrDiscipline = Discipline;
        this.studentId = studentId;
        this.mark = mark;
        this.commentOrExercise = commentOrExercise;
    }

    public Mark() {
        date="";
        teacherOrDiscipline="";
        studentId=0;
        mark=0;
        commentOrExercise="";

    }

    @Override
    public String toString() {
        return "Mark{" +
                "date='" + date + '\'' +
                ", teacherOrDiscipline='" + teacherOrDiscipline + '\'' +
                ", studentId=" + studentId +
                ", mark=" + mark +
                ", commentOrExercise='" + commentOrExercise + '\'' +
                '}';
    }

    public void giveMarks(ArrayList<Mark> a, ArrayList<Discipline> b) {

        String dateSc;
        String disciplineSc;
        int groupSc;
        int studentSc;
        int markSc;
        String exerciseSc;
        int checkerPraHours=0;
        int checkerStuId=0;
        int counter=0;
        int chooser=0;
        Discipline checkDs=new Discipline();
        Mark checkMr=new Mark();
        Scanner scanner2=new Scanner(System.in);
        System.out.print("Write discipline:");
        disciplineSc=scanner2.nextLine();
        Scanner scannerGr=new Scanner(System.in);
        System.out.print("Write group:");
        groupSc=scannerGr.nextInt();
        for(int i=0;i<b.size();i++) {
            checkDs=b.get(i);
            if(checkDs.name.equals(disciplineSc)&&groupSc==checkDs.numGroup) {  //ошибка
                checkerPraHours=checkDs.praHours;
                break;
            }
            else if(!(checkDs.name.equals(disciplineSc))&&i==b.size()-1) {
                System.out.println("There is no such discipline");
                System.exit(0);

            }
        }
        System.out.println(checkerPraHours);
        Scanner scanner3=new Scanner(System.in);
        System.out.print("Write student ID:");
        studentSc=scanner3.nextInt();
        System.out.println(studentSc);
        for (int i=0;i<a.size();i++) {
            checkMr=a.get(i);
            checkerStuId=studentSc;
            if(checkerStuId==checkMr.studentId) {
                counter++;
            }
        }
        do{
            if(counter<checkerPraHours) {
            Scanner scannerChooser=new Scanner(System.in);
            System.out.print("You would  give all marks for student "+checkerStuId+" (write 1) or only one(write 2):");
            chooser=scannerChooser.nextInt();

               if(chooser==1) {
                   checkerPraHours=checkerStuId-counter;
                   for (int i=0;i<checkerPraHours;i++) {
                       Scanner scanner1=new Scanner(System.in);
                       System.out.print("Write date 'DD|MM|YY':");
                       dateSc=scanner1.nextLine();
                       Scanner scanner4=new Scanner(System.in);
                       System.out.print("Write mark:");
                       markSc=scanner4.nextInt();
                       Scanner scanner5=new Scanner(System.in);
                       System.out.print("Write exercise or comment:");
                       exerciseSc=scanner5.nextLine();
                       Mark markInMethodGM=new Mark(dateSc,disciplineSc,studentSc,markSc,exerciseSc);
                       a.add(markInMethodGM);
                       System.out.println(a.get(0));
                   }
               }
               else if(chooser==2) {
                   Scanner scanner1=new Scanner(System.in);
                   System.out.print("Write date 'DD|MM|YY':");
                   dateSc=scanner1.nextLine();
                   Scanner scanner4=new Scanner(System.in);
                   System.out.print("Write mark:");
                   markSc=scanner4.nextInt();
                   Scanner scanner5=new Scanner(System.in);
                   System.out.print("Write exercise or comment:");
                   exerciseSc=scanner5.nextLine();
                   Mark markInMethodGM=new Mark(dateSc,disciplineSc,studentSc,markSc,exerciseSc);
                   a.add(markInMethodGM);
                   System.out.println(a.get(0));
               }
               else System.out.println("You write another number, try again and write 1 or 2");
            }
             else {
                System.out.println("Sorry, you cannot rate because number of practice lessons = number of ratings");
            }
        }
        while (!(chooser==1||chooser==2));
    }
}
class Student {
    int id;
    String nameSt;
    String surnameSt;
    int groupSt;

    public Student(int id, String nameSt, String surnameSt, int groupSt) {
        this.id = id;
        this.nameSt = nameSt;
        this.surnameSt = surnameSt;
        this.groupSt = groupSt;
    }
    public Student() {
        id=0;
        nameSt="";
        surnameSt="";
        groupSt=0;
    }

    public void groupRating(ArrayList<Discipline> d, ArrayList<Student> s, ArrayList<Mark> m) {
        Discipline objDis=new Discipline();
        Student objStu=new Student();
        Mark objMark=new Mark();
        String disSc;
        int groupSc;
        int count=0;
        double averageMark=0.0;
        System.out.print("Write discipline:");
        Scanner disciplSc=new Scanner(System.in);
        disSc=disciplSc.nextLine();
        System.out.print("Write group:");
        Scanner scanner=new Scanner(System.in);
        groupSc=scanner.nextInt();
        for (int i=0;i<s.size();i++){
            objStu=s.get(i);
            if(groupSc==objStu.groupSt) {
                for (int j=0;j<m.size();j++) {
                    objMark=m.get(j);
                    if(objStu.id==objMark.studentId&&disSc.equals(objMark.teacherOrDiscipline)) {
                        count++;
                        System.out.println(objMark.mark);
                        averageMark+=objMark.mark;
                    }
                }
            }
        }
        System.out.println("Average mark "+averageMark/count);
    }
    public void report(ArrayList<Discipline> d, ArrayList<Student> s, ArrayList<Mark> m) {
        Discipline objDis=new Discipline();
        Student objStu=new Student();
        Mark objMark=new Mark();
        String disSc;
        int repGroupChecker;
        boolean checker=false;
        int[] group=new int[d.size()];
        System.out.print("Write discipline:");
        Scanner disciplSc=new Scanner(System.in);
        disSc=disciplSc.nextLine();
        for (int i=0;i<d.size();i++) {
            objDis=d.get(i);
            repGroupChecker=0; //repGroupC обнуляется при каждом проходе цикла
            for (int t=0;t<group.length;t++) {  //проверка наличия группы в arr, если её нет то цикл прерывается
                if(group[t]==objDis.numGroup){checker=true;break;}
                else if(!(group[t]==objDis.numGroup)&&group[t]==0) {
                    checker=false;
                    group[t]=objDis.numGroup;
                    repGroupChecker=group[t];
                    break;
                }
            }
            if(checker==true) {
                break;
            }
            ArrayList<Report> reportArrayList=new ArrayList<>();
            if(objDis.name.equals(disSc)) {
                for (int j=0;j<s.size();j++) {
                    objStu=s.get(j);
                    if(objDis.numGroup==objStu.groupSt) {
                        for (int k=0;k<m.size();k++) {
                            objMark=m.get(k);
                            if (objStu.id== objMark.studentId) {
                                Report objRep=new Report(objDis.name,objStu.nameSt,objStu.surnameSt, objStu.id, objStu.groupSt, objMark.mark);
                                reportArrayList.add(objRep);
                            }
                        }
                    }
                }
            }

            Comparator<Report> comparator=Comparator.comparing(obj->obj.getMarkRep());
            Collections.sort(reportArrayList, comparator);
            System.out.println("******Group "+objDis.numGroup+"******");
            for (int z=0;z<reportArrayList.size();z++) {
                System.out.println(reportArrayList.get(z));
            }

        }
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nameSt='" + nameSt + '\'' +
                ", surnameSt='" + surnameSt + '\'' +
                ", groupSt=" + groupSt +
                '}';
    }
}
public class ProgExNum3 {
     public static void main(String[] args) {
         Discipline english201=new Discipline("English",10,3,201);
         Discipline english202=new Discipline("English",10,10,202);
         Discipline math201=new Discipline("Math",9,18,201);
         Discipline math202=new Discipline("Math",9,18,202);
         Discipline discipline=new Discipline();
         ArrayList<Discipline> allDis=new ArrayList<>();
         allDis.add(english201);
         allDis.add(english202);
         allDis.add(math201);
         allDis.add(math202);
         Student student1910111=new Student(1910111,"Пшеничный","Роман",201);
         Student student1910213=new Student(1910213,"Карпенко","Юрий",202);
         Student student1910214=new Student(1910214,"Павлив","Владислав",202);
         Student student1910120=new Student(1910120,"Карнаухов","Артемий",201);
         Student student1910218=new Student(1910218,"Петренко","Роман",202);
         Student student1910124=new Student(1910124,"Пустовит","Андрей",201);
         Student student1910212=new Student(1910212,"Петров","Андрей",202);
         ArrayList<Student> allStudents=new ArrayList<>();
         allStudents.add(student1910111);
         allStudents.add(student1910213);
         allStudents.add(student1910214);
         allStudents.add(student1910120);
         allStudents.add(student1910218);
         allStudents.add(student1910124);
         allStudents.add(student1910212);
         Mark mark=new Mark();
         ArrayList<Mark> allMarks=new ArrayList<>();
         Mark mark1=new Mark("21|02|21","English",1910111,4,"Ex.21");
         Mark mark2=new Mark("21|02|21","English",1910213,5,"Ex.21");
         Mark mark3=new Mark("21|02|21","English",1910120,6,"Ex.21");
         Mark mark4=new Mark("21|02|21","English",1910214,7,"Ex.21");
         Mark mark5=new Mark("21|02|21","Math",1910218,5,"Ex.21");
         Mark mark6=new Mark("21|02|21","Math",1910124,6,"Ex.21");
         Mark mark7=new Mark("21|02|21","Math",1910212,3,"Ex.21");
         allMarks.add(mark1);
         allMarks.add(mark2);
         allMarks.add(mark3);
         allMarks.add(mark4);
         allMarks.add(mark5);
         allMarks.add(mark6);
         allMarks.add(mark7);
         mark.giveMarks(allMarks,allDis);
         //discipline.havingLessonForOneGroup(allDis);
         //discipline.havingLessonForSeveralGroup(allDis);
         //student1910111.groupRating(allDis,allStudents,allMarks);
         //student1910111.report(allDis,allStudents,allMarks);
    }
}
