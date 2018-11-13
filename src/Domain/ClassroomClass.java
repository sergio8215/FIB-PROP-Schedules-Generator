package src.Domain;

import javax.management.loading.ClassLoaderRepository;
import java.util.Vector;

public abstract class ClassroomClass {

    /**
     * ClassroomClass represents a classroom of type LABORATORY or THEORY
     * @author mireia
     */

    public enum ClassroomType {
        THEORY,
        LABORATORY
    }

    //ATTRIBUTES
    private String name;
    private int capacity;
    private ClassroomType type; //crear ints pels tipus (LABORATORI, TEORIA)
    private boolean multimedia;

    //CONSTRUCTOR

    /**
     * Empty ClassroomClass constructor
     */
    public ClassroomClass() {

    }

    /**
     * ClassroomClass constructor
     * @param n name of the classroom
     * @param cap capacity of the classroom
     * @param t type of the classroom (Laboratory or Theory)
     * @param m if the classroom has a multimedia system
     */
    public ClassroomClass(String n, int cap, ClassroomType t, boolean m) {
        name = n;
        capacity = cap;
        type = t;
        multimedia = m;
    }

    /**
     * ClassroomClass constructor from String
     * @param parse Vector of String Objects which encodes the attributes of this ClassroomClass instance
     */
    public ClassroomClass(Vector<String> parse) {
        name = parse.get(0);
        capacity = Integer.parseInt(parse.get(1));
        typeFromString(parse.get(2));
        multimediaFromString(parse.get(3));
    }

    //GETTERS & SETTERS

    /**
     * Getter of the name attribute
     * @return returns the name of the classroom
     */
    public String getName() {
        return name;
    }

    /**
     * Setter of the name attribute
     * @param name the name of the classroom
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter of the capacity attribute
     * @return returns the capacity of the classroom
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Setter of the capacity attribute
     * @param capacity the maximum number of students per class
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Getter of the type attribute
     * @return returns the type of the classroom
     */
    public ClassroomType getType() {
        return type;
    }

    /**
     * Setter of the type attribute
     * @param type the type of the classroom
     */
    public void setType(ClassroomType type) {
        this.type = type;
    }

    /**
     * Getter of the multimedia attribute
     * @return returns true if the class has multimedia system, false otherwise
     */
    public boolean isMultimedia() {
        return multimedia;
    }

    /**
     * Setter of the multimedia attribute
     * @param multimedia indicates if the class has multimedia system
     */
    public void setMultimedia(boolean multimedia) {
        this.multimedia = multimedia;
    }

    //PRIVATE METHODS

    /**
     * Converts the type of this ClassroomClass instance into a legible  String
     * @return returns an String with the type of the ClassroomClass instance
     */
    private String typeToString() {
        if(type == ClassroomType.LABORATORY) return "Laboratory";
        else return "Theory";
    }

    /**
     * Converts the multimedia attribute into a legible String
     * @return returns an String with the attribute multimedia of this ClassroomClass instance
     */
    private String multimediaToString(){
        if(multimedia) return "true";
        else return "false";
    }

    /**
     * Converts an String into a boolean that shows if the Classroom instance has multimedia system
     * @param m String that encodes the multimedia attribute
     */
    private void multimediaFromString(String m){
        if(m.equals("true")) multimedia = true;
        else multimedia = false;
    }

    /**
     * Converts an String into a ClassroomType
     * @param t String that encodes the type attribute
     */
    private void typeFromString(String t){
        if(t.equals("Laboratory")) type = ClassroomType.LABORATORY;
        else type = ClassroomType.THEORY;
    }

    //PUBLIC METHODS

    /**
     * Transforms the Classroom Object into a Vector of Strings
     * @return returns a Vector of Strings with the attributes encoded
     */
    public Vector<String> toStr() {

        Vector<String> vec = new Vector<String> (5);
        vec.add(name);
        vec.add(String.valueOf(capacity));
        vec.add(typeToString());
        vec.add(multimediaToString());
        vec.add("0");
        return vec;
    }
    

}
