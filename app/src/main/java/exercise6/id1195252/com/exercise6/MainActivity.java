package exercise6.id1195252.com.exercise6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SubjectManager mSubjectManager;
    private EditText mSubjectNameEditText;
    private EditText mSubjectNumberEditText;
    private DatePicker mDatePicker;
    private RadioGroup mSubjectTypeRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSubjectManager = new SubjectManager(this);
        mSubjectNameEditText = (EditText)findViewById(R.id.mainactivity_subject_name);
        mSubjectNumberEditText = (EditText)findViewById(R.id.mainactivity_subject_number);
        mDatePicker = (DatePicker)findViewById(R.id.mainactivity_date_picker);
        mSubjectTypeRadioGroup = (RadioGroup)findViewById(R.id.mainactivity_radio_group);

        Button addSubjectBtn = (Button)findViewById(R.id.mainactivity_add_subject_btn);
        Button listSubjectBtn = (Button)findViewById(R.id.mainactivity_list_subject_btn);

        if (addSubjectBtn != null) addSubjectBtn.setOnClickListener(this);
        if (listSubjectBtn != null) listSubjectBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.mainactivity_add_subject_btn:
                mSubjectManager.addSubject(new Subject(mSubjectNameEditText.getText().toString(), mSubjectNumberEditText.getText().toString(), mDatePicker.getDrawingTime(), mSubjectTypeRadioGroup.indexOfChild(findViewById(mSubjectTypeRadioGroup.getCheckedRadioButtonId()))));
                break;
            case R.id.mainactivity_list_subject_btn:
                break;
        }
    }
}
