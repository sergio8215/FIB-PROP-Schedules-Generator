package src.presentation;

import src.domain.controllers.CtrlDomain;
import src.domain.utils.UtilsDomain;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;


/**
 * Presentation Controller
 * @author Joaquim Gomez
 */
public class CtrlPresenter {

    // Members

    private CtrlDomain ctrlDomain;
    private InitView initView;
    private DisplaySchedule dS;
    private NotPossibleSchedule nps;
    private SubjectsManager sm;
    private ClassroomsManager cm;

    private Vector<Vector<String>> subjectsSet = new Vector<>();
    private Vector<Vector<String>> classroomsSet = new Vector<>();


    // Methods

    public CtrlPresenter() {
        ctrlDomain = new CtrlDomain();
        initView = new InitView(this);
        initView.setVisible(true);
    }

    public void setScenario(String classroomsFile, String subjectsFile) throws Exception {
        ctrlDomain.createScenario(classroomsFile, subjectsFile);
    }

    public void loadSubjects(String subjectsFile) throws Exception {
        ctrlDomain.setSubjects(subjectsFile);
    }

    public void loadClassrooms(String classroomsFile) throws Exception {
        ctrlDomain.setClassrooms(classroomsFile);
    }

    public void selectConstraints() {
        initView.selectConstraints();
    }

    public void setConstraints(boolean[] sc){
        ctrlDomain.setConstraints(sc);
    }

    public void loadSchedule(String scheduleFile) throws Exception {
        initView.setVisibleF(false);
        initView.setEnabled(false);

        HashMap<String, ArrayList<Vector<String>>> h = ctrlDomain.loadSchedule(scheduleFile);

        UIManager.put("swing.boldMetal", Boolean.FALSE);
        new DisplaySchedule(this,h);
    }

    public void saveSchedule() throws Exception {
        // parent component of the dialog
        JFrame parentFrame = new JFrame();

        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setDialogTitle("Specify a file to save");
        fileChooser.setCurrentDirectory(new java.io.File("./data/load"));
        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            ctrlDomain.saveSchedule(fileToSave.getAbsolutePath());
            JOptionPane.showMessageDialog(parentFrame, "Schedule saved.");
        }else{
            JOptionPane.showMessageDialog(parentFrame, "Error.");
        }
    }

    public void saveSubjectSet(Vector<Vector<String>> subjectSet) throws Exception {
        // parent component of the dialog
        JFrame parentFrame = new JFrame();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("./data/import"));
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            ctrlDomain.saveSubjectSet(fileToSave.getAbsolutePath(), subjectSet);
            JOptionPane.showMessageDialog(parentFrame, "Schedule saved.");
        }else{
            JOptionPane.showMessageDialog(parentFrame, "Error.");
        }
    }

    public void saveClassroomSet(Vector<Vector<String>> classroomSet) throws Exception {
        // parent component of the dialog
        JFrame parentFrame = new JFrame();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("./data/import"));
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            ctrlDomain.saveClassroomSet(fileToSave.getAbsolutePath(), classroomSet);
            JOptionPane.showMessageDialog(parentFrame, "Schedule saved.");
        }else{
            JOptionPane.showMessageDialog(parentFrame, "Error.");
        }
    }

    public void scheduleGeneration() {
        initView.setVisibleF(false);
        initView.setEnabled(false);

        ctrlDomain.generateSchedule();

        UtilsDomain.ResultOfQuery<HashMap<String, ArrayList<Vector<String>>>> h = ctrlDomain.showSchedule();

        if (h.queryTest) {
            UIManager.put("swing.boldMetal", Boolean.FALSE);
            dS = new DisplaySchedule(this, h.result);
        } else {
            nps = new NotPossibleSchedule(this);
            nps.setEnabled(true);
            nps.setVisible(true);
        }

    }

    public void setSubjectsSet() {
        subjectsSet = ctrlDomain.getSubjectsString();
    }

    public void setClassroomsSet() {
        classroomsSet = ctrlDomain.getClassroomsString();
    }

    public void subjectsManagerEnabled() {
        sm = new SubjectsManager(this, subjectsSet);

        sm.setEnabled(true);
        sm.setVisible(true);
    }

    public void classroomsManagerEnabled() {
        cm = new ClassroomsManager(this, classroomsSet);

        cm.setEnabled(true);
        cm.setVisible(true);
    }

    public void cleanSubjectsSet() {
        subjectsSet = new Vector<>();
        ctrlDomain.cleanSubjectsSet();
    }

    public void cleanClassroomsSet() {
        classroomsSet = new Vector<>();
        ctrlDomain.cleanClassroomsSet();
    }

    public void notPossibleSchedule() {
        initView.selectConstraints();
    }

    public void backToInit() {
        initView.setEnabled(true);
        initView.setVisible(true);
        dS.setEnabled(false);
        dS.setVisible(false);
    }

    public boolean moveSession(Vector<String> from, Vector<String> to) {
        return ctrlDomain.moveSession(from, to);
    }

}