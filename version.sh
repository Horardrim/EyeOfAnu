#!/bin/sh

grep "<version" pom.xml | sed -n '1p' | awk -F '>' '{print $2}' | awk -F '<' '{print $1}'

