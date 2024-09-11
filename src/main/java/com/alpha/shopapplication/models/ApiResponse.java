package com.alpha.shopapplication.models;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

@Data
public class ApiResponse<T> {
    private String message;
    private T data;


    public ApiResponse( String message,T data) {
        this.message = message;
        this.data = data;
    }

    public ApiResponse(String message) {
        this.message = message;
    }
    public ApiResponse(){

    }

}
