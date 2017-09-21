package teamtreehouse.com.treehousequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Question question;
    int random1;
    int random2;
    int answer;
    EditText answerEditText;
    String answerInput;
    int answerInputInt;
    TextView randomNumberTv;
    Button submitAnswerButton1;
    Button submitAnswerButton2;
    Button submitAnswerButton3;
    Button submitAnswerButton4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = new Question();
        random1 = question.getRandomNumber();
        random2 = question.getRandomNumber();
        answer = random1 + random2;

        randomNumberTv = (TextView) findViewById(R.id.answerTextView);

        randomNumberTv.setText(random1 + "+" + random2);

        submitAnswerButton1 = (Button)findViewById(R.id.radioButton1);

        submitAnswerButton2 = (Button)findViewById(R.id.radioButton2);


        submitAnswerButton3 = (Button)findViewById(R.id.radioButton3);

        submitAnswerButton4 = (Button)findViewById(R.id.submitAnswerButton4);
        submitAnswerButton4.setOnClickListener(answerCheck);

        question.setAnswerChoices(answer,submitAnswerButton1,submitAnswerButton2,submitAnswerButton3);

        }
    View.OnClickListener answerCheck = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            /*
            answerEditText = (EditText) findViewById(R.id.answerEditText);

            try{
                answerInputInt = Integer.parseInt(answerEditText.getText().toString());
            }
            catch(NumberFormatException nfe){
                Toast.makeText(getApplicationContext(), "incorrect input", Toast.LENGTH_LONG).show();
            }
            */
            //Button b = (Button)view;
            //int buttonInt = Integer.parseInt(b.getText().toString());

            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
            String radioValue = ((RadioButton) findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
            int buttonInt1 = Integer.parseInt(radioValue);

            if(buttonInt1 == answer) {
                Toast.makeText(getApplicationContext(), "Correct!" , Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "Incorrect!" , Toast.LENGTH_SHORT).show();
            }
            random1 = question.getRandomNumber();
            random2 = question.getRandomNumber();
            answer = random1 + random2;
            randomNumberTv.setText(random1 + "+" + random2);
            question.setAnswerChoices(answer,submitAnswerButton1,submitAnswerButton2,submitAnswerButton3);
        }
        //randomNumberTv.setText("I love people");
    };
}
