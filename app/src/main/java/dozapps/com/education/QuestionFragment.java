package dozapps.com.education;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by vaironl on 10/22/16.
 */
public class QuestionFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.question_fragment, container, false);

        try {
            String questionsBody = new GetQuestions().execute().get();
            JSONObject mainObject = new JSONObject(questionsBody);


            Toast.makeText(view.getContext(),"Object: " + mainObject.length(), Toast.LENGTH_LONG).show();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return view;
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
