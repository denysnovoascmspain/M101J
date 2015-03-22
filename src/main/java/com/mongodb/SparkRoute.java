package com.mongodb;


import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkRoute {
    public static void main(String[] args) {
        Spark.get("/", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return "Hello Word\n";
            }
        });

        Spark.get("/test" , new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return "This is a page test\n";
            }
        });

        Spark.get("/echo/:thing" , new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return request.params(":thing");
            }
        });
    }
}
