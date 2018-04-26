package io.jenkins.plugins.sample;

import hudson.model.Run;
import java.util.*;
import jenkins.model.RunAction2;

public class HelloWorldAction implements RunAction2 {
   private transient Run run;
   private List<String> runLog;
   private String[] errors;
   private String[] warnings;

   public HelloWorldAction(List<String> runLog) {
       this.runLog = runLog;
       parseData();
   }

   private void parseData() {
        List<String> errorsList = new ArrayList<String>();
        List<String> warningsList = new ArrayList<String>();
        for (String entry : runLog) {
            if (entry.contains("[ERROR]")) {
                errorsList.add(entry.substring(7));
            }
            if (entry.contains("[WARNING]")) {
                warningsList.add(entry.substring(9));
            }
        }
        errors = new String[errorsList.size()];
        errors = errorsList.toArray(errors);
        warnings = new String[warningsList.size()];
        warnings = warningsList.toArray(warnings);
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
