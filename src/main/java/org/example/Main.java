package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Cohort cohort = new Cohort();

        cohort.printReport();

        GridDisplay display = new GridDisplay(cohort);

        JFrame frame = new JFrame("Assessment Results");
        frame.add(display);
        frame.setSize(1100, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}