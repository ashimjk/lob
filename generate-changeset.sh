./liquibase/liquibase \
    --driver=org.postgresql.Driver \
    --classpath=/home/ashimjk/.m2/repository/org/postgresql/postgresql/42.2.18/postgresql-42.2.18.jar \
    --url="jdbc:postgresql://localhost:5432/lobdb" \
    --changeLogFile=src/main/resources/db/changelog/sample.xml \
    --username=postgres \
    --password=postgres \
    generateChangeLog