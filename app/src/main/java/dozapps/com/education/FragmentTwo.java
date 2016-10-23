package dozapps.com.education;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

/**
 * Created by vaironl on 10/21/16.
 */
public class FragmentTwo extends Fragment {

    private WebView webView;
    private ImageView placeholder;

    public FragmentTwo() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_two, container, false);

        webView = (WebView) view.findViewById(R.id.fragmenttwoWebView);
        placeholder = (ImageView) view.findViewById(R.id.placeholderTwo);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://10.0.2.2:8888/healthapp/stds.html");
        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                placeholder.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }
}
