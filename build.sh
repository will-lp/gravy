#!/bin/sh

#########
# PABS: Pretty Analog Build Script
#########

version="0.1"
file="gravy-${version}.jar"

echo " * Cleaning older version..."
rm "dist/$file"
rm classes/ -R
rm "~/.groovy/lib/$file"

echo " * Compiling..."
groovyc `find src -name *.groovy` -d "./classes/"
cp src/META-INF -R classes/

echo " * Jar-ing..."
cd classes
jar c . > ../dist/$file
cd ..

#echo " * Copying to '.groovy/lib'"
#cp dist/$file > ~/.groovy/lib/

echo " * Launching tests..."
#groovy -cp dist/$file src/test/org/latitude/LatitudeTest.groovy
groovy -cp dist/$file src/test/org/gravy/SmallGravyTest.groovy
#groovy -cp dist/$file src/test/org/gravy/SqlTest.groovy

echo " * Copying to .groovy/lib..."
cp "dist/$file" ~/.groovy/lib
