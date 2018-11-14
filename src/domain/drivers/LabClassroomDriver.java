package src.domain.drivers;
import src.domain.classes.Classroom;
import src.domain.classes.LabClassroom;
import src.domain.utils.UtilsDomain;

import java.util.Scanner;
import java.util.Vector;

public class LabClassroomDriver {

    private static LabClassroom lab;

    private static void writeClassroom(Classroom c){
        String s = c.getName() + " "
                + String.valueOf(c.getCapacity()) + " "
                + String.valueOf(c.getType().name()) + " ";
        if(c.isMultimedia()) s += "true ";
        else s += "false ";
        if(c.getType() == UtilsDomain.ClassType.LABORATORY) {
            LabClassroom l = (LabClassroom) c;
            s += String.valueOf(l.getNumComputers());
        }
        else s += "0";

        System.out.println(s);
    }

    public static void testConstructor(){
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int cap = sc.nextInt();
        boolean multimedia = sc.nextBoolean();
        int nComp = sc.nextInt();
        lab = new LabClassroom(name, cap, multimedia, nComp);
    }
    public static void testConstructorFromString(){
        Vector<String> vec = new Vector<String> (4);
        Scanner sc = new Scanner(System.in);

        vec.add(sc.next()); //name
        vec.add(String.valueOf(sc.nextInt())); //capacity
        vec.add(sc.next()); //type (Laboratory)
        vec.add(sc.next()); //multimedia
        vec.add(String.valueOf(sc.nextInt())); //nComp

        lab = new LabClassroom(vec);
    }
    public static void testFromStr(){
        Scanner sc = new Scanner(System.in);
        Vector<String> v = new Vector<> (5);
        v.add(sc.next()); //name
        v.add(sc.next()); //capacity
        v.add("LABORATORY"); //type
        v.add(sc.next()); //multimedia
        v.add(sc.next()); //nComp

        writeClassroom(Classroom.fromStr(v));
    }
    public static void testGetName(){
        System.out.println(lab.getName());
    }
    public static void testGetCapacity(){
        System.out.println(lab.getCapacity());
    }
    public static void testGetType(){
        System.out.println(lab.getType().name());
    }
    public static void testGetMultimedia(){
        if(lab.isMultimedia()) System.out.println("true");
        else System.out.println("false");
    }
    public static void testGetNumComputers(){
        System.out.println(lab.getNumComputers());
    }
    public static void testToStr(){
        Vector<String> v = lab.toStr();
        System.out.println(v.get(0)
                + " " + v.get(1)
                + " " + v.get(2)
                + " " + v.get(3)
                + " " + v.get(4));
    }

    public static void  main(String args[]) {
        lab = new LabClassroom();
        Scanner sc = new Scanner(System.in);
        write();
        do{

            int i = sc.nextInt();
            switch(i) {
                case 0:
                    testConstructor();
                    break;
                case 1:
                    testConstructorFromString();
                    break;
                case 2:
                    testFromStr();
                    break;
                case 3:
                    testGetName();
                    break;
                case 4:
                    testGetCapacity();
                    break;
                case 5:
                    testGetType();
                    break;
                case 6:
                    testGetMultimedia();
                    break;
                case 7:
                    testGetNumComputers();
                    break;
                case 8:
                    testToStr();
                    break;
                default:
                    System.out.println("\tEXIT");
            }
            write();
        }while(sc.hasNextInt());

    }

    //TODO: treure això pels jocs de proves
    public static void write() {
        System.out.println("------------------------------------------");
        System.out.println("\nWrite the number of the function you want to test:");
        System.out.println("\t0 -> Basic constructor");
        System.out.println("\t1 -> Constructor from String");
        System.out.println("\t2 -> From String");
        System.out.println("\t3 -> Name getter");
        System.out.println("\t4 -> Capacity getter");
        System.out.println("\t5 -> Type getter");
        System.out.println("\t6 -> Multimedia getter");
        System.out.println("\t7 -> NumComputers getter");
        System.out.println("\t8 -> Convert Object to String");
    }

}