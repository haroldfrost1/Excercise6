package exercise6.id1195252.com.exercise6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SubjectManager mSubjectManager;
    private EditText mSubjectNameEditText;
    private EditText mSubjectNumberEditText;
    private RadioGroup mSubjectTypeRadioGroup;
    private DatePicker mDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSubjectManager = new SubjectManager(this);

        Button addSubjectBtn = (Button) findViewById(R.id.mainactivity_add_subject_btn);
        if (addSubjectBtn != null) {
            addSubjectBtn.setOnClickListener(this);
        }

        Button listSubjectBtn = (Button) findViewById(R.id.mainactivity_list_subject_btn);
        if (listSubjectBtn != null) {
            listSubjectBtn.setOnClickListener(this);
        }

        mDatePicker = (DatePicker) findViewById(R.id.mainactivity_date_picker);
        mSubjectNameEditText = (EditText) findViewById(R.id.mainactivity_subject_name);
        mSubjectNumberEditText = (EditText) findViewById(R.id.mainactivity_subject_number);
        mSubjectTypeRadioGroup = (RadioGroup) findViewById(R.id.mainactivity_radio_group);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.mainactivity_add_subject_btn:
                String subjectName = mSubjectNameEditText.getText().toString();
                String subjectNumber = mSubjectNumberEditText.getText().toString();

                Calendar calendar = Calendar.getInstance();
                calendar.set(mDatePicker.getYear(), mDatePicker.getMonth(), mDatePicker.getDayOfMonth());
                long startDate = calendar.getTimeInMillis();

                int isCore;
                if (mSubjectTypeRadioGroup.getCheckedRadioButtonId() == R.id.mainactivity_core_radio_button) {
                    isCore = 1;
                } else {
                    isCore = 0;
                }

                long rowId = mSubjectManager.add(new Subject(subjectName, subjectNumber, startDate, isCore));
                Toast.makeText(this, rowId != -1 ? "Subject successcully added!" : "Failed to add subject", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mainactivity_list_subject_btn:
                startActivity(new Intent(this, MySubjectListActivity.class));
                break;
        }
    }
}
