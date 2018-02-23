# CS498
CS498 Final Project



Project 13: Make Jenkins produce finer grained messages, not just "build passed" or "build failed". Currently, when there is a build failure, the only output from Jenkins is a message that says, "Build Passed" or "Build Failed". The goal of this project is to make Jenkins to give more details whenever there is a build failure. For example, if the build failed because tests fail, Jenkins should say so (it should also say which tests fail). Also, if the build failed because of missing dependencies or failures due to hardware or software (mis)configuration, Jenkins should output this along with the standard "build failed" message.


Extend build class
