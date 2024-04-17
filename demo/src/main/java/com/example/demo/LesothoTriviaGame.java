package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class LesothoTriviaGame extends Application {
    private int currentQuestionIndex = 0;
    private int score = 0;
    private int totalQuestions = 5;

    private Question[] questions = {
            new Question("What is the capital city of Lesotho?", "Maseru", new String[]{"a)Botha-Bothe","b)Maseru", "c)Leribe", "d)Mafeteng"}),
            new Question("Which mountain range dominates Lesotho's landscape?", "a)Drakensberg Mountains", new String[]{"a)Drakensburg Mountains","c)Atlas Mountains", "b)Alps", "d)Maluti Mountains"}),
            new Question("How many districts are there in Lesotho?","d)10",new String[]{"a)12","b)9","c)11","d)10"}),
            new Question("Which river forms the border between Lesotho and South Africa?","Orange River",new String[]{"a)Mohokare River","b)Phuthiatsana River","c)Senqu River","d)Orange River"}),
            new Question("What is the Basotho hat called?", "b)Mokorotlo",new String[]{"a)Fedora","b)Mokorotlo","c)Ts'ets'e","d)Top Hat"})
    };

    private ImageView imageView;
    private Label questionLabel;
    private RadioButton[] answerButtons;
    private Label feedbackLabel;
    private Label scoreLabel;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600);

        // Top section
        HBox topBox = new HBox();
        topBox.setPadding(new Insets(10));
        scoreLabel = new Label("Score: 0");
        topBox.getChildren().add(scoreLabel);
        root.setTop(topBox);

        // Center section
        VBox centerBox = new VBox(20);
        centerBox.setPadding(new Insets(20));
        imageView = new ImageView();
        imageView.setFitWidth(400);
        imageView.setFitHeight(300);
        centerBox.getChildren().add(imageView);

        questionLabel = new Label();
        centerBox.getChildren().add(questionLabel);
        answerButtons = new RadioButton[4];
        ToggleGroup answerGroup = new ToggleGroup();
        for (int i = 0; i < 4; i++) {
            answerButtons[i] = new RadioButton();
            answerButtons[i].setToggleGroup(answerGroup);
            centerBox.getChildren().add(answerButtons[i]);
        }

         feedbackLabel = new Label();
         centerBox.getChildren().add(feedbackLabel);
         root.setCenter(centerBox);

        // Bottom section
        HBox bottomBox = new HBox(20);
        bottomBox.setPadding(new Insets(10));

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> submitAnswer());

        Button replayButton = new Button("Replay Video");
        replayButton.setOnAction(e -> replayVideo());
        
        bottomBox.getChildren().addAll(submitButton, replayButton);
        root.setBottom(bottomBox);

        // Initialize the first question
        displayQuestion();

        primaryStage.setTitle("Lesotho Trivia Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void displayQuestion() {
    if (currentQuestionIndex < totalQuestions) {
        Question currentQuestion = questions[currentQuestionIndex];
        imageView.setImage(new Image(currentQuestion.getImagePath()));
        questionLabel.setText(currentQuestion.getQuestion());

        String[] options = currentQuestion.getOptions();
        for (int i = 0; i < 4; i++) {
            answerButtons[i].setText(options[i]);
        }
           }
    
        else {
        // Display final score
        questionLabel.setText("Game Over! Your final score is: " + score + "/" + totalQuestions);
        imageView.setImage(null);
        for (RadioButton button : answerButtons) {
            button.setVisible(false);
        }
        feedbackLabel.setText("Well Played");
    }

    }

     private void submitAnswer() {
        if (currentQuestionIndex < totalQuestions) {
            RadioButton selectedRadioButton = (RadioButton) answerButtons[currentQuestionIndex].getToggleGroup().getSelectedToggle();
            if (selectedRadioButton != null) {
                String selectedAnswer = selectedRadioButton.getText();
                String correctAnswer = questions[currentQuestionIndex].getCorrectAnswer();
                if (selectedAnswer.equals(correctAnswer)) {
                     feedbackLabel.setText("Correct!");
                     score++;
                }
                else {
                       feedbackLabel.setText("Please select an answer.");
                }

             }

         }
     }
             private void replayVideo() {
        // Implement replay functionality for video clips
                 }
                 public static void main(String[] args) {

                     launch(args);

                 }

             }
            class Question {
                 private String question;
                 private String correctAnswer;
                 private String[] options;
                 private String imagePath; // Path to image related to the question
                 public Question(String question, String correctAnswer, String[] options) {
                     this.question = question;
                     this.correctAnswer = correctAnswer;
                     this.options = options;

                 }

                 public String getQuestion() {

                     return question;
                 }

                 public String getCorrectAnswer() {

                     return correctAnswer;
                 }

                 public String[] getOptions() {

                     return options;
                 }

                 public String getImagePath() {

                     return imagePath;
                 }

}


