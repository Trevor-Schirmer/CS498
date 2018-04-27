# CS498
CS498 Final Project



Project 13:Make Jenkins produce finer grained messages, not just "build passed" or "build failed". Currently, when there is a build failure, the only output from Jenkins is a message that says, "Build Passed" or "Build Failed". The goal of this project is to make Jenkins give more details whenever there is a build failure. For example, if the build failed because tests fail, Jenkins should say so (it should also say which tests fail). Also, if the build failed because of missing dependencies or failures due to hardware or software (mis)configuration, Jenkins should output this along with the standard "build failed" message.


To use this plugin you have two options.

Option 1.
Download the helloDev.hpi file.
> Start the Jenkins instance you wish to use.
> Go to manage jenkins > manage plugins > advanced
> Select upload plugin and browse to where you stored helloDev.hpi and select it.
> Your jenkins instance will then install the plugin, but it may require a restart to take effect. 

Option 2.
> To create a new jenkins instance with the plugin installed do the following.
> Clone the CS498 repository
> Change your active directory to the helloDev directory in CS498
> Use the following commands "mvn complile", "mvn hpi:hpi".
> The helloDev.hpi file will be in the folder helloDev/target.
> You may then either use Option 1 using this hpi file or continue.
> After these commands finish their will be a new instance of jenkins running on your machine with the plugin installed.
> In a browser of your choice go to http://(your ip address):8080/jenkins to access your jenkins instance.
