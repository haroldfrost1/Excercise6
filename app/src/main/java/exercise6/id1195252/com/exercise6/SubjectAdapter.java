package exercise6.id1195252.com.exercise6;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by harold on 10/05/16.
 */
public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectListViewHolder>{

    private List<Subject> mSubjectsList;

    public SubjectAdapter(List<Subject> subjectsList){
        this.mSubjectsList = subjectsList;
    }

    @Override
    public SubjectListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_list_row,parent,false);
        return new SubjectListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SubjectAdapter.SubjectListViewHolder holder, int position) {
        Subject subject = mSubjectsList.get(position);
        holder.mSubjectTitle.setText(subject.getName());
        holder.mSubjectNumber.setText(subject.getNumber());
        holder.mSubjectType.setText("Core");
        holder.mSubjectStartDate.setText("Fake Date");
    }

    @Override
    public int getItemCount() {
        return mSubjectsList.size();
    }

    public class SubjectListViewHolder extends RecyclerView.ViewHolder{

        public TextView mSubjectTitle;
        public TextView mSubjectNumber;
        public TextView mSubjectStartDate;
        public TextView mSubjectType;

        public SubjectListViewHolder(View itemView) {
            super(itemView);
            mSubjectTitle = (TextView)itemView.findViewById(R.id.subject_row_title);
            mSubjectNumber = (TextView)itemView.findViewById(R.id.subject_row_subject_number);
            mSubjectStartDate = (TextView)itemView.findViewById(R.id.subject_row_date);
            mSubjectType = (TextView)itemView.findViewById(R.id.subject_row_subject_type);
        }
    }
}
