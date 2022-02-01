import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
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
import java.util.HashMap;
import java.util.List;

public class aocb
{
  private static List<TouchWebView> GR = new ArrayList();
  private static volatile aocb a;
  private static final byte[] lock = new byte[0];
  private static int maxSize = 1;
  public static HashMap<String, Integer> nL;
  
  private aocb()
  {
    GR = new ArrayList();
  }
  
  public static aocb a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aocb();
      }
      return a;
    }
    finally {}
  }
  
  /* Error */
  public static void b(String paramString, TouchWebView paramTouchWebView)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 43	aocb:nL	Ljava/util/HashMap;
    //   6: ifnonnull +13 -> 19
    //   9: new 45	java/util/HashMap
    //   12: dup
    //   13: invokespecial 46	java/util/HashMap:<init>	()V
    //   16: putstatic 43	aocb:nL	Ljava/util/HashMap;
    //   19: aload_0
    //   20: ifnull +30 -> 50
    //   23: getstatic 43	aocb:nL	Ljava/util/HashMap;
    //   26: aload_0
    //   27: invokevirtual 50	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 52	java/lang/Integer
    //   33: astore_3
    //   34: aload_3
    //   35: ifnonnull +24 -> 59
    //   38: getstatic 43	aocb:nL	Ljava/util/HashMap;
    //   41: aload_0
    //   42: iconst_1
    //   43: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: invokevirtual 60	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   49: pop
    //   50: aload_0
    //   51: aload_1
    //   52: invokestatic 64	aiiy:a	(Ljava/lang/String;Lcom/tencent/biz/ui/TouchWebView;)V
    //   55: ldc 2
    //   57: monitorexit
    //   58: return
    //   59: aload_3
    //   60: invokevirtual 68	java/lang/Integer:intValue	()I
    //   63: istore_2
    //   64: getstatic 43	aocb:nL	Ljava/util/HashMap;
    //   67: aload_0
    //   68: iload_2
    //   69: iconst_1
    //   70: iadd
    //   71: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: invokevirtual 60	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   77: pop
    //   78: goto -28 -> 50
    //   81: astore_0
    //   82: ldc 2
    //   84: monitorexit
    //   85: aload_0
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramString	String
    //   0	87	1	paramTouchWebView	TouchWebView
    //   63	8	2	i	int
    //   33	27	3	localInteger	Integer
    // Exception table:
    //   from	to	target	type
    //   3	19	81	finally
    //   23	34	81	finally
    //   38	50	81	finally
    //   50	55	81	finally
    //   59	78	81	finally
  }
  
  public TouchWebView a(Context paramContext)
  {
    byte[] arrayOfByte = lock;
    TouchWebView localTouchWebView = null;
    try
    {
      QLog.e("TenDocWebViewPool", 1, "tendocpreload getWebView =  " + GR.size());
      if (GR.size() > 0)
      {
        localTouchWebView = (TouchWebView)GR.get(0);
        GR.remove(0);
        ViewGroup localViewGroup = (ViewGroup)localTouchWebView.getParent();
        if (localViewGroup != null) {
          localViewGroup.removeView(localTouchWebView);
        }
        ((MutableContextWrapper)localTouchWebView.getContext()).setBaseContext(paramContext);
      }
      return localTouchWebView;
    }
    finally {}
  }
  
  public void c(TouchWebView paramTouchWebView)
  {
    QLog.i("TenDocWebViewPool", 1, "tendocpreload recycleWebView  ");
    if (paramTouchWebView != null)
    {
      ??? = (ViewGroup)paramTouchWebView.getParent();
      if (??? != null) {
        ((ViewGroup)???).removeView(paramTouchWebView);
      }
      synchronized (lock)
      {
        if ((paramTouchWebView instanceof SwiftReuseTouchWebView))
        {
          Context localContext = paramTouchWebView.getContext();
          if ((localContext instanceof MutableContextWrapper)) {
            ((MutableContextWrapper)localContext).setBaseContext(BaseApplicationImpl.sApplication);
          }
          if (GR.size() < maxSize)
          {
            QLog.i("TenDocWebViewPool", 1, "tendocpreload recycleWebView  ");
            GR.add(paramTouchWebView);
          }
        }
        else
        {
          return;
        }
        paramTouchWebView.destroy();
      }
    }
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
        ((TouchWebView)localObject).setWebViewClient(new aocb.b());
        ((TouchWebView)localObject).setWebChromeClient(new aocb.a());
        GR.add(localObject);
      }
      aoca.cka = paramString;
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
        localTouchWebView.setWebViewClient(new aocb.b());
        localTouchWebView.setWebChromeClient(new aocb.a());
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
 * Qualified Name:     aocb
 * JD-Core Version:    0.7.0.1
 */