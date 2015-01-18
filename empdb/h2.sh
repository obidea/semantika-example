#!/bin/sh
dir=$(dirname "$0")
java -Dh2.implicitRelativePath=true -cp "$dir/h2-1.4.185.jar:$H2DRIVERS:$CLASSPATH" org.h2.tools.Console "$@"
