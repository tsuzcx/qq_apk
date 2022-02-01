package cooperation.comic.webbundle;

import aeif;
import aemz;
import aemz.a;
import android.content.Context;
import android.util.AttributeSet;
import avem;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.webbundle.sdk.IWebBundleWebView;
import com.tencent.webbundle.sdk.IWebBundleWebView.OnPageFinishedListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class WebBundleWebView
  extends TouchWebView
  implements IWebBundleWebView
{
  public WebBundleWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WebBundleWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean canGoBack()
  {
    Object localObject = copyBackForwardList();
    if ((localObject != null) && (((WebBackForwardList)localObject).getSize() > 0))
    {
      localObject = ((WebBackForwardList)localObject).getItemAtIndex(0);
      if (localObject != null)
      {
        localObject = ((WebHistoryItem)localObject).getUrl();
        aemz localaemz = (aemz)aeif.a().o(534);
        if ((localaemz != null) && (localaemz.a.preloadUrl.equals(localObject))) {
          return super.canGoBackOrForward(-2);
        }
      }
    }
    return super.canGoBack();
  }
  
  public void dispatchJsEvent(@NotNull String paramString, @NotNull JSONObject paramJSONObject1, @Nullable JSONObject paramJSONObject2)
  {
    callJs(WebViewPlugin.toJsScript(paramString, paramJSONObject1, paramJSONObject2));
  }
  
  public void enableJavaScript(boolean paramBoolean)
  {
    getSettings().setJavaScriptEnabled(paramBoolean);
  }
  
  public void setOnPageFinishedListener(@NotNull IWebBundleWebView.OnPageFinishedListener paramOnPageFinishedListener)
  {
    setWebViewClient(new avem(this, paramOnPageFinishedListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.comic.webbundle.WebBundleWebView
 * JD-Core Version:    0.7.0.1
 */