package view;

import controller.RegisterController;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.CacheHint;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.util.Duration;
import util.SceneManager;

public class RegisterView {

    private final StackPane root;

    public RegisterView() {

        root = new StackPane();

        root.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #4facfe, #00f2fe);"
        );

        HBox card = new HBox();
        card.setMaxWidth(700);
        card.setMaxHeight(420);

        card.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 12;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.25), 30, 0, 0, 10);"
        );

        // LEFT PANEL
        VBox leftPanel = new VBox(20);
        leftPanel.setAlignment(Pos.CENTER);
        leftPanel.setPrefWidth(300);

        leftPanel.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #3A7BD5, #00D2FF);" +
                        "-fx-background-radius: 12 0 0 12;"
        );

        Font faFont = Font.loadFont("file:Fonts/Vazirmatn-ExtraBold.ttf",20);
        Label welcome = new Label("ثبت نام در سامانه کلینیک");
        welcome.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;"
        );
        welcome.setFont(faFont);
        welcome.setCache(true);
        welcome.setCacheHint(CacheHint.QUALITY);
        welcome.setTextOverrun(OverrunStyle.CLIP);
        welcome.setFont(faFont);
        welcome.setCursor(Cursor.HAND);

        welcome.setOnMouseEntered(event -> {
            Font faFont2 = Font.loadFont("file:Fonts/Vazirmatn-ExtraBold.ttf", 17);
            welcome.setFont(faFont2);
            TranslateTransition moveUp = new TranslateTransition(Duration.millis(50250), welcome);
            moveUp.setToY(-4);

            ScaleTransition scaleUp = new ScaleTransition(Duration.millis(50), welcome);
            scaleUp.setToX(1.05);
            scaleUp.setToY(1.05);

            moveUp.play();
            scaleUp.play();
        });

        welcome.setOnMouseExited(event -> {
            Font faFont2 = Font.loadFont("file:Fonts/Vazirmatn-ExtraBold.ttf", 17);
            welcome.setFont(faFont2);

            TranslateTransition moveDown = new TranslateTransition(Duration.millis(150), welcome);
            moveDown.setToY(0);

            ScaleTransition scaleDown = new ScaleTransition(Duration.millis(150), welcome);
            scaleDown.setToX(1);
            scaleDown.setToY(1);

            moveDown.play();
            scaleDown.play();
        });

        Font enFont = Font.loadFont("file:Fonts/Merienda-ExtraBold.ttf",15);
        Label subtitle = new Label("Create your account");
        subtitle.setStyle(
                "-fx-text-fill: white;"
        );
        subtitle.setFont(enFont);
        subtitle.setCursor(Cursor.HAND);
        subtitle.setOnMouseEntered(event -> {
            TranslateTransition moveUp = new TranslateTransition(Duration.millis(50250), subtitle);
            moveUp.setToY(-4);

            ScaleTransition scaleUp = new ScaleTransition(Duration.millis(50), subtitle);
            scaleUp.setToX(1.05);
            scaleUp.setToY(1.05);

            moveUp.play();
            scaleUp.play();
        });

        subtitle.setOnMouseExited(event -> {

            TranslateTransition moveDown = new TranslateTransition(Duration.millis(70), subtitle);
            moveDown.setToY(0);

            ScaleTransition scaleDown = new ScaleTransition(Duration.millis(70), subtitle);
            scaleDown.setToX(1);
            scaleDown.setToY(1);

            moveDown.play();
            scaleDown.play();
        });


        leftPanel.getChildren().addAll(welcome, subtitle);

        // RIGHT PANEL
        VBox formPanel = new VBox(18);
        formPanel.setAlignment(Pos.CENTER);
        formPanel.setPadding(new Insets(40));
        formPanel.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        Font enFont2 = Font.loadFont("file:Fonts/Merienda-ExtraBold.ttf",22);
        Label title = new Label("Register");
        title.setStyle(
                "-fx-font-weight: bold;"
        );
        title.setFont(enFont2);

        TextField usernameField = new TextField();
        usernameField.setPromptText("نام کاربری");
        usernameField.setPrefHeight(35);

        usernameField.setMaxWidth(Double.MAX_VALUE);

        usernameField.setStyle(
                "-fx-background-color: #F8FAFC;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-color: #E2E8F0;" +
                        "-fx-border-radius: 10;" +
                        "-fx-padding: 12 15 12 15;" +
                        "-fx-prompt-text-fill: #94A3B8;" +
                        "-fx-font-family: 'Vazirmatn';" +
                        "-fx-font-size: 13px;"
        );

        usernameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                usernameField.setStyle(
                        "-fx-background-color: #FFFFFF;" +
                                "-fx-background-radius: 10;" +
                                "-fx-border-color: #3A7BD5;" +
                                "-fx-border-radius: 10;" +
                                "-fx-padding: 12 15 12 15;" +
                                "-fx-prompt-text-fill: #CBD5E1;" +
                                "-fx-font-family: 'Vazirmatn';" +
                                "-fx-font-size: 13px;" +
                                "-fx-effect: dropshadow(three-pass-box, rgba(58, 123, 213, 0.15), 10, 0, 0, 0);"
                );
            } else {
                usernameField.setStyle(
                        "-fx-background-color: #F8FAFC;" +
                                "-fx-background-radius: 10;" +
                                "-fx-border-color: #E2E8F0;" +
                                "-fx-border-radius: 10;" +
                                "-fx-padding: 12 15 12 15;" +
                                "-fx-prompt-text-fill: #94A3B8;" +
                                "-fx-font-family: 'Vazirmatn';" +
                                "-fx-font-size: 13px;"
                );
            }
        });


        PasswordField passwordField = new PasswordField();
        TextField visiblePasswordField = new TextField();
        visiblePasswordField.setPromptText("رمز عبور");
        visiblePasswordField.setPrefHeight(35);
        visiblePasswordField.setMaxWidth(Double.MAX_VALUE);

        visiblePasswordField.setManaged(false);
        visiblePasswordField.setVisible(false);

        visiblePasswordField.setStyle(
                "-fx-background-color: #F8FAFC;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-color: #E2E8F0;" +
                        "-fx-border-radius: 10;" +
                        "-fx-padding: 12 15 12 15;" +
                        "-fx-prompt-text-fill: #94A3B8;" +
                        "-fx-font-family: 'Vazirmatn';" +
                        "-fx-font-size: 13px;"
        );
        visiblePasswordField.textProperty().bindBidirectional(passwordField.textProperty());

        passwordField.setPromptText("رمز عبور");
        passwordField.setPrefHeight(35);

        passwordField.setMaxWidth(Double.MAX_VALUE);

        passwordField.setStyle(
                "-fx-background-color: #F8FAFC;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-color: #E2E8F0;" +
                        "-fx-border-radius: 10;" +
                        "-fx-padding: 12 15 12 15;" +
                        "-fx-prompt-text-fill: #94A3B8;" +
                        "-fx-font-family: 'Vazirmatn';" +
                        "-fx-font-size: 13px;"
        );

        passwordField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                passwordField.setStyle(
                        "-fx-background-color: #FFFFFF;" +
                                "-fx-background-radius: 10;" +
                                "-fx-border-color: #3A7BD5;" +
                                "-fx-border-radius: 10;" +
                                "-fx-padding: 12 15 12 15;" +
                                "-fx-prompt-text-fill: #CBD5E1;" +
                                "-fx-font-family: 'Vazirmatn';" +
                                "-fx-font-size: 13px;" +
                                "-fx-effect: dropshadow(three-pass-box, rgba(58, 123, 213, 0.15), 10, 0, 0, 0);"
                );
            } else {
                passwordField.setStyle(
                        "-fx-background-color: #F8FAFC;" +
                                "-fx-background-radius: 10;" +
                                "-fx-border-color: #E2E8F0;" +
                                "-fx-border-radius: 10;" +
                                "-fx-padding: 12 15 12 15;" +
                                "-fx-prompt-text-fill: #94A3B8;" +
                                "-fx-font-family: 'Vazirmatn';" +
                                "-fx-font-size: 13px;"
                );
            }
        });
        CheckBox showPassword = new CheckBox("نمایش رمز عبور");
        Font fafont = Font.loadFont("file:Fonts/Vazirmatn-ExtraBold.ttf",13);
        showPassword.setFont(fafont);
        showPassword.setStyle(
                "-fx-text-fill: #475569;" +
                        "-fx-cursor: hand;"
        );

        showPassword.setOnAction(e -> {

            if (showPassword.isSelected()) {

                visiblePasswordField.setVisible(true);
                visiblePasswordField.setManaged(true);

                passwordField.setVisible(false);
                passwordField.setManaged(false);

            } else {

                visiblePasswordField.setVisible(false);
                visiblePasswordField.setManaged(false);

                passwordField.setVisible(true);
                passwordField.setManaged(true);
            }
        });

        ComboBox<String> roleBox = new ComboBox<>();
        roleBox.getItems().addAll("admin", "doctor", "patient");
        roleBox.setPromptText("Select Role");
        roleBox.setPrefHeight(35);

        Font logFont2 = Font.loadFont("file:Fonts/Merienda-Black.ttf",14);
        Button registerButton = new Button("Register");
        registerButton.setMaxWidth(Double.MAX_VALUE);

        registerButton.setPrefHeight(35);
        registerButton.setFont(logFont2);

        registerButton.setStyle(
                "-fx-background-color: #2F80ED;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-radius: 6;"
        );

        registerButton.setOnMouseEntered(e ->
                registerButton.setStyle(
                        "-fx-background-color: #1C6ED5;" +
                                "-fx-text-fill: white;" +
                                "-fx-background-radius: 6;"
                )
        );

        registerButton.setOnMouseExited(e ->
                registerButton.setStyle(
                        "-fx-background-color: #2F80ED;" +
                                "-fx-text-fill: white;" +
                                "-fx-background-radius: 6;"
                )
        );

        Hyperlink loginLink = new Hyperlink("Already have an account? Login");
        loginLink.setStyle(
                "-fx-text-fill: #1E88E5;" +
                        "-fx-underline: false;" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-family: 'Vazirmatn';" +
                        "-fx-font-weight: normal;"
        );
        loginLink.setOnMouseEntered(e -> loginLink.setStyle(
                "-fx-text-fill: #2F80ED;" +
                        "-fx-underline: true;" +
                        "-fx-font-size: 13.5px;" +
                        "-fx-font-family: 'Vazirmatn';" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;"
        ));
        loginLink.setOnMouseExited(e -> loginLink.setStyle(
                "-fx-text-fill: #1E88E5;" +
                        "-fx-underline: false;" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-family: 'Vazirmatn';" +
                        "-fx-font-weight: normal;"
        ));
        loginLink.setStyle(
                "-fx-text-fill: #1E88E5;" +
                        "-fx-underline: true;" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-family: 'Vazirmatn';" +
                        "-fx-font-weight: normal;"
        );
        loginLink.setOnAction(e -> {

            LoginView loginView = new LoginView();
            Scene scene = new Scene(loginView.getView(), 900, 500);

            SceneManager.switchScene(scene);

        });

        Label message = new Label();

        RegisterController controller =
                new RegisterController(usernameField, passwordField, roleBox, message);

        registerButton.setOnAction(e -> {
            controller.handleRegister();
        });

        formPanel.getChildren().addAll(
                title,
                usernameField,
                passwordField,
                visiblePasswordField,
                showPassword,
                roleBox,
                registerButton,
                loginLink,
                message
        );

        card.getChildren().addAll(leftPanel, formPanel);
        root.getChildren().add(card);
    }

    public Parent getView() {
        return root;
    }
}
