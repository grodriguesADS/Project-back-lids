package br.edu.ifpb.lids.presentation.dto;

import br.edu.ifpb.lids.model.enums.UserRole;

public record RegisterDto(String login, String password, UserRole role) {
    
}
