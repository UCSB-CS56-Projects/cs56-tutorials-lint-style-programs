cs56-tutorials-lint-style-programs
==================================

A tutorial about how to use JLint, Lint4j, and similar such utilities.

"Lint-like-utilities" are programs that take in Java Source code as input, and produce, as output, a report of
"possible" problems in the code.    These are problems that would typically NOT be caught by a
compiler, because they are not syntax errors, but instead represent things that are "suspicious", i.e.
they might be signs of either
* logic errors
* bad style
* code that is left over from previous development but is no longer useful

The "lint" utility was originally developed on Unix for C programming.   Lint-like-utilities now exist for many languages
including Java.  This repo contains this README with summaries about a variety of such utilities,
and subdirectories containing sample code.


# Findbugs

http://findbugs.sourceforge.net/

Findbugs is a great tool to find problems in code. It has a vast array of problems it can detect. All which can be found here 
http://findbugs.sourceforge.net/bugDescriptions.html
* Speed - Slower than Lint4j
* Installing to your build requires multiple jars.
* Output of Problems found - only a file
* Number of files it can check - 1 file

# Lint4J

http://www.jutils.com/

Lint4j is a great tool to add to your current project. It can detect a good amount of problems in your code. Here is the link
http://www.jutils.com/features.html
It is not as big as the Findbugs, but it will do.
* Speed - Faster than Findbugs
* Installing to your build only requires one jar.
* Output of Problems found - System.out and optional file
* Number of files it can check - As much as you want

# Comparison

Lint4j should be the tool that you put into your build.xml It is easier to install since it only needs one jar file and it is faster than Findbugs. Also Lint4j can detect problems in multiple files where Findbugs cannot. It is the case that there is more than one file that you are using espcially in object oriented programming. This is why Lint4j is really useful. Also Lint4j can detect problems in files even before they are compiled. This could give out an error message that is easier to understand than the compiler error message. Overall Lint4j is more user-friendly than Findbugs.