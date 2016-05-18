package exercise6.id1195252.com.exercise6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MySubjectListActivity extends AppCompatActivity {

    private ArrayList<Subject> mSubjectsList;
    private SubjectAdapter mSubjectAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_subject_list);

//        mSubjectsList = new ArrayList<>();
        // Why?
        loadSubjectsList();

        RecyclerView subjectsListRecyclerView = (RecyclerView) findViewById(R.id.mysubjectlistactivity_recycler_view);

        mSubjectAdapter = new SubjectAdapter(this, mSubjectsList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        if (subjectsListRecyclerView != null) {
            subjectsListRecyclerView.setLayoutManager(layoutManager);
            subjectsListRecyclerView.setAdapter(mSubjectAdapter);
        }


    }

    /**
     * Load subject list from database
     */
    private void loadSubjectsList() {
        SubjectManager subjectManager = new SubjectManager(this);
        mSubjectsList = subjectManager.getSubjectsList();
       // mSubjectAdapter.notifyDataSetChanged();

    }
}
