package ru.appline.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Boundaries {
    private int leftBoundary;
    private int rightBoundary;

    public Boundaries() {
        super();
    }

    public Boundaries(String range) {
        Pattern pattern = Pattern.compile("(^[0-9]+)-([0-9]+)");
        Matcher matcher = pattern.matcher(range);
        matcher.find();
        this.leftBoundary = Integer.parseInt(matcher.group(1));
        this.rightBoundary = Integer.parseInt(matcher.group(2));
    }

    public Boundaries(int leftBoundary, int rightBoundary) {
        this.leftBoundary = leftBoundary;
        this.rightBoundary = rightBoundary;
    }

    public int getLeftBoundary() {
        return leftBoundary;
    }

    public void setLeftBoundary(int leftBoundary) {
        this.leftBoundary = leftBoundary;
    }

    public int getRightBoundary() {
        return rightBoundary;
    }

    public void setRightBoundary(int rightBoundary) {
        this.rightBoundary = rightBoundary;
    }
}
