import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.mobileqq.jsbridge.JsBridge;
import com.tencent.mobileqq.richstatus.MovieDetailActivity;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.widget.ProtectedWebView;

public class ghj
  extends WebViewClient
{
  private ghj(MovieDetailActivity paramMovieDetailActivity) {}
  
  private boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = Uri.parse(paramString);
      String str = ((Uri)localObject).getQueryParameter("window");
      paramString = str;
      if (str == null)
      {
        localObject = ((Uri)localObject).getFragment();
        paramString = str;
        if (localObject != null)
        {
          int i = ((String)localObject).indexOf("window");
          paramString = str;
          if (i != -1) {
            paramString = ((String)localObject).substring("window=".length() + i);
          }
        }
      }
      if (!TextUtils.isEmpty(paramString)) {}
    }
    else
    {
      return false;
    }
    paramString = paramString.toLowerCase();
    if ((!"false".equals(paramString)) && (!"0".equals(paramString))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    MovieDetailActivity.a(this.a).setVisibility(8);
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    MovieDetailActivity.a(this.a).setVisibility(0);
    MovieDetailActivity.a(this.a).setVisibility(8);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    MovieDetailActivity.a(this.a).clearView();
    MovieDetailActivity.a(this.a).setVisibility(8);
    MovieDetailActivity.a(this.a).setVisibility(0);
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (MovieDetailActivity.a(this.a).a(paramWebView, paramString)) {
      return true;
    }
    if (a(paramString))
    {
      paramWebView = new Intent(this.a, MovieDetailActivity.class);
      paramWebView.putExtra("key_params_qq", paramString);
      paramWebView.putExtra("k_same_tuin", MovieDetailActivity.a(this.a));
      this.a.startActivity(paramWebView);
      return true;
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ghj
 * JD-Core Version:    0.7.0.1
 */