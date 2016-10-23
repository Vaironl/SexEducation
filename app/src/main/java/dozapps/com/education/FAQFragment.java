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

        questions = new String[]{
                "How do female condoms work?",
                "How effective are condoms against HIV?",
                "How effective are condoms in preventing pregnancy?",
                "What is the failure rate of the most common prevention methods?"};
        answers = new String[]{"The female condom is a polyurethane (plastic) pouch that fits inside a woman’s vagina." +
                " It has a soft ring on each end. The outer ring stays on the outside of the vagina and partly covers the labia (lips)." +
                " The inner ring fits on the inside of the vagina, somewhat like a diaphragm, to hold the condom in place."
                , "When used consistently and effectively, condoms are highly effective in preventing transmission of HIV, " +
                "the virus that causes AIDS.",
                "Condoms are 98% effective in preventing pregnancy when used consistently and correctly.",
                "With consistent and correct use, male condoms have a 3% failure rate, the diaphragm has a 6% failure rate," +
                        " the pill (estrogen/progestin) has a 0.1% failure rate, and withdrawal has a 4% failure rate."};

        listView.setAdapter(new FAQAdapter(view.getContext(), questions, answers));


        return view;
    }
}
