package dozapps.com.education;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by vaironl on 10/22/16.
 */
public class FAQAdapter extends BaseAdapter {

    private String[] questions, answers;
    Context context;
    private LayoutInflater inflater;

    public FAQAdapter(Context context, String[] questions, String[] answers) {
        this.context = context;
        this.questions = questions;
        this.answers = answers;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return questions.length;
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

        holder.question.setText(questions[position]);
        holder.answer.setText(answers[position]);
        final int pos = position;

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
