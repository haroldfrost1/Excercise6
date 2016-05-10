package exercise6.id1195252.com.exercise6;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MySubjectListActivity extends AppCompatActivity{

    List<Subject> mSubjectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_subject_list);

         mSubjectList = new ArrayList<>();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        SubjectAdapter subjectAdapter = new SubjectAdapter(mSubjectList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(subjectAdapter);

        loadSubjectData();
    }

    private void loadSubjectData() {
        SubjectManager subjectManager = new SubjectManager(this);
        mSubjectList = subjectManager.getAllSubjects();
    }
}
