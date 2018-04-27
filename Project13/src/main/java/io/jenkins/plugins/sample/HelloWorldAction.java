/*
Modified by Adam Brassfield, Kipling Gillespie, Chase Carney, and Trevor Schirmer
Date: April 27, 2018
Course: CS 498
Project: Final Project
Purpose: Make Jenkins produce finer grained messages, not just "build passed" or "build failed".
Currently, when there is a build failure, the only output from Jenkins is a message that says,
"Build Passed" or "Build Failed". The goal of this project is to make Jenkins to give more details
whenever there is a build failure. For example, if the build failed because tests fail, Jenkins
should say so (it should also say which tests fail). Also, if the build failed because of missing
dependencies or failures due to hardware or software (mis)configuration, Jenkins should output
this along with the standard "build failed" message.
 */

package io.jenkins.plugins.sample;

import hudson.model.Run;
import hudson.model.Result;
import java.util.*;
import jenkins.model.RunAction2;

public class HelloWorldAction implements RunAction2 {
    private transient Run run;
    private List<String> runLog; // Keeps track of console output
    private String buildColor; // Keeps track of build status color
    private String buildResult; // Keeps track of build status
    private String[] errors; // Array of errors from console
    private String[] warnings; // Array of warnings from console

    public HelloWorldAction(List<String> runLog, Result buildResult) {
        // Get the run log
        this.runLog = runLog;
        // Get the build status
        this.buildResult = buildResult.toString();
        // Get the color and format it to a hex value
        int red = buildResult.color.getBaseColor().getRed();
        int green = buildResult.color.getBaseColor().getGreen();
        int blue = buildResult.color.getBaseColor().getBlue();
        this.buildColor = String.format("%x%x%x", red, green, blue);
        // Parse the data
        parseData();
    }

    private void parseData() {
        // Array lists keep track of errors and warnings
        List<String> errorsList = new ArrayList<>();
        List<String> warningsList = new ArrayList<>();
        // Iterate through each entry in the log
        for (String entry : runLog) {
            // Find the errors and warnings and add them to the lists
            if (entry.contains("[ERROR]")) {
                errorsList.add(entry.substring(7));
            }
            if (entry.contains("[WARNING]")) {
                warningsList.add(entry.substring(9));
            }
        }
        // Put the data from the lists into arrays so the jelly file can access them
        errors = new String[errorsList.size()];
        errors = errorsList.toArray(errors);
        warnings = new String[warningsList.size()];
        warnings = warningsList.toArray(warnings);
    }

    public String getBuildResult() {
        return buildResult;
    }

    public String getBuildColor() {
        return buildColor;
    }

    public List<String> getRunLog() {
        return runLog;
    }

    public String[] getErrors() {
        return errors;
    }

    public String[] getWarnings() {
        return warnings;
    }

    @Override
    public String getIconFileName() {
        return "document.png";
    }

    @Override
    public String getDisplayName() {
        return "Project13";
    }

    @Override
    public String getUrlName() {
        return "project13";
    }

    @Override
    public void onAttached(Run<?, ?> run) {
        this.run = run;
    }

    @Override
    public void onLoad(Run<?, ?> run) {
        this.run = run;
    }

    public Run getRun() {
        return run;
    }


}