package teamtreehouse.com.treehousequiz;

import android.widget.Button;

import java.util.Random;

public class Question extends MainActivity {
    private int randomNumber;
    private int correctAnswer;
    private int deviation;

    Random random = new Random();

    public Integer getRandomNumber() {
        return random.nextInt(100) + 1;
    }

    public void setRandomNumber(Integer randomNumber) {
        this.randomNumber = randomNumber;
    }



    public void setAnswerChoices(int trueAnswer, Button button1, Button button2, Button button3){

        deviation = random.nextInt(25) + 1;
        correctAnswer = random.nextInt(3) + 1;
        switch(correctAnswer){
            case 1: button1.setText(trueAnswer + "");
                    button2.setText(trueAnswer - deviation + "");
                    button3.setText(trueAnswer + deviation + "");
                break;
            case 2: button2.setText(trueAnswer+ "");
                    button1.setText(trueAnswer+deviation+"");
                    button3.setText(trueAnswer-deviation+"");
                break;
            case 3: button3.setText(trueAnswer+ "");
                    button2.setText(trueAnswer+deviation+"");
                    button1.setText(trueAnswer-deviation+"");
                break;
        }
    }

}
