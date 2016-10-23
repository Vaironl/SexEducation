package dozapps.com.education;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by vaironl on 10/22/16.
 */
public class QuestionFragment extends Fragment {

    private ArrayList<String> questions, answers;
    private ListView listView;
    private SwipeRefreshLayout refreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.question_fragment, container, false);

        listView = (ListView) view.findViewById(R.id.questionListView);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.questionSwipeRefreshLayout);

        questions = new ArrayList<>();
        answers = new ArrayList<>();

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                getQuestions(view);
                refreshLayout.setRefreshing(false);
            }
        });


        return view;
    }

    private void getQuestions(View view)
    {

        questions.clear();
        answers.clear();



        try {
            String questionsBody = new GetQuestions().execute().get();
            JSONArray mainObject = new JSONArray(questionsBody);


            for (int i = 0; i < mainObject.length(); i++) {
                JSONObject object = mainObject.getJSONObject(i);
                questions.add(object.getString("question"));
                if(object.getString("answer").isEmpty())
                {
                    answers.add("No answer has been provided.");
                }
            }

            listView.setAdapter(new QuestionAdapter(view.getContext(), questions, answers));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public class GetQuestions extends AsyncTask<Void, Integer, String> {
        OkHttpClient client = new OkHttpClient();

        @Override
        protected String doInBackground(Void... params) {
            Request.Builder builder = new Request.Builder();
            builder.url("http://blooming-woodland-41263.herokuapp.com/contacts");
            Request request = builder.build();
            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
