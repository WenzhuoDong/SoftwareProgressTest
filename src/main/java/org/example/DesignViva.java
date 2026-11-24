package org.example;

import assessments.AssessmentFeed;

// Inheritance: DesignViva is an Assessment (MSc students only).
public class DesignViva extends Assessment {
    private final double designMark;
    private final double explanationMark;

    public DesignViva(double designMark, double explanationMark) {
        super(AssessmentFeed.DESIGN_VIVA, 100);
        this.designMark = designMark;
        this.explanationMark = explanationMark;
    }

    // Polymorphism: this version runs for DesignViva objects.
    @Override
    public double getFinalPercentage() {
        return 0.5 * designMark + 0.5 * explanationMark;
    }

    @Override
    public boolean isAIPermitted() { return false; }

    @Override
    public String getDetails() {
        return AssessmentFeed.DESIGN_MARK + ": " + String.format("%.2f", designMark)
                + ", " + AssessmentFeed.EXPLANATION_MARK + ": " + String.format("%.2f", explanationMark);
    }
}