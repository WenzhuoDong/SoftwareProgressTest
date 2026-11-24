package org.example;

// Inheritance: MScStudent is a Student.
public class MScStudent extends Student {
    public MScStudent(String name, String cid) {
        super(name, cid);
    }

    @Override
    public String getType() { return "MSc"; }

    // Polymorphism: MSc weightings.
    @Override
    public double getWeighting(Assessment a) {
        if (a instanceof Programmingtest) return 0.25;
        if (a instanceof AIProject) return 0.45;
        if (a instanceof DesignViva) return 0.30;
        return 0;
    }
}