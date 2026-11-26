package com.ishika.taskboard.dto;

public record AuthResponse(
        String token,
        String tokenType,
        UserResponse user
) {}