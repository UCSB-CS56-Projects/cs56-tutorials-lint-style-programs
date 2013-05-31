# Lint4j

This project has one source file name Demo.java with a bunch of methods that are named according to a problem that (lint4j) can find.

For Example:
```
  public void assignmentNoEffect() {
	int x = 5;
	x = x;
  }
```
In this method this assignment has no effect.
```
	x = x;
```
Lint4j finds this problem and reports it to you with this dialog.
```
   [lint4j] /src/edu/ucsb/cs56/projects/tutorials/lint_style_programs/Demo.java:7: (1): Statement has no effect, possible scoping problem
```
It tells you the line that this problem occurs. It also returns a numerical value according to the severity of the problem. The number ranges from 1 to 5 where 5 is the most severe.

Demo.java has mulitple problems that lint4j can detect. You can view them all by viewing the text file tmp/lint.out Then you look at Demo.java and connect the problems to the line of code lint4j specifies.


How to install lint4j to your build.xml

* download a jar and copy it to your lib directory
The download can be found at http://www.jutils.com/download.html
Dowload the zip file and extract it. Then copy the lint4j.jar file that is located in the jars/ directory to your projects lib/ directory.
* add some code to the build.xml
```
  </target> 
  <taskdef name="lint4j" classname="com.jutils.lint4j.ant.Lint4jAntTask">
    <classpath>
      <pathelement location="lib/lint4j.jar" />
    </classpath>
  </taskdef>

  <target name="lint" description="runs lint4j on source files" >
    <mkdir dir = "tmp" />
    <lint4j sourcepath="src"
	    classpath="lib/junit-4.8.2.jar"
	    packages="${pkgName}.*"
	    level="5"
	    exact="false" >
      <formatters>
	<formatter type="text" />
	<formatter type="text" toFile="tmp/lint.out"/>
      </formatters> 
    </lint4j>
  </target>
```
Add this to any existing build.xml that is set up in a package structure or it won't work. Make sure the variable (pkgName) is defined to your specific package name. This target is set up to copy the detected problems to tmp/lint.out so your build.xml should reflect that. For ex. clean target deletes tmp/ directory.
