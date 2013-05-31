# Lint4j

TODO: Put a build.xml in this directory along with some Java Source code that compiles and runs, BUT has "problems" in it
that Lint4j can detect.

For example

* if Lint4j can detect unused variables, put in some unused variables.
* if lint4j can detect BLAH BLAH BLAH, put in some BLAH BLAH BLAH...
* Put in as many things as you can find, up to the point where it feels like its no longer useful.

You could have multiple classes with names like UnusedVariable.java

or you could have just one class with a name like Lint4JDemo.java, and have methods such as:

```
  public void unusedVariable(int x) {
    // insert some code here
  }
```

Also, add to this README.md some advice on how, if you already have a Java project in the style of this course (i.e. with a src directory
and packages, and a lib directory with the jar for junit.jar, and a build.xml), how to add Lint4J into
your project's repo.  That probably means:

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
Add this any existing build.xml that is set up in a package structure or it won't work. Make sure the variable (pkgName) is defined to your specific package name. This target is set up to copy the detected problems to tmp/lint.out so your build.xml should reflect that. For ex. clean target deletes tmp/ directory perhaps.
