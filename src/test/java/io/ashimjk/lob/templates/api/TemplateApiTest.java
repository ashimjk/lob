package io.ashimjk.lob.templates.api;

import io.ashimjk.lob.templates.entity.Template;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class TemplateApiTest {

    @LocalServerPort
    private int port;

    @Test
    @DisplayName("Create Template")
    void testCreateTemplate() {
        Template template = createTemplate();
        Template response = api()
                .body(template)
                .post()
                .then()
                .statusCode(201)
                .extract()
                .as(Template.class);

        System.out.println(response);

        api()
                .get()
                .then()
                .statusCode(200);
    }

    private Template createTemplate() {
        Template template = new Template();
        template.setName("test");
        template.setFileName(getFileName());
        template.setContent("<p>testing template</p>");
        return template;
    }

    @SneakyThrows
    private byte[] getFileName() {
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("application.properties");

        assertNotNull(inputStream);
        byte[] file = new byte[inputStream.available()];
        inputStream.read(file);
        return file;
    }

    private RequestSpecification api() {
        return RestAssured.given()
                .baseUri("http://localhost")
                .port(port)
                .basePath("templates")
                .contentType("application/json")
                .when();
    }

}