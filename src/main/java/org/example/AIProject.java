package org.example;

import assessments.AssessmentFeed;

// Inheritance: AIProject is an Assessment.
public class AIProject extends Assessment {
    private final double functionalityMark;
    private final double verificationMark;

    public AIProject(double functionalityMark, double verificationMark) {
        super(AssessmentFeed.AI_PROJECT, 100);
        this.functionalityMark = functionalityMark;
        this.verificationMark = verificationMark;
    }

    // Polymorphism: this version runs for AIProject objects.
    @Override
    public double getFinalPercentage() {
        return 0.4 * functionalityMark + 0.6 * verificationMark;
    }

    @Override
    public boolean isAIPermitted() { return true; }

    @Override
    public String getDetails() {
        return AssessmentFeed.FUNCTIONALITY_MARK + ": " + String.format("%.2f", functionalityMark)
                + ", " + AssessmentFeed.VERIFICATION_MARK + ": " + String.format("%.2f", verificationMark);
    }
}
