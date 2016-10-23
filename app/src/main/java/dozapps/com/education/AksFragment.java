package dozapps.com.education;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by vaironl on 10/22/16.
 */
public class AksFragment extends Fragment {


    private EditText questionEditText;
    private Button submitButton;
    private OkHttpClient client;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ask_fragment, container, false);

        questionEditText = (EditText) view.findViewById(R.id.questionEditText);
        submitButton = (Button) view.findViewById(R.id.submitButton);


        client = new OkHttpClient();


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (questionEditText.getText().toString().isEmpty() || questionEditText.toString().length() < 14) {

                    Toast.makeText(v.getContext(), "Please enter a valid question.", Toast.LENGTH_LONG).show();

                } else {

                    String question = questionEditText.getText().toString();

                    new PostOperation().execute(question);
                }
            }
        });
        return view;
    }


    private class PostOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... question) {

            final MediaType MEDIA_TYPE_MARKDOWN
                    = MediaType.parse("application/json; charset=utf-8");
            String postBody = String.format("{`user`:`Anonymous`,`question`:`%s`}", question).replace("`", "\"");
            Log.i("ASKFRAGMENT", "question: " + question);


            Request request = new Request.Builder().url("http://blooming-woodland-41263.herokuapp.com/contacts")
                    .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody)).build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (!response.isSuccessful()) {
                        throw new IOException("Exception: " + response);
                    }
                }
            });

            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }
}
