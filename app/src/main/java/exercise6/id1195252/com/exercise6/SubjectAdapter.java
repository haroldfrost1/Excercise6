package exercise6.id1195252.com.exercise6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by harold on 16/5/16.
 */
public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectsViewHolder> {

    private LayoutInflater mInflater;
    private ArrayList<Subject> mSubjectsList;

    public SubjectAdapter(Context context, ArrayList<Subject> mSubjectsList) {
        this.mSubjectsList = mSubjectsList;
        this.mInflater = LayoutInflater.from(context);
    }

    /**
     * Called when RecyclerView needs a new {@link SubjectsViewHolder} of the given type to represent
     * an item.
     */
    @Override
    public SubjectsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.subject_adapter_item, parent, false);

        return new SubjectsViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link SubjectsViewHolder#itemView} to reflect the item at the given
     * position.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(SubjectsViewHolder holder, int position) {
        Subject subject = mSubjectsList.get(position);
        holder.mSubjectNameTextView.setText(subject.getName());
        holder.mSubjectNumberTextView.setText(subject.getNumber());
        holder.mTypeTextView.setText(subject.getType());
        holder.mStartDateTextView.setText(subject.getStartDateToString());
    }

    /**
     * Returns the total number of items in the data set hold by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mSubjectsList.size();
    }

    protected class SubjectsViewHolder extends RecyclerView.ViewHolder {

        public TextView mSubjectNameTextView;
        public TextView mSubjectNumberTextView;
        public TextView mTypeTextView;
        public TextView mStartDateTextView;

        public SubjectsViewHolder(View itemView) {
            super(itemView);
            mSubjectNameTextView = (TextView) itemView.findViewById(R.id.subject_adapter_item_subject_name);
            mSubjectNumberTextView = (TextView) itemView.findViewById(R.id.subject_adapter_item_subject_number);
            mTypeTextView = (TextView) itemView.findViewById(R.id.subject_adapter_item_subject_type);
            mStartDateTextView = (TextView) itemView.findViewById(R.id.subject_adapter_item_start_date);
        }
    }
}
