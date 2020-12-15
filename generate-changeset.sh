## postgresql connection
#./liquibase/liquibase \
#  --driver=org.postgresql.Driver \
#  --classpath=/home/ashimjk/.m2/repository/org/postgresql/postgresql/42.2.18/postgresql-42.2.18.jar \
#  --url="jdbc:postgresql://localhost:5432/lobdb" \
#  --changeLogFile=src/main/resources/db/changelog/sample.xml \
#  --username=postgres \
#  --password=postgres \
#  generateChangeLog

## h2 connection
#./liquibase/liquibase \
#  --driver=org.h2.Driver \
#  --classpath=/home/ashimjk/.m2/repository/com/h2database/h2/1.4.200/h2-1.4.200.jar \
#  --url="jdbc:h2:file:./lobdb" \
#  --changeLogFile=src/main/resources/db/changelog/sample.xml \
#  --username=sa \
#  --password=password \
#  generateChangeLog

## oracle connection
./liquibase/liquibase \
  --driver=oracle.jdbc.OracleDriver \
  --classpath=/home/ashimjk/.m2/repository/com/oracle/database/jdbc/ojdbc8/19.8.0.0/ojdbc8-19.8.0.0.jar \
  --url="jdbc:oracle:thin:@localhost:1521/EE.oracle.docker" \
  --changeLogFile=src/main/resources/db/changelog/sample.xml \
  --username=SIB_DB \
  --password=SIB_DB \
  generateChangeLog
