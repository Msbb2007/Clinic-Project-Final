package view;

import controller.DoctorController;
import controller.RegisterController;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import util.SceneManager;

public class RegisterDoctorView {

    private final StackPane root;

    public RegisterDoctorView() {
        root = new StackPane();
        root.setStyle("-fx-background-color: linear-gradient(to bottom right, #11998e, #38ef7d);");

        HBox card = new HBox();
        card.setMaxWidth(750);
        card.setMaxHeight(450);
        card.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 12;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.25), 30, 0, 0, 10);"
        );

        // پنل سمت چپ
        VBox leftPanel = new VBox(20);
        leftPanel.setAlignment(Pos.CENTER);
        leftPanel.setPrefWidth(300);
        leftPanel.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #11998e, #085078);" +
                        "-fx-background-radius: 12 0 0 12;"
        );

        Label welcomeLabel = new Label("ثبت‌نام پزشک");
        welcomeLabel.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 22px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-font-family: 'Vazirmatn';"
        );

        Label subtitleLabel = new Label("Doctor Register");
        subtitleLabel.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-family: 'Arial';"
        );

        leftPanel.getChildren().addAll(welcomeLabel, subtitleLabel);

        // پنل فرم
        VBox formPanel = new VBox(15);
        formPanel.setAlignment(Pos.CENTER);
        formPanel.setPadding(new Insets(30));
        formPanel.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        formPanel.setStyle("-fx-background-radius: 0 12 12 0;");
        HBox.setHgrow(formPanel, Priority.ALWAYS);

        Label title = new Label("ثبت نام پزشک");
        title.setStyle(
                "-fx-text-fill: #1E293B;" +
                        "-fx-font-size: 20px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-font-family: 'Vazirmatn';"
        );

        TextField usernameField = createStyledTextField("نام کاربری");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("رمز عبور");
        passwordField.setPrefHeight(40);
        passwordField.setMaxWidth(Double.MAX_VALUE);
        passwordField.setStyle(
                "-fx-background-color: #F8FAFC;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-color: #E2E8F0;" +
                        "-fx-border-radius: 10;" +
                        "-fx-padding: 10 15 10 15;" +
                        "-fx-prompt-text-fill: #94A3B8;" +
                        "-fx-font-family: 'Vazirmatn';" +
                        "-fx-font-size: 13px;"
        );

        TextField medicalCodeField = createStyledTextField("کد نظام پزشکی");

        Button registerButton = new Button("ثبت نام");
        registerButton.setMaxWidth(Double.MAX_VALUE);
        registerButton.setPrefHeight(40);
        registerButton.setStyle(
                "-fx-background-color: #11998e;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-radius: 10;" +
                        "-fx-font-family: 'Vazirmatn';" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;"
        );

        Hyperlink loginLink = new Hyperlink("بازگشت به صفحه لاگین");
        loginLink.setStyle(
                "-fx-font-family: 'Vazirmatn';" +
                        "-fx-font-size: 12px;" +
                        "-fx-text-fill: #085078;"
        );

        loginLink.setOnAction(e -> {
            LoginView loginView = new LoginView();
            Scene scene = new Scene(loginView.getView(), 900, 500);

            SceneManager.switchScene(scene);
        });

        registerButton.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();
            String medicalCode = medicalCodeField.getText().trim();

            if (username.isEmpty() || password.isEmpty() || medicalCode.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "خطا", "لطفاً تمام فیلدها را پر کنید.");
                return;
            }

            DoctorController controller = new DoctorController();
            boolean success = controller.handleDoctorRegister(username, password, medicalCode);

            if (success) {
                showAlert(Alert.AlertType.INFORMATION, "موفق", "ثبت نام پزشک با موفقیت انجام شد.");
                AdminDashboardView adminDashboardView = new AdminDashboardView();
                Scene scene = new Scene(adminDashboardView.getView());
                SceneManager.switchScene(scene);
            } else {
                showAlert(Alert.AlertType.ERROR, "خطا", "ثبت نام انجام نشد.");
            }
        });

        formPanel.getChildren().addAll(
                title,
                usernameField,
                passwordField,
                medicalCodeField,
                registerButton,
                loginLink
        );

        card.getChildren().addAll(leftPanel, formPanel);
        root.getChildren().add(card);
    }

    public Parent getView() {
        return root;
    }

    private TextField createStyledTextField(String prompt) {
        TextField textField = new TextField();
        textField.setPromptText(prompt);
        textField.setPrefHeight(40);
        textField.setMaxWidth(Double.MAX_VALUE);
        textField.setStyle(
                "-fx-background-color: #F8FAFC;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-color: #E2E8F0;" +
                        "-fx-border-radius: 10;" +
                        "-fx-padding: 10 15 10 15;" +
                        "-fx-prompt-text-fill: #94A3B8;" +
                        "-fx-font-family: 'Vazirmatn';" +
                        "-fx-font-size: 13px;"
        );
        return textField;
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
