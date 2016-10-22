package dozapps.com.education;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;

/**
 * Created by vaironl on 10/22/16.
 */
public class FAQFragment extends Fragment {

    private ListView listView;
    private String questions[], answers[];

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.faq_fragment, container, false);

        listView = (ListView) view.findViewById(R.id.faqListView);
//        WHEN THE USER TAPS ON A QUESTION THE ANSWER SHOULD OPEN

        questions = new String[]{"Question 1", "Question 2", "Question 3"};
        answers = new String[]{"Answer 1", "Answer 2", "Answer 3"};

        listView.setAdapter(new FAQAdapter(view.getContext(), questions, answers));


        return view;
    }
}
