package src.presentation;

import src.domain.controllers.CtrlDomain;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class SubmitFiles extends JDialog {
    private CtrlPresenter ctrlPresenter;

    private JButton selectClassroomsFileButton;
    private JButton selectSubjectsFileButton;
    private JLabel SelectScenarioLabel;
    private JLabel ClassroomsJSONFileLabel;
    private JLabel SubjectsJSONFileLabel;
    private JPanel rootPanel;
    private JButton nextbutton;

    private String classroomsFile;
    private String subjectsFile;

    public SubmitFiles(CtrlPresenter ctrlPresenter){

        this.ctrlPresenter = ctrlPresenter;

        add(rootPanel);
        setTitle("Submit Files");
        setSize(400,500);

        // We add a Listener to make the button do something
        selectClassroomsFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "JSON Files", "json");
                fc.setFileFilter(filter);
                int returnVal = fc.showOpenDialog(rootPanel);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " +
                            fc.getCurrentDirectory().getAbsolutePath()+
                            fc.getSelectedFile().getName());
                    classroomsFile = fc.getCurrentDirectory().getAbsolutePath()+ fc.getSelectedFile().getName();
                }

            }
        });
        selectSubjectsFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "JSON Files", "json");
                fc.setFileFilter(filter);
                int returnVal = fc.showOpenDialog(rootPanel);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " +
                            fc.getCurrentDirectory().getAbsolutePath()+
                            fc.getSelectedFile().getName());
                    subjectsFile = fc.getCurrentDirectory().getAbsolutePath()+ fc.getSelectedFile().getName();
                }
            }
        });



        nextbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (true /*classroomsFile != null && subjectsFile != null*/) {
                        ctrlPresenter.setScenario(classroomsFile, subjectsFile);
                        ctrlPresenter.scheduleGeneration();
                        setVisible(false);
                        setEnabled(false);
                    }
                } catch (Exception exc) {
                    System.out.println(exc);
                }
            }
        });
    }
}