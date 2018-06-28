package com.ingi.apthdac.common.models;

import lombok.Data;

public @Data class SignUpForm {
    String userName;
    String password;
    String retypePassword;
    String email;
}
