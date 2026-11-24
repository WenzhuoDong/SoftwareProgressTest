package org.example;

import assessments.AssessmentFeed;

// Inheritance: ProgrammingTest is an Assessment. New kinds can be added the same way.
public class Programmingtest extends Assessment {
    private final double programMark;
    private final boolean explainedSuccessfully;

    public Programmingtest(double programMark, boolean explainedSuccessfully) {
        super(AssessmentFeed.PROGRAMMING_TEST, 100);
        this.programMark = programMark;
        this.explainedSuccessfully = explainedSuccessfully;
    }

    // Polymorphism: this version runs for ProgrammingTest objects
    @Override
    public double getFinalPercentage() {
        if (explainedSuccessfully) {
            return programMark;
        } else {
            return Math.min(programMark, 40);   // 没讲解成功，封顶 40
        }
    }

    @Override
    public boolean isAIPermitted() { return false; }

    @Override
    public String getDetails() {
        return AssessmentFeed.PROGRAM_MARK + ": " + String.format("%.2f", programMark)
                + ", " + AssessmentFeed.EXPLAINED_SUCCESSFULLY + ": " + (explainedSuccessfully ? "Yes" : "No");
    }
}