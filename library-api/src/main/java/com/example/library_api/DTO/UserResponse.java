package com.example.library_api.DTO;

public record UserResponse(

        Long id,
        String name,
        String email,
        String phone,
        String address,
        String role
) {
}
