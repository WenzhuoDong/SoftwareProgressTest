package org.example;

// Inheritance + Abstraction: common data and behaviour for every Assessment.
// Abstract because there is no general Assessment, only specific kinds.
public abstract class Assessment {
    // Encapsulation: fields are private and only read through getters
    private final String title;
    private final double maxMark;

    public Assessment(String title, double maxMark) {
        this.title = title;
        this.maxMark = maxMark;
    }

    public String getTitle() { return title; }
    public double getMaxMark() { return maxMark; }

    // Abstraction: each subclass provides its own version
    public abstract double getFinalPercentage();
    public abstract boolean isAIPermitted();
    public abstract String getDetails();
}