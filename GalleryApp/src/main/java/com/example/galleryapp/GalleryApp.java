package com.example.galleryapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.lang.module.FindException;
import java.util.Objects;

public class GalleryApp extends Application {

    private ImageView fullSizeImageView;

    private final String[] imagePaths = {
            "image1.jpg",
            "image2.jpg",
            "image3.jpg",
            "image4.jpg",
            "image5.jpg",
            "image6.jpg",
            "image7.jpg",
            "image8.jpg",
            "image9.jpg",
            "image10.jpg",
            "image11.jpg",
            "image12.jpg"
    };

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        primaryStage.setTitle("Gallery App");

        // Thumbnail
        FlowPane thumbnailView = new FlowPane();
        thumbnailView.getStyleClass().add("thumbnail-view");
        thumbnailView.setPadding(new Insets(10));
        thumbnailView.setHgap(10);
        thumbnailView.setVgap(10);

        // Adding thumbnail images
        for (int i = 0; i < imagePaths.length; i++) {
            ImageView thumbnail = createThumbnail(imagePaths[i], i);
            thumbnailView.getChildren().add(thumbnail);
        }

        // Full-size image view
        fullSizeImageView = new ImageView();
        fullSizeImageView.getStyleClass().add("full-size-image-view");
        fullSizeImageView.setFitWidth(400);
        fullSizeImageView.setFitHeight(600);
        fullSizeImageView.setVisible(false);


        Button backButton = new Button("Back");
        backButton.getStyleClass().add("back-button");
        backButton.setOnAction(event -> showThumbnailView());
        backButton.setAlignment(Pos.BOTTOM_LEFT);
        backButton.setStyle("-fx-background-color: blue;-fx-font-size:18 px;-fx-font-family:Verdana;-fx-text-fill: white;-fx-font-weight: bold;-fx-padding: 10px 20px;-fx-cursor: hand;");

        //Next button to the next button
        Button nextButton = new Button("Next");
        nextButton.setOnMouseClicked(event ->showThumbnailView());
        nextButton.setStyle("-fx-background-color: blue;-fx-font-size:18 px;-fx-font-family:Verdana;-fx-text-fill: white;-fx-font-weight: bold;-fx-padding: 10px 20px;-fx-cursor: hand;");

        StackPane fullSizeImageContainer = new StackPane();
        fullSizeImageContainer.getChildren().addAll(fullSizeImageView,nextButton,backButton);

        root.setCenter(fullSizeImageContainer);
        root.setLeft(thumbnailView);

        Scene scene = new Scene(root, 800, 600 );
        //scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Image Gallery");
        primaryStage.show();

    }

    private ImageView createThumbnail(String imagePath, int index) {
        ImageView thumbnail = new ImageView(new Image(imagePath));
        thumbnail.getStyleClass().add("thumbnail");
        thumbnail.setFitWidth(100);
        thumbnail.setFitHeight(100);
        thumbnail.setOnMouseClicked(event -> showFullSizeImage(index));
        return thumbnail;
    }


    private void showFullSizeImage(int index) {
        if (index >= 0 && index < imagePaths.length) {
            fullSizeImageView.setImage(new Image(imagePaths[index]));
            fullSizeImageView.setImage(new Image(imagePaths[index]));
            fullSizeImageView.setVisible(true);
            fullSizeImageView.setOnMouseClicked(event -> showThumbnailView());
        }
    }

    private void showThumbnailView() {
        fullSizeImageView.setVisible(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
