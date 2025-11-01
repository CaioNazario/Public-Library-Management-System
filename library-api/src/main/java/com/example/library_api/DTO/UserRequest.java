package com.example.library_api.DTO;

public record UserRequest(

        String name,
        String email,
        String CPF,
        String phone,
        String address,
        String role,
        String password

) {
}
