find ./ -type f -regex ".*.xml" | xargs perl -pi -e"s/spafka.RELEASE/${revision}/g"
