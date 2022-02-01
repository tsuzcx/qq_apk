package moai.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * 屏蔽一下WebView不安全特性
 */
public class SafeWebView extends WebView {

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SafeWebView(Context context, AttributeSet attrs, int defStyleAttr,
			int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		init();
	}

	public SafeWebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public SafeWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public SafeWebView(Context context) {
		super(context);
		init();
	}

	private void init() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			removeJavascriptInterface("searchBoxJavaBridge_");
		}

		//getSettings().setJavaScriptEnabled(true);
	}
}
