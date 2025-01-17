package com.kchen.mas.entry;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonPropertyOrder({
        "statusCode",
        "message",
        "data"
})
@Data
public class JsonResult {
    @JsonProperty("statusCode")
    private int statusCode;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private Object data;


    public static JsonResult SUCCESS(Object data){
        JsonResult result = new JsonResult();
        result.setStatusCode(200);
        result.setData(data);
        return result;
    }

    public static JsonResult SUCCESS(){
        JsonResult result = new JsonResult();
        result.setStatusCode(200);
        result.setData("SUCCESS");
        return result;
    }

    public static JsonResult FAILURE(String message) {
        JsonResult result = new JsonResult();
        result.setStatusCode(500);
        result.setMessage(message);
        result.setData("FAILURE");
        return result;
    }

    public static JsonResult FAILURE(int code, String message) {
        JsonResult result = new JsonResult();
        result.setStatusCode(code);
        result.setMessage(message);
        result.setData("FAILURE");
        return result;
    }
}
