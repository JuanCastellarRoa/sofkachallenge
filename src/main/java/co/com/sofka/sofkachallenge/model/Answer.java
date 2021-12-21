package co.com.sofka.sofkachallenge.model;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String text;
    @Column(name = "correct_answer")
    private String correctAnswer;

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getText() {return text;}

    public void setText(String text) {this.text = text;}

    public String getCorrectAnswer() {return correctAnswer;}

    public void setCorrectAnswer(String correctAnswer) {this.correctAnswer = correctAnswer;}

}

