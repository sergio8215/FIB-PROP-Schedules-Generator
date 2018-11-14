package src.domain.drivers;

import src.domain.classes.ClassClass;
import src.domain.classes.TheoryClass;
import src.domain.classes.Subject;
import src.domain.utils.UtilsDomain;

import src.domain.utils.inout;
import java.util.Vector;

public class TheoryClassDriver {

    public static ClassClass tc;
    public static inout i = new inout();

    private static void testConstructor() throws Exception {
        String identifier;
        int group;
        int subGroup;
        UtilsDomain.ClassType typeG;
        UtilsDomain.TimeZone shift;
        int quantityStudents;


        String subjectName;
        int num_students;
        int level;
        int[] hoursClasses = new int[3];
        int[] numberOfGroups = new int[2];
        UtilsDomain.typeShift shiftSubj;

        System.out.print("ID: ");
        identifier = i.readword();
        System.out.print("Group: ");
        group = i.readint();
        System.out.print("subGroup: ");
        subGroup = i.readint();
        System.out.print("Type of group 0.Theory, 1.Lab, 2.Problems: ");
        typeG = UtilsDomain.ClassType.values()[i.readint()];
        System.out.print("Type of group 0.Morning, 1.Afternoon: ");
        shift = UtilsDomain.TimeZone.values()[i.readint()];
        System.out.print("Quantity students: ");
        quantityStudents = i.readint();

        System.out.print("Subject Name: ");
        subjectName = i.readword();
        System.out.print("Num_students: ");
        num_students = i.readint();
        System.out.print("Level: ");
        level = i.readint();
        System.out.print("Theory_hours: ");
        hoursClasses[0] = i.readint();
        System.out.print("Laboratory_hours: ");
        hoursClasses[1] = i.readint();
        System.out.print("Problems_hours: ");
        hoursClasses[2] = i.readint();
        System.out.print("Number of groups: ");
        numberOfGroups[0] = i.readint();
        System.out.print("Number of Subgroups: ");
        numberOfGroups[1] = i.readint();
        System.out.print("Shift 0.Morning, 1.Afternoon, 2.Both ");
        shiftSubj = UtilsDomain.typeShift.values()[i.readint()];

        Subject subject = new Subject(subjectName, num_students, level, hoursClasses, numberOfGroups, shiftSubj);
        tc = new TheoryClass(identifier, subject, group, quantityStudents, shift, subGroup);
        i.write("-", 20);
        i.writeln("Theory Class successfully created");
        }

    public static void testConstructorFromStr () throws Exception {
        Vector<String> myVector = new Vector<>();

        System.out.print("ID: ");
        myVector.add(i.readword());
        System.out.print("Group: ");
        myVector.add(i.readword());
        System.out.print("subGroup: ");
        myVector.add(i.readword());
        System.out.print("Type of group 0.Theory, 1.Lab, 2.Problems: ");
        myVector.add(i.readword());
        System.out.print("Type of group 0.Morning, 1.Afternoon: ");
        myVector.add(i.readword());
        System.out.print("Quantity students: ");
        myVector.add(i.readword());

        System.out.print("Subject Name: ");
        myVector.add(i.readword());
        System.out.print("Num_students: ");
        myVector.add(i.readword());
        System.out.print("Level: ");
        myVector.add(i.readword());
        System.out.print("Theory_hours: ");
        myVector.add(i.readword());
        System.out.print("Laboratory_hours: ");
        myVector.add(i.readword());
        System.out.print("Problems_hours: ");
        myVector.add(i.readword());
        System.out.print("Number of groups: ");
        myVector.add(i.readword());
        System.out.print("Number of Subgroups: ");
        myVector.add(i.readword());
        System.out.print("Shift 0.Morning, 1.Afternoon, 2.Both ");
        myVector.add(i.readword());

        tc = new TheoryClass(myVector);
        i.write("-", 20);
        i.writeln("Theory Class successfully created");
    }

    public static void testGetGroup() throws Exception {i.writeln( tc.getGroup() );}
    public static void testGetIdentifier() throws Exception {i.writeln( tc.getIdentifier() );}
    public static void testGetSubject() throws Exception {
        Subject subject = tc.getSubject();
        i.writeln( subject.getName() );
        i.writeln( subject.getLevel() );
        i.writeln( subject.getNumberStudents() );
        i.writeln( subject.getTypeShift().toString() );

    }
    public static void testGetType() throws Exception {i.writeln( tc.getType().toString() );}
    public static void testGetShift() throws Exception {i.writeln( tc.getShift().toString() );}
    public static void testGetQuantityStudents() throws Exception {i.writeln( tc.getQuantityStudents() );}
    public static void testGetSubGroup() throws Exception {i.writeln(tc.getSubGroup()); }


    public static void testSetGroup() throws Exception{ tc.setGroup( i.readint()); }
    public static void testSetIdentifier() throws Exception{ tc.setIdentifier( i.readln() ); }
    public static void testSetSubject() throws Exception{ tc.setSubject(c.i.readln()); }
    public static void testSetShift() throws Exception{ tc.setShift(c.i.readln()); }
    public static void testSetQuantityStudents() throws Exception{ tc.setQuantityStudentsc.(i.readln()); }
    public static void testSetSubGroup() throws Exception{ tc.setSubGroup(c.i.readln()); }


    public static void testToStr() throws Exception {
        Vector<String> myVector = tc.toStr();

        for (int ii = 0; ii < myVector.size(); ii++) {
            i.writeln( myVector.get(ii) );
        }
    }

    public static void testFromStr() throws Exception{
        Vector<String> myVector = new Vector<>();
        System.out.print("ID: ");
        myVector.add(i.readword());
        System.out.print("Group: ");
        myVector.add(i.readword());
        System.out.print("subGroup: ");
        myVector.add(i.readword());
        System.out.print("Type of group 0.Theory, 1.Lab, 2.Problems: ");
        myVector.add(i.readword());
        System.out.print("Type of group 0.Morning, 1.Afternoon: ");
        myVector.add(i.readword());
        System.out.print("Quantity students: ");
        myVector.add(i.readword());

        System.out.print("Subject Name: ");
        myVector.add(i.readword());
        System.out.print("Num_students: ");
        myVector.add(i.readword());
        System.out.print("Level: ");
        myVector.add(i.readword());
        System.out.print("Theory_hours: ");
        myVector.add(i.readword());
        System.out.print("Laboratory_hours: ");
        myVector.add(i.readword());
        System.out.print("Problems_hours: ");
        myVector.add(i.readword());
        System.out.print("Number of groups: ");
        myVector.add(i.readword());
        System.out.print("Number of Subgroups: ");
        myVector.add(i.readword());
        System.out.print("Shift 0.Morning, 1.Afternoon, 2.Both ");
        myVector.add(i.readword());

        tc = ClassClass.fromStr(myVector);
    }

    public static void main (String [] args) throws Exception {

        int option = 0;

        while( option != 11) {

            System.out.print("------------------------------------------ \n");
            System.out.print("------------------MENU-------------------- \n");
            System.out.print("------------------------------------------ \n");
            System.out.print("Test Constructor 1: \n");
            System.out.print("Test Constructor from String Vector 2: \n");
            System.out.print("Test GetGroup 3: \n");
            System.out.print("Test GetIdentifier 4: \n");
            System.out.print("Test GetSubject 5: \n");
            System.out.print("Test GetType 6: \n");
            System.out.print("Test GetShift 7: \n");
            System.out.print("Test GetQuantityStudents 8: \n");
            System.out.print("Test GetSubGroup 9: \n");
            System.out.print("Test ToStr 10:  \n");
            System.out.print("Exit 11:  \n");

            option = i.readint();


            switch( option ) {
                case 1:
                    testConstructor();
                    break;
                case 2:
                    testConstructorFromStr();
                    break;
                case 3:
                    testGetGroup();
                    break;
                case 4:
                    testGetIdentifier();
                    break;
                case 5:
                    testGetSubject();
                    break;
                case 6:
                    testGetType();
                    break;
                case 7:
                    testGetShift();
                    break;
                case 8:
                    testGetQuantityStudents();
                    break;
                case 9:
                    testGetSubGroup();
                    break;
                case 10:
                    testToStr();
                    break;
            }
            System.in.read();
        }
    }
}
