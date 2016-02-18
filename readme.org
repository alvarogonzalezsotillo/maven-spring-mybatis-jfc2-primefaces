

* PROXY EN MAVEN

* CREACION DE PROYECTO
mvn archetype:generate -DgroupId=com.alvarogonzalez.autentiaHomework -DartifactId=primefaces -DarchetypeArtifactId=maven-archetype-webapp

* DEPENDENCIAS
http://www.javacodegeeks.com/2014/02/building-java-web-application-using-mybatis-with-spring.html

* SPRING Y JSF (PROBLEMAS DE INTEGRACIÓN)
http://www.beyondjava.net/blog/integrate-jsf-2-spring-3-nicely/


* SPRING3 Y JSF2
http://www.mkyong.com/jsf2/jsf-2-0-spring-integration-example/


* DIALOGO Y TABLA DE PRIMEFACES
http://stackoverflow.com/questions/16486500/primefaces-datatable-dialog-for-data-modification


* SCOPES DE SPRING Y JSF2
| Spring Scope   | JSF scope                          |
|----------------+------------------------------------|
| singleton      | @ApplicationScoped                 |
| global session | (missing)                          |
| session        | @SessionScoped                     |
| (missing)      | @ConversationScoped (requires CDI) |
| (missing)      | @FlowScoped (requires CDI)         |
| (missing)      | @ViewScoped                        |
| request        | @RequestScoped                     |
| prototype      | @NoneScoped                        |
