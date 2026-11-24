package org.example;

import assessments.AssessmentFeed;
import javax.swing.*;
import java.awt.*;

// Abstraction: the display only asks the cohort for data, it stores none
public class GridDisplay extends JPanel {
    private static final String[] HEADERS = {"Name", "CID", "Type",
            AssessmentFeed.PROGRAMMING_TEST, AssessmentFeed.AI_PROJECT,
            AssessmentFeed.DESIGN_VIVA, "Module %"};

    public GridDisplay(Cohort cohort) {

        setLayout(new GridLayout(cohort.getCount() + 1, HEADERS.length));

        for (String h : HEADERS) {
            addCell("<html><b>" + h + "</b></html>", Color.LIGHT_GRAY);
        }

        for (int i = 0; i < cohort.getCount(); i++) {
            Student s = cohort.getStudent(i);

            Color colour;
            if (s.hasAIDiscrepancy()) {
                colour = Color.RED;
            } else {
                colour = Color.WHITE;
            }

            addCell(s.getName(), colour);
            addCell(s.getCid(), colour);
            addCell(s.getType(), colour);
            addCell(s.getMarkText(AssessmentFeed.PROGRAMMING_TEST), colour);
            addCell(s.getMarkText(AssessmentFeed.AI_PROJECT), colour);
            addCell(s.getMarkText(AssessmentFeed.DESIGN_VIVA), colour);
            addCell(String.format("%.2f", s.getModuleMark()), colour);
        }
    }

    private void addCell(String text, Color colour) {
        JPanel cell = new JPanel(new BorderLayout());
        cell.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        cell.setBackground(colour);
        cell.add(new JLabel(text), BorderLayout.CENTER);
        add(cell);
    }
}



