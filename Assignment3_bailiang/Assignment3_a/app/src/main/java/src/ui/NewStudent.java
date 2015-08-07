package src.ui;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import model.Student;
import util.DatabaseConnector;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class NewStudent extends Fragment {
    private EditText stuEditText;
    private EditText q1EditText;
    private EditText q2EditText;
    private EditText q3EditText;
    private EditText q4EditText;
    private EditText q5EditText;

    private Button saveRecordButton;
    private Student student = new Student();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View newStudent = inflater.inflate(R.layout.fragment_new_student,
                container, false);
        getReference(newStudent);

        saveRecordButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buildStudentFromInputs();
                savetoDataBase(); // save contact to the database
                System.out.println("-------STUDENT ID :   " + student.getStudentID());
                System.out.println("-------------DATA SAVED SUCCESS-----------");
                clearContent();
            } // end method onClick
        });

        return newStudent;

        //return contactsLayout;
    }
    private void clearContent(){
        stuEditText.setText("");
        q1EditText.setText("");
        q2EditText.setText("");
        q3EditText.setText("");
        q4EditText.setText("");
        q5EditText.setText("");
    }
    private void buildStudentFromInputs(){
        student.setStudentID(stuEditText.getText().toString());
        System.out.println("-------------------STUDENT ID:    " + student.getStudentID());
        student.setScore(q1EditText.getText().toString(),q2EditText.getText().toString(),q3EditText.getText().toString(),
                q4EditText.getText().toString(),q5EditText.getText().toString());
    }
    private void savetoDataBase()
    {
        // get DatabaseConnector to interact with the SQLite database
        DatabaseConnector databaseConnector = new DatabaseConnector(this.getActivity());
        int SID = Integer.parseInt(student.getStudentID());

        int score[] = new int[5];
        for(int i = 0; i < score.length; i++){

            score[i] = student.getScore(i).length() == 0 ? 0 : Integer.parseInt(student.getScore(i));
        }

        if (this.getActivity().getIntent().getExtras() == null)
        {
            // insert
            databaseConnector.insertInput(SID, score[0], score[1], score[2], score[3], score[4]);
        } // end if
        else
        {
            databaseConnector.updateInput(SID, score[0], score[1], score[2], score[3], score[4]);
        } // end else
    } //












    private void getReference(View view){
        stuEditText = (EditText) view.findViewById(R.id.stuEditText);
        q1EditText = (EditText) view.findViewById(R.id.q1EditText);
        q2EditText = (EditText) view.findViewById(R.id.q2EditText);
        q3EditText = (EditText) view.findViewById(R.id.q3EditText);
        q4EditText = (EditText) view.findViewById(R.id.q4EditText);
        q5EditText = (EditText) view.findViewById(R.id.q5EditText);

        saveRecordButton = (Button) view.findViewById(R.id.saveRecordButton);
    }

}
