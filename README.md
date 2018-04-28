# CS498
CS498 Final Project
Group 10 - Adam Brassfield, Kipling Gillespie, Chase Carney, and Trevor Schirmer

Project 13: Make Jenkins produce finer grained messages, not just "build passed" or "build failed". Currently, when there is a build failure, the only output from Jenkins is a message that says, "Build Passed" or "Build Failed". The goal of this project is to make Jenkins give more details whenever there is a build failure. For example, if the build failed because tests fail, Jenkins should say so (it should also say which tests fail). Also, if the build failed because of missing dependencies or failures due to hardware or software (mis)configuration, Jenkins should output this along with the standard "build failed" message.

Requirements: Maven 3.5.3

Files of interest:
> Project13/src/main/java/io/jenkins/plugins/sample/HelloWorldBuilder.java <br>
> This is modified to call our Action class with parameters used to produce our data <br>

> Project13/src/main/java/io/jenkins/plugins/sample/HelloWorldAction.java <br>
> This contains the bulk of the code we wrote which gets the build status, the build color, the warnings, and errors to display to the user <br>

> Project13/src/main/resources/io/jenkins/plugins/sample/HelloWorldAction/index.jelly <br>
> This is the jelly file we created for the webpage that displays the results to the user.

To get the plugin working on your machine:
> Download this repository to your machine and navigate to the Project 13 subdirectory. Here, enter to the command "mvn hpi:run" this will setup an instance of
Jenkins which will have the plugin loaded into it. To access Jenkins, go to "https://(your ip address):8080/jenkins/". This instance of Jenkins also comes with support for Maven projects as well as 3 Maven projects created for the purpose of testing the plugin's functionality.

To add the plugin to a project:
> Select configure and select "Project13" on the post-build step options. It will prompt you for a name, which is optional, and does not affect the output of the build. Save your configurations.

To see the output of the plugin:
> Build an instance of your project and navigate to it. Select the "Project13" option on the sidebar. Note that the "Project13" option doesn't appear until after the project has finished building and you may need to refresh the page once it has. This page will tell you the status of the build, the status of the warnings, and the status of the errors.
