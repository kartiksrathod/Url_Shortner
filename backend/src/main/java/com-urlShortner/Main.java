package com.urlshortener;

import static spark.Spark.*;
import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {

        UrlService service = new UrlService();
        Gson gson = new Gson();

        port(4567);

        // Enable CORS
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.header("Access-Control-Allow-Headers", "Content-Type, Authorization, X-Requested-With");
        });

        // Create short URL
        post("/shorten", (req, res) -> {
            res.type("application/json");

            // Read JSON: { "url": "https://google.com" }
            UrlRequest request = gson.fromJson(req.body(), UrlRequest.class);

            if (request == null || request.url == null || request.url.isEmpty()) {
                res.status(400);
                return gson.toJson(new Response("Invalid URL"));
            }

            String shortUrl = service.shortenUrl(request.url);
            return gson.toJson(new UrlResponse(shortUrl, request.url));
        });

        // Redirect to original URL
        get("/:code", (req, res) -> {
            String code = req.params("code");
            String original = service.getOriginalUrl(code);

            if (original == null) {
                halt(404, "URL not found");
                return null;
            }

            res.redirect(original);
            return null;
        });

        System.out.println("🚀 URL Shortener running at: http://localhost:4567");
    }

    // Helper classes
    static class UrlRequest {

        String url;
    }

    static class UrlResponse {

        String shortUrl;
        String longUrl;

        UrlResponse(String s, String l) {
            this.shortUrl = s;
            this.longUrl = l;
        }
    }

    static class Response {

        String message;

        Response(String msg) {
            this.message = msg;
        }
    }
}
