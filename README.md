5.1.2-release

find ./ -type f -regex "*.xml" | xargs perl -pi -e"s/<scope>compile</scope>//g"