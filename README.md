1. Use jdk 21 and gradle 8.11.1
2. Run gradle bootRun to launch app.
3. Access service at http://localhost:8080, for example http://localhost:8080/excel/element?n=1&path=D://Temp//example.xlsx
4. OpenAPI is availble at http://localhost:8080/swagger-ui/index.html and http://localhost:8080/v3/api-docs
5. To generate OpenAPI docs locally run gradle clean generateOpenApiDocs
