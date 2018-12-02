package src.presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ShowSchedule extends JFrame {

    private CtrlPresenter ctrlPresenter;


    private JCheckBox EEE;
    private JCheckBox IDI;
    private JCheckBox IES;
    private JCheckBox XC;
    private JCheckBox PAR;
    private JCheckBox PROP;
    private JComboBox quarter;
    private JTable schedule;
    private JPanel rootPanel;

    public ShowSchedule(CtrlPresenter ctrlPresenter) {
        this.ctrlPresenter = ctrlPresenter;



        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(rootPanel);
        setTitle("Schedule");
        setMinimumSize(new Dimension(800, 600));


        // Get schedule options
        ctrlPresenter.getClass();

        JTable table = new JTable(new DefaultTableModel(new Object[]{"Column1", "Column2"}));
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{"Column 1", "Column 2", "Column 3"});
    }

}



