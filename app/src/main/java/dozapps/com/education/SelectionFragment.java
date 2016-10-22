package dozapps.com.education;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by vaironl on 10/22/16.
 */
public class SelectionFragment extends Fragment {

    private Button aboutButton, topicButton, FAQButton, whatElseButton, questionsButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.selection_fragment, container, false);

        aboutButton = (Button) view.findViewById(R.id.aboutButton);
        topicButton = (Button) view.findViewById(R.id.topicsButton);
        FAQButton = (Button) view.findViewById(R.id.faqButton);
        whatElseButton = (Button) view.findViewById(R.id.whatElseButton);
        questionsButton = (Button) view.findViewById(R.id.questionsButton);

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                AboutFragment fragment = new AboutFragment();
                fragmentTransaction.addToBackStack("about");
                fragmentTransaction.hide(SelectionFragment.this);
                fragmentTransaction.add(R.id.fragmentContainer, fragment);
                fragmentTransaction.commit();
            }
        });

        topicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                TopicsFragment fragment = new TopicsFragment();
                fragmentTransaction.addToBackStack("topics");
                fragmentTransaction.hide(SelectionFragment.this);
                fragmentTransaction.add(R.id.fragmentContainer, fragment);
                fragmentTransaction.commit();
            }
        });

        FAQButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FAQFragment fragment = new FAQFragment();
                fragmentTransaction.addToBackStack("topics");
                fragmentTransaction.hide(SelectionFragment.this);
                fragmentTransaction.add(R.id.fragmentContainer, fragment);
                fragmentTransaction.commit();
            }
        });

        whatElseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ElseFragment fragment = new ElseFragment();
                fragmentTransaction.addToBackStack("topics");
                fragmentTransaction.hide(SelectionFragment.this);
                fragmentTransaction.add(R.id.fragmentContainer, fragment);
                fragmentTransaction.commit();

            }
        });

        questionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                QuestionsFragments fragment = new QuestionsFragments();
                fragmentTransaction.addToBackStack("topics");
                fragmentTransaction.hide(SelectionFragment.this);
                fragmentTransaction.add(R.id.fragmentContainer, fragment);
                fragmentTransaction.commit();

            }
        });

        return view;
    }
}
