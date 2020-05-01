package com.almenoscompila.ApplicationBackend.Security;

import com.almenoscompila.ApplicationBackend.Domain.User;

public interface SecurityService {

    void login(String username, String password);

    void insertUser(User user);

}
