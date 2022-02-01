package cooperation.qqreader.host.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import aqyg;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.smtt.sdk.WebView;
import cooperation.qqreader.host.ActivityWrapper;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ReaderWebViewBuilder
{
  private InnerAbsWebView a;
  protected Handler mJsHandler;
  protected ReaderWebView mReaderWebView;
  
  public ReaderWebViewBuilder(ActivityWrapper paramActivityWrapper)
  {
    this(paramActivityWrapper, null);
  }
  
  public ReaderWebViewBuilder(ActivityWrapper paramActivityWrapper, ReaderWebView paramReaderWebView)
  {
    paramActivityWrapper = (Activity)paramActivityWrapper.getContext();
    this.a = new InnerAbsWebView(paramActivityWrapper, paramActivityWrapper, (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    this.mReaderWebView = paramReaderWebView;
  }
  
  protected void addJavaScript(List<ReaderBaseWebViewPlugin> paramList) {}
  
  public ReaderWebView getWebView()
  {
    return this.mReaderWebView;
  }
  
  public void initWebView()
  {
    this.a.b(this.mReaderWebView);
    onWebViewReady();
  }
  
  public void onCreate()
  {
    this.a.onCreate();
  }
  
  public void onDestroy()
  {
    this.a.onDestroy();
  }
  
  protected void onPageFinished(ReaderWebView paramReaderWebView, String paramString) {}
  
  protected void onPageStarted(ReaderWebView paramReaderWebView, String paramString) {}
  
  public void onPause()
  {
    this.a.onPause();
  }
  
  protected void onReceivedError(ReaderWebView paramReaderWebView, String paramString1, int paramInt, String paramString2) {}
  
  public void onResume()
  {
    this.a.onResume();
  }
  
  protected void onWebViewReady() {}
  
  public void setHandler(Handler paramHandler)
  {
    this.mJsHandler = paramHandler;
  }
  
  class InnerAbsWebView
    extends aqyg
  {
    private boolean dnA;
    
    public InnerAbsWebView(Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
    {
      super(paramActivity, paramAppInterface);
    }
    
    void b(ReaderWebView paramReaderWebView)
    {
      this.mWebview = paramReaderWebView;
      super.buildBaseWebView(null);
    }
    
    public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
    {
      super.bindJavaScript(paramArrayList);
      if (this.dnA) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      ReaderWebViewBuilder.this.addJavaScript(localArrayList);
      paramArrayList.addAll(localArrayList);
      this.dnA = true;
    }
    
    public void onCreate()
    {
      super.doOnCreate(new Intent());
    }
    
    public void onDestroy()
    {
      super.doOnDestroy();
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      ReaderWebViewBuilder.this.onPageFinished((ReaderWebView)paramWebView, paramString);
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      ReaderWebViewBuilder.this.onPageStarted((ReaderWebView)paramWebView, paramString);
    }
    
    public void onPause()
    {
      super.doOnPause();
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      ReaderWebViewBuilder.this.onReceivedError((ReaderWebView)paramWebView, paramString2, paramInt, paramString1);
    }
    
    public void onResume()
    {
      super.doOnResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.webview.ReaderWebViewBuilder
 * JD-Core Version:    0.7.0.1
 */