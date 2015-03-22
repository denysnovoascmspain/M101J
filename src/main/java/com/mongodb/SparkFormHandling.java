package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.after;
import static spark.Spark.halt;


public class SparkFormHandling {

    public static void main(String[] args) {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(SparkFormHandling.class, "/");


        Spark.get("/", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                try {
                    StringWriter stringWriter = new StringWriter();

                    Template helloTemplate = configuration.getTemplate("fruitPicker.ftl");

                    Map<String, Object> fruitsMap = new HashMap<String, Object>();

                    fruitsMap.put("fruits", Arrays.asList("apple", "orange", "banana", "peach"));

                    helloTemplate.process(fruitsMap, stringWriter);

                    return stringWriter;
                } catch (Exception e) {
                    halt(500);
                    return null;
                }
            }
        });



        Spark.post("/favorite_fruit", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                final String fruit = request.queryParams("fruit");

                if (fruit == null) {
                    return "Why don´t you pick one?";
                } else {
                    return "Your favorite fruit is " + fruit;
                }
            }
        });
    }
}
