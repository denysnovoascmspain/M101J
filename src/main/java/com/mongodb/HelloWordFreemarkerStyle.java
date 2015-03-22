package com.mongodb;


import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HelloWordFreemarkerStyle {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWordFreemarkerStyle.class, "/");

        try {
            Template helloTemplate = configuration.getTemplate("hello.ftl");
            StringWriter stringWriter = new StringWriter();

            Map<String, Object> helloMap = new HashMap<String, Object>();

            helloMap.put("name", "Freemarker");

            helloTemplate.process(helloMap, stringWriter);

            System.out.println(stringWriter);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
