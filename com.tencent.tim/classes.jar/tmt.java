import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public class tmt
  extends aqyg
  implements aqza
{
  protected Intent intent;
  
  public tmt(Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    this.intent = paramIntent;
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    this.mWebview = paramTouchWebView;
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    super.bindJavaScript(paramArrayList);
  }
  
  public void buildBottomBar() {}
  
  public void buildContentView(Bundle paramBundle) {}
  
  public void buildData() {}
  
  public void buildLayout() {}
  
  public void buildTitleBar() {}
  
  public final void buildWebView(AppInterface paramAppInterface)
  {
    super.buildBaseWebView(paramAppInterface);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.doOnCreate(this.intent);
  }
  
  public void onDestroy()
  {
    try
    {
      super.doOnDestroy();
      return;
    }
    catch (Exception localException)
    {
      tkw.e("GdtWebViewBuilder", "getVideoComponent error", localException);
    }
  }
  
  public void onPause()
  {
    super.doOnPause();
  }
  
  public void onResume()
  {
    super.doOnResume();
  }
  
  public void preInitWebviewPlugin()
  {
    super.preInitPluginEngine();
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("jsbridge://"))) {
      return true;
    }
    paramWebView.loadUrl(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tmt
 * JD-Core Version:    0.7.0.1
 */