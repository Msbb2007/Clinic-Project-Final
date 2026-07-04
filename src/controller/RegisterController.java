package controller;

import service.RegisterResult;
import service.registerService;

public class RegisterController {

    private final registerService registerService;

    public RegisterController() {
        this.registerService = new registerService();
    }

    public RegisterResult handleRegister(String username, String password, String role, String adminCode) {
        return registerService.registerUser(username, password, role, adminCode);
    }
}
