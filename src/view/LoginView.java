package view;

import controller.LoginController;
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

public class LoginView {

    private final StackPane root;

    public LoginView() {

        root = new StackPane();

        root.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #4facfe, #00f2fe);"
        );

        HBox card = new HBox();
        card.maxWidthProperty().bind(root.widthProperty().multiply(0.7));
        card.maxHeightProperty().bind(root.heightProperty().multiply(0.7));
        card.setMinWidth(400);
        card.setMinHeight(300);

        card.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 12;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.25), 30, 0, 0, 10);"
        );

        // LEFT PANEL
        VBox leftPanel = new VBox(20);
        leftPanel.setAlignment(Pos.CENTER);
        leftPanel.prefWidthProperty().bind(card.widthProperty().multiply(0.5));

        leftPanel.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #3A7BD5, #00D2FF);" +
                        "-fx-background-radius: 12 0 0 12;"
        );

        Font faFont = Font.loadFont("file:Fonts/Vazirmatn-ExtraBold.ttf", 17);
        Font enFont = Font.loadFont("file:Fonts/Merienda-ExtraBold.ttf",15);

        Label welcome = new Label("به سامانه نوبت دهی کلینیک خوش آمدید");
        welcome.setStyle(
                "-fx-text-fill: white;" + "-fx-font-smoothing-type: lcd; " +
                        "-fx-text-fill: white;"
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
        VBox formPanel = new VBox(12);
        formPanel.setAlignment(Pos.CENTER);
        formPanel.setPadding(new Insets(40));
        formPanel.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        formPanel.prefWidthProperty().bind(card.widthProperty().multiply(0.5));

        Font logFont = Font.loadFont("file:Fonts/Merienda-Black.ttf",24);
        Label title = new Label("Login");
        title.setFont(logFont);

        TextField usernameField = new TextField();
        usernameField.setPromptText("نام کاربری");
        usernameField.setPrefHeight(35);

        // === این خط رو اضافه کردم تا فیلد نام کاربری کل عرض پنل راست رو پر کنه ===
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

        // === این خط رو اضافه کردم تا فیلد رمز عبور کل عرض پنل راست رو پر کنه ===
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


        Font logFont2 = Font.loadFont("file:Fonts/Merienda-Black.ttf",14);
        Button loginButton = new Button("Login");
        loginButton.setMaxWidth(Double.MAX_VALUE);

        loginButton.setPrefHeight(35);
        loginButton.setFont(logFont2);

        loginButton.setStyle(
                "-fx-background-color: #2F80ED;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-radius: 6;"
        );

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
        registerLink.setOnMouseEntered(e -> registerLink.setStyle(
                "-fx-text-fill: #2F80ED;" +
                        "-fx-underline: true;" +
                        "-fx-font-size: 13.5px;" +
                        "-fx-font-family: 'Vazirmatn';" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;"
        ));
        registerLink.setOnMouseExited(e -> registerLink.setStyle(
                "-fx-text-fill: #1E88E5;" +
                        "-fx-underline: false;" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-family: 'Vazirmatn';" +
                        "-fx-font-weight: normal;"
        ));


        registerLink.setOnAction(e -> {

            RegisterView registerView = new RegisterView();
            Scene scene = new Scene(registerView.getView(), 900, 600);

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
                visiblePasswordField,
                showPassword,
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
