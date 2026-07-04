package service;

import dao.UserDao;
import model.User;

public class registerService {

    private final UserDao userDao;

    public registerService() {
        this.userDao = new UserDao();
    }

    public RegisterResult registerUser(String username, String password, String roleName, String securityCode) {
        if (username.isEmpty() || password.isEmpty() || roleName.isEmpty()) {
            return new RegisterResult(false, "لطفاً همه فیلدها را تکمیل کنید.");
        }

        if (userDao.existsByUsername(username)) {
            return new RegisterResult(false, "این نام کاربری قبلاً ثبت شده است.");
        }

        if (roleName.equalsIgnoreCase("ADMIN")) {
            if (securityCode.isEmpty()) {
                return new RegisterResult(false, "کد امنیتی ادمین الزامی است.");
            }

            // این مقدار را بعداً می‌توانی از config/database/env بخوانی
            if (!securityCode.equals("msb13msb13")) {
                return new RegisterResult(false, "کد امنیتی ادمین نادرست است.");
            }
        }

        if (!roleName.equalsIgnoreCase("PATIENT") && !roleName.equalsIgnoreCase("ADMIN")) {
            return new RegisterResult(false, "نقش انتخاب‌شده معتبر نیست.");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRoleName(roleName.toUpperCase());

        boolean saved = userDao.save(user);

        if (saved) {
            return new RegisterResult(true, "ثبت‌نام با موفقیت انجام شد.");
        } else {
            return new RegisterResult(false, "خطا در ذخیره اطلاعات کاربر.");
        }
    }

    public RegisterResult registerDoctor(String username, String password, String medicalCode) {
        if (username.isEmpty() || password.isEmpty() || medicalCode.isEmpty()) {
            return new RegisterResult(false, "لطفاً همه فیلدهای پزشک را تکمیل کنید.");
        }

        if (userDao.existsByUsername(username)) {
            return new RegisterResult(false, "این نام کاربری قبلاً ثبت شده است.");
        }

        if (medicalCode.length() < 4) {
            return new RegisterResult(false, "کد نظام پزشکی معتبر نیست.");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRoleName("DOCTOR");

        boolean saved = userDao.saveDoctor(user, medicalCode);

        if (saved) {
            return new RegisterResult(true, "ثبت‌نام پزشک با موفقیت انجام شد.");
        } else {
            return new RegisterResult(false, "خطا در ثبت اطلاعات پزشک.");
        }
    }


}

