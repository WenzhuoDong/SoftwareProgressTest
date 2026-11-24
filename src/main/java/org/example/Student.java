package org.example;

import java.util.ArrayList;

// Inheritance + Abstraction: common data for every Student.
// Abstract because a student is always either UG or MSc.
public abstract class Student {
    // Encapsulation: fields are private and only read through getters.
    private final String name;
    private final String cid;
    // Polymorphism: one list holds every kind of Assessment.
    private final ArrayList<Assessment> assessments = new ArrayList<>();

    public Student(String name, String cid) {
        this.name = name;
        this.cid = cid;
    }

    public String getName() { return name; }
    public String getCid() { return cid; }
    public ArrayList<Assessment> getAssessments() { return assessments; }

    public void addAssessment(Assessment a) {
        assessments.add(a);
    }

    // Abstraction: UG and MSc each provide their own version.
    public abstract String getType();
    public abstract double getWeighting(Assessment a);

    public double getModuleMark() {
        double total = 0;
        double weightSum = 0;
        for (Assessment a : assessments) {
            total = total + getWeighting(a) * a.getFinalPercentage();
            weightSum = weightSum + getWeighting(a);
        }
        if (weightSum == 0) return 0;
        return total / weightSum;
    }

    public double getAverage(boolean aiPermitted) {
        double sum = 0;
        int count = 0;
        for (Assessment a : assessments) {
            if (a.isAIPermitted() == aiPermitted) {
                sum = sum + a.getFinalPercentage();
                count++;
            }
        }
        if (count == 0) return 0;
        return sum / count;
    }

    public boolean hasAIDiscrepancy() {
        return getAverage(true) - getAverage(false) >= 20;
    }

    public String getMarkText(String title) {
        for (Assessment a : assessments) {
            if (a.getTitle().equals(title)) {
                return String.format("%.2f", a.getFinalPercentage());
            }
        }
        return "N/A";
    }
}