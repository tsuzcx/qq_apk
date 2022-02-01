import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.util.ArrayList;
import java.util.List;

public class aulv
{
  private static List<TouchWebView> GR = new ArrayList();
  private static volatile aulv a;
  private static final byte[] lock = new byte[0];
  private static int maxSize = 1;
  
  private aulv()
  {
    GR = new ArrayList();
  }
  
  public static aulv a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aulv();
      }
      return a;
    }
    finally {}
  }
  
  public List<TouchWebView> gs()
  {
    return GR;
  }
  
  public void init(String paramString)
  {
    QLog.i("TenDocWebViewPool", 1, "tendocpreload init" + isAvailable());
    synchronized (lock)
    {
      if (!isAvailable())
      {
        Object localObject = new Bundle();
        ((Bundle)localObject).putInt("_accelerator_mode_", 3);
        if (SwiftReuseTouchWebView.sPoolSize == 0) {
          arcn.a().dD((Bundle)localObject);
        }
        QLog.i("TenDocWebViewPool", 1, "init");
        localObject = SwiftReuseTouchWebView.a(BaseApplicationImpl.sApplication);
        ((TouchWebView)localObject).setWebViewClient(new aulv.b());
        ((TouchWebView)localObject).setWebChromeClient(new aulv.a());
        GR.add(localObject);
      }
      aulu.cka = paramString;
      return;
    }
  }
  
  public boolean isAvailable()
  {
    return GR.size() > 0;
  }
  
  public boolean pR(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (isAvailable())
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        TouchWebView localTouchWebView = (TouchWebView)gs().get(0);
        localTouchWebView.setWebViewClient(new aulv.b());
        localTouchWebView.setWebChromeClient(new aulv.a());
        localTouchWebView.loadUrlOriginal(paramString);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  class a
    extends WebChromeClient
  {
    a() {}
    
    @Override
    public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
    {
      if (JsBridgeController.getInstance().shouldIntercept(paramWebView, paramString2, paramString1, paramJsPromptResult)) {
        return true;
      }
      return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
    }
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
      super.onProgressChanged(paramWebView, paramInt);
      QLog.i("TenDocWebViewPool", 1, "tendocpreload onProgressChanged = " + paramInt);
    }
  }
  
  class b
    extends WebViewClient
  {
    b() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      QLog.i("TenDocWebViewPool", 1, "tendocpreload onPageFinished = " + paramString);
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      JsInjector.getInstance().onPageStarted(paramWebView);
      QLog.i("TenDocWebViewPool", 1, "tendocpreload onPageStarted = " + paramString);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      return super.shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aulv
 * JD-Core Version:    0.7.0.1
 */