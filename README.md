# test-gae-master

Para poder hacer Deploy en GAE, hay que solventar el siguiente error que me da el Eclipse:

Plugin execution not covered by lifecycle configuration: com.github.kongchen:swagger-maven-plugin:2.2:generate (execution: Generate SWAGGER documentation, phase: compile)ç

Para solventar ese problema lo que he hecho es añadir la etiqueta "pluginManagement" en el pom.xml:

<pluginManagement>
	<plugins>
		<plugin>
	...	
</pluginManagement>

Pero para que Swagger pueda compilar y crear la estructura de carpetas necesaria con los JSON:

{workspace}\test-gae-master\target\test-gae-1.0\swaggerDoc\apidocs\service.json
{workspace}\test-gae-master\target\test-gae-1.0\swaggerDoc\apidocs\Libros.json

dichas etiquetas "pluginManagement" no pueden existir, por lo que hay que comentarlas.