package dozapps.com.education;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by vaironl on 10/22/16.
 */
public class QuestionAdapter extends BaseAdapter {

    private ArrayList<String> questions, answers;
    Context context;
    private LayoutInflater inflater;

    public QuestionAdapter(Context context, ArrayList questions, ArrayList answers) {
        this.context = context;
        this.questions = questions;
        this.answers = answers;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return questions.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        TextView question, answer;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.faq_custom_view, null);
        holder.question = (TextView) rowView.findViewById(R.id.faqQuestion);
        holder.answer = (TextView) rowView.findViewById(R.id.faqAnswer);

        if (questions.size() > 0) {
            holder.question.setText(questions.get(position));
        }
        if (answers.size() > 0) {
            holder.answer.setText(answers.get(position));
        }

        holder.question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (holder.answer.getVisibility() == View.GONE) {
                    holder.answer.setVisibility(View.VISIBLE);
                } else {
                    holder.answer.setVisibility(View.GONE);
                }

            }
        });

        return rowView;

    }
}
