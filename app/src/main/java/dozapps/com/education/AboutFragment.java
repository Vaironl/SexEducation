package dozapps.com.education;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by vaironl on 10/22/16.
 */
public class AboutFragment extends Fragment {

    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_fragment, container, false);

        webView = (WebView) view.findViewById(R.id.aboutWebView);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl("http://stackoverflow.com/questions/9589365/splash-screen-while-loading-a-url-in-a-webview-in-android-app");
        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return true;
            }
        });
        return view;
    }
}
