package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Cohort cohort = new Cohort();

        // User story 2: console report
        cohort.printReport();

        // User stories 1 & 3: Swing grid with red rows
        GridDisplay display = new GridDisplay(cohort);
        JFrame frame = new JFrame("Assessment Results");
        frame.add(display);
        frame.setSize(1100, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}