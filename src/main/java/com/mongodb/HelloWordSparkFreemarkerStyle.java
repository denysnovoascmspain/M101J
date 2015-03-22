package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.halt;


public class HelloWordSparkFreemarkerStyle {

    public static void main(String[] args) {

        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWordSparkFreemarkerStyle.class, "/");

        Spark.get("/", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {

                    StringWriter stringWriter = new StringWriter();
                try {
                    Template helloTemplate = configuration.getTemplate("hello.ftl");

                    Map<String, Object> helloMap = new HashMap<String, Object>();

                    helloMap.put("name", "Freemarker");

                    helloTemplate.process(helloMap, stringWriter);

                    System.out.println(stringWriter);


                } catch (Exception e) {
                    halt(500);
                    e.printStackTrace();
                }

                return stringWriter;
            }
        });
    }
}
