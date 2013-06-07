# Findbugs

This project has one source file name Demo.java with a bunch of methods that are named according to a problem that (Findbugs) can find.

For Example:
```
  public void assignmentNoEffect() {
	int a = 5;
	a = a;
  }
```
In this method this assignment has no effect.
```
	a = a;
```
Findbugs finds this problem and reports it to you with this dialog.
```
M D DLS: Dead store to a in edu.ucsb.cs56.projects.tutorials.lint_style_pro
grams.Demo.assignmentNoEffect()  At Demo.java:[line 7]
```
It tells you the line that this problem occurs. It also specifies which variable this occured with. In this case it happen with a variable named "a".

Demo.java has mulitple problems that findbugs can detect. You can view them all by viewing the text file tmp/findbugs.text Then you look at Demo.java and connect the problems to the line of code findbugs specifies. Also, Demo.java has comments where problem occurs.


How to install findbugs to your build.xml

* download a jar and copy it to your lib directory
The download can be found at http://sourceforge.net/projects/findbugs/files/findbugs/2.0.2/
Dowload the zip file and extract it. The zipe file will be named findbugs-2.0.2-source.zip Then create a directory in your project build named findbugs. Copy the lib directory and all of its content of the extrated zip to the findbugs/ directory you created.
* add some code to the build.xml
```
<taskdef name="findbugs" classname="edu.umd.cs.findbugs.anttask.FindBugsTask">
    <classpath>
      <pathelement location="findbugs/lib/findbugs-ant.jar" />
    </classpath>
  </taskdef>
 
  <target name="findbugs" depends="compile" description="find bugs in code">
    <mkdir dir = "tmp" />
    <findbugs home="findbugs"
              output="text"
              outputFile="tmp/findbugs.text" >
      <auxClasspath path="lib/junit-4.8.2.jar" />
      <class location="build/${buildDir}/${className}.class" />
    </findbugs>
  </target>
```
Add this to any existing build.xml that is set up in a package structure or it won't work. Make sure the variable (buildDir) is defined to your specific location to where your .class files are located. Also, make sure (className) is the name of your class. This target is set up to send the detected problems to tmp/findbugs.text so your build.xml should reflect that. For ex. clean target deletes tmp/ directory.
