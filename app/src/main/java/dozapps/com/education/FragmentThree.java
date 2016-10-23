package dozapps.com.education;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class FragmentThree extends Fragment {

    private WebView webView;
    private ImageView placeholder;

    public FragmentThree() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_three, container, false);

        webView = (WebView) view.findViewById(R.id.fragmentthreeWebView);
        placeholder = (ImageView) view.findViewById(R.id.placeholderThree);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://spreadingtheknowledge.github.io/tipsandguidelines.html");
        webView.setWebViewClient(new WebViewClient() {
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
