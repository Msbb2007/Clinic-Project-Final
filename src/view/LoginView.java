package view;

import controller.LoginController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import util.SceneManager;

public class LoginView {

    private final StackPane root;

    public LoginView() {

        root = new StackPane();

        root.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #4facfe, #00f2fe);"
        );

        HBox card = new HBox();
        card.setMaxWidth(700);
        card.setMaxHeight(400);

        card.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 12;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.25), 30, 0, 0, 10);"
        );

        // LEFT PANEL
        VBox leftPanel = new VBox(30);
        leftPanel.setAlignment(Pos.CENTER);
        leftPanel.setPrefWidth(300);

        leftPanel.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #3A7BD5, #00D2FF);" +
                        "-fx-background-radius: 12 0 0 12;"
        );

        Font faFont = Font.loadFont("file:Fonts/Vazirmatn-ExtraBold.ttf", 18);
        Font enFont = Font.loadFont("file:Fonts/Merienda-Regular.ttf",14);

        Label welcome = new Label("به سامانه نوبت دهی کلینیک خوش آمدید");
        welcome.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 24px;" +
                        "-fx-font-weight: bold;"
        );
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


        Label subtitle = new Label("Clinic Management System");
        subtitle.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;"
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
        VBox formPanel = new VBox(15);
        formPanel.setAlignment(Pos.CENTER);
        formPanel.setPadding(new Insets(40));

        Label title = new Label("Login");
        title.setStyle(
                "-fx-font-size: 22px;" +
                        "-fx-font-weight: bold;"
        );

        TextField usernameField = new TextField();
        usernameField.setPromptText("نام کاربری");
        usernameField.setPrefHeight(35);
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
        passwordField.setPromptText("رمز عبور");
        passwordField.setPrefHeight(35);
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

        Font logFont2 = Font.loadFont("file:Fonts/Merienda-Black.ttf",14);
        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(200);
        loginButton.setPrefHeight(35);
        loginButton.setFont(logFont2);

        loginButton.setStyle(
                "-fx-background-color: #2F80ED;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-radius: 6;"
        );

        // hover effect
        loginButton.setOnMouseEntered(e ->
                loginButton.setStyle(
                        "-fx-background-color: #1C6ED5;" +
                                "-fx-text-fill: white;" +
                                "-fx-background-radius: 6;"
                )
        );

        loginButton.setOnMouseExited(e ->
                loginButton.setStyle(
                        "-fx-background-color: #2F80ED;" +
                                "-fx-text-fill: white;" +
                                "-fx-background-radius: 6;"
                )
        );

        Hyperlink registerLink = new Hyperlink("Create account");
        registerLink.setStyle(
                "-fx-text-fill: #1E88E5;" +
                        "-fx-underline: false;" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-family: 'Vazirmatn';" +
                        "-fx-font-weight: normal;"
        );
        registerLink.setOnMouseEntered(e -> {
            registerLink.setStyle(
                    "-fx-text-fill: #0D6EFD;" +
                            "-fx-underline: true;" +
                            "-fx-font-size: 13.5px;" +
                            "-fx-font-family: 'Vazirmatn';" +
                            "-fx-font-weight: bold;" +
                            "-fx-cursor: hand;"
            );
        });
        registerLink.setOnMouseExited(e -> {
            registerLink.setStyle(
                    "-fx-text-fill: #1E88E5;" +
                            "-fx-underline: false;" +
                            "-fx-font-size: 13px;" +
                            "-fx-font-family: 'Vazirmatn';" +
                            "-fx-font-weight: normal;"
            );
        });
        

        registerLink.setOnAction(e -> {

            RegisterView registerView = new RegisterView();
            Scene scene = new Scene(registerView.getView(), 900, 500);

            SceneManager.switchScene(scene);
        });

        Label message = new Label();

        LoginController controller =
                new LoginController(usernameField, passwordField, message);

        loginButton.setOnAction(e -> controller.handleLogin());

        formPanel.getChildren().addAll(
                title,
                usernameField,
                passwordField,
                loginButton,
                registerLink,
                message
        );

        card.getChildren().addAll(leftPanel, formPanel);
        root.getChildren().add(card);
    }

    public Parent getView() {
        return root;
    }
}
