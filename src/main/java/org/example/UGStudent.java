package org.example;

// Inheritance: UGStudent is a Student
public class UGStudent extends Student {
    public UGStudent(String name, String cid) {
        super(name, cid);
    }

    @Override
    public String getType() { return "UG"; }

    // Polymorphism: UG weightings
    @Override
    public double getWeighting(Assessment a) {
        if (a instanceof Programmingtest) return 0.30;
        if (a instanceof AIProject) return 0.70;
        return 0;
    }
}