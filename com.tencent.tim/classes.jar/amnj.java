import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.search.fragment.searchresult.KDSearchResultFragment;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.smtt.sdk.WebView;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class amnj
  extends amnk
{
  public amnj(KDSearchResultFragment paramKDSearchResultFragment, Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView)
  {
    super(paramContext, paramActivity, paramAppInterface, paramTouchWebView);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if ((KDSearchResultFragment.a(this.a) != null) && (KDSearchResultFragment.a(this.a).getCurStatus() != 2)) {
      KDSearchResultFragment.a(this.a).enterStatus((byte)2);
    }
    this.a.a.setVisibility(8);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    if ((KDSearchResultFragment.a(this.a) != null) && (KDSearchResultFragment.a(this.a).getCurStatus() != 0)) {
      KDSearchResultFragment.a(this.a).enterStatus((byte)0);
    }
    this.a.a.setVisibility(0);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    int i = 0;
    Log.d("KDSearchResultFragment", "shouldOverrideUrlLoading: ");
    Object localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = paramString.split("\\?");
      if ((localObject1.length == 2) && (!TextUtils.isEmpty(localObject1[1])))
      {
        localObject1 = localObject1[1].split("#");
        if ((localObject1.length == 2) && (!TextUtils.isEmpty(localObject1[0])))
        {
          localObject1 = localObject1[0].split("=");
          if (localObject1.length % 2 != 0) {}
        }
      }
    }
    for (;;)
    {
      if (i + 1 < localObject1.length)
      {
        if (("p".equals(localObject1[i])) && (!TextUtils.isEmpty(localObject1[(i + 1)]))) {
          try
          {
            Object localObject2 = new JSONObject(URLDecoder.decode(localObject1[(i + 1)]));
            if (!((JSONObject)localObject2).has("url")) {
              break label240;
            }
            String str = ((JSONObject)localObject2).getString("url");
            if (!amxk.oO(str)) {
              break label240;
            }
            localObject2 = amxk.nj(str);
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label240;
            }
            localObject1 = aurr.addParameter(str, "searchbox", "native");
            KDSearchResultFragment.a(this.a).setText((CharSequence)localObject2);
            KDSearchResultFragment.a(this.a, (String)localObject2);
            this.mWebview.loadUrl((String)localObject1);
            return true;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
      }
      else {
        return super.shouldOverrideUrlLoading(paramWebView, paramString);
      }
      label240:
      i += 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amnj
 * JD-Core Version:    0.7.0.1
 */