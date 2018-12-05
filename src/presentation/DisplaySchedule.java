package src.presentation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class DisplaySchedule extends JFrame{

    private CtrlPresenter ctrlPresenter;

    private JPanel rootPanel;
    private JPanel headerPanel;
    private JTable panelTable;
    private JPanel panelCheckbox;
    private JPanel panelButton;


    public DisplaySchedule(CtrlPresenter ctrlPresenter, HashMap<String, ArrayList<Vector<Vector<String>>>> schedule) {
        this.ctrlPresenter = ctrlPresenter;

        int hoursPerDay = 12;
        int startHour = 8;
        int daysOfTheWeek = 5;
        String[] week = { "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday" };

        add(rootPanel);
        rootPanel.add(panelTable,0);

        setSize(1000,1000);
        pack();

        setTitle("Schedule");
        setSize(800,600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // Just for the header we create another panel
        headerPanel = new JPanel();

        String[] header = new String[daysOfTheWeek+1];
        header[0] = "Hour";

        // Initialize days of the week
        for(int i = 0; i < daysOfTheWeek ; i++ ){
            header[i+1] = week[i];
        }

        int j;
        int i=0;
        Object[][] data = new Object[100][daysOfTheWeek+1];

        for (ArrayList<Vector<Vector< String>>> mus : schedule.values()){
            for ( Vector<Vector< String>> m : mus){

                data[i][0] = m.get(2).get(0);

                String dia = m.get(2).get(1).toUpperCase();
                int temp = Day.valueOf(m.get(2).get(1).toUpperCase()).ordinal();

                data[i][Day.valueOf(m.get(2).get(1).toUpperCase()).ordinal() + 1] = m.get(0).get(6) + " " + m.get(1).get(0) + " " + m.get(0).get(2);

                i++;
            }
        }





        panelTable = new JTable(data, header);
        headerPanel.add(new JScrollPane(panelTable));
        getContentPane().add(headerPanel);
    }

    public enum Day {
        MONDAY,     // ordinal value: 0
        TUESDAY,    // ordinal value: 1
        WEDNESDAY,  // ordinal value: 2
        THURSDAY,   // ordinal value: 3
        FRIDAY,     // ordinal value: 4
        SATURDAY,   // ordinal value: 5
        SUNDAY      // ordinal value: 6
    }
}