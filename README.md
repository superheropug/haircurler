# haircurler
Haircurler is an open-source application intended to be used for API testing. <br>
Don't worry, we don't have accounts. I don't even have servers! <br>
For those of you who are sick of needing to sign in to your API tool, but also uncomfortable with using cURL through CMD, Haircurler is for you!<br>
Haircurler just runs cURL in the background, with a GUI. <br>
I also plan to save requests and add a number of other features as well!<br>
You can run the exe to install, or, if you wish to call me a smelly nerd, you may compile it yourself.<br>
How to compile and run:
  - Download and build the application, you will need a JRE and JDK, 21 or newer.
  - Run mvn javafx:jlink to create the JVM instance you need.
  - Run the build.bat, it will create an installer. Run that, and trust me.
  - Install cURL
  - Run, you should see your cURL version in the top right.

<br><br><br>
A note: This requires cURL to work. If cURL does not work on your machine, such as AVG or other anivirus blocking CURL requests, the program will not work. Please verify you have a valid cURL version installed, and that cURL requests work from your machine. 
