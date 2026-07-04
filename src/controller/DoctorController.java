package controller;

import service.registerService;

public class DoctorController {


    public boolean handleDoctorRegister(String username, String password, String medicalCode) {
        if (username == null || password == null || medicalCode == null) {
            return false;
        }

        registerService service = new registerService();
        return service.registerDoctor(
                username.trim(),
                password.trim(),
                medicalCode.trim()
        ).isSuccess();
    }
}
