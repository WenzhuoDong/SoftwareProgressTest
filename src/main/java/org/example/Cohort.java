package org.example;

import assessments.AssessmentFeed;
import java.util.ArrayList;

public class Cohort {
    // Polymorphism: one list holds every kind of Student
    // Encapsulation: the list is private
    private final ArrayList<Student> students = new ArrayList<>();

    public Cohort() {
        for (String cid : AssessmentFeed.getCIDs()) {
            String name = AssessmentFeed.getStudentName(cid);
            String type = AssessmentFeed.getStudentType(cid);

            Student s;
            if (type.equals("MSc")) {
                s = new MScStudent(name, cid);
            } else {
                s = new UGStudent(name, cid);
            }

            double programMark = AssessmentFeed.getResult(cid, AssessmentFeed.PROGRAMMING_TEST, AssessmentFeed.PROGRAM_MARK);
            double explained = AssessmentFeed.getResult(cid, AssessmentFeed.PROGRAMMING_TEST, AssessmentFeed.EXPLAINED_SUCCESSFULLY);
            s.addAssessment(new Programmingtest(programMark, explained == 1.0));

            double functionality = AssessmentFeed.getResult(cid, AssessmentFeed.AI_PROJECT, AssessmentFeed.FUNCTIONALITY_MARK);
            double verification = AssessmentFeed.getResult(cid, AssessmentFeed.AI_PROJECT, AssessmentFeed.VERIFICATION_MARK);
            s.addAssessment(new AIProject(functionality, verification));


            if (type.equals("MSc")) {
                double design = AssessmentFeed.getResult(cid, AssessmentFeed.DESIGN_VIVA, AssessmentFeed.DESIGN_MARK);
                double explanation = AssessmentFeed.getResult(cid, AssessmentFeed.DESIGN_VIVA, AssessmentFeed.EXPLANATION_MARK);
                s.addAssessment(new DesignViva(design, explanation));
            }

            students.add(s);
        }
    }

    public int getCount() { return students.size(); }
    public Student getStudent(int index) { return students.get(index); }

    public void printReport() {
        System.out.println("===== Assessment Report =====");
        for (Student s : students) {
            System.out.println(s.getName() + " (CID " + s.getCid() + ", " + s.getType() + ")");
            // Polymorphism: each assessment runs its own method
            for (Assessment a : s.getAssessments()) {
                System.out.println("  " + a.getTitle() + ": " + String.format("%.2f", a.getFinalPercentage()) + "%");
                System.out.println("    " + a.getDetails());
            }
            System.out.println("  Module mark: " + String.format("%.2f", s.getModuleMark()) + "%");
            System.out.println("  AI discrepancy: " + (s.hasAIDiscrepancy() ? "YES" : "No"));
        }
    }
}
