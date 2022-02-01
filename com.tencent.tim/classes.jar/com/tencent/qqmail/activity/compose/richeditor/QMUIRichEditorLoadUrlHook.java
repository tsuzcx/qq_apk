package com.tencent.qqmail.activity.compose.richeditor;

import android.os.Build.VERSION;
import android.os.Message;
import android.util.Log;
import android.webkit.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class QMUIRichEditorLoadUrlHook
{
  private static final int EXECUTE_JS = 194;
  private static final String TAG = "RichEditorLoadUrlHooK";
  boolean initFailed;
  Method sendMessageMethod;
  Object webViewCore;
  
  public static boolean shouldUseHookToLoad()
  {
    return Build.VERSION.SDK_INT < 19;
  }
  
  public void initReflection(WebView paramWebView)
  {
    Object localObject2 = WebView.class;
    localObject1 = paramWebView;
    for (;;)
    {
      try
      {
        Object localObject3 = WebView.class.getDeclaredField("mProvider");
        localObject1 = paramWebView;
        ((Field)localObject3).setAccessible(true);
        localObject1 = paramWebView;
        paramWebView = ((Field)localObject3).get(paramWebView);
        localObject1 = paramWebView;
        localObject3 = paramWebView.getClass();
        localObject1 = localObject3;
        localObject2 = localObject1;
      }
      catch (Throwable paramWebView)
      {
        paramWebView = (WebView)localObject1;
        continue;
      }
      try
      {
        localObject1 = ((Class)localObject2).getDeclaredField("mWebViewCore");
        ((Field)localObject1).setAccessible(true);
        this.webViewCore = ((Field)localObject1).get(paramWebView);
        if (this.webViewCore != null)
        {
          this.sendMessageMethod = this.webViewCore.getClass().getDeclaredMethod("sendMessage", new Class[] { Message.class });
          this.sendMessageMethod.setAccessible(true);
        }
        return;
      }
      catch (Throwable paramWebView)
      {
        this.initFailed = true;
        Log.e("RichEditorLoadUrlHooK", "BridgeHook failed to find the expected APIs.", paramWebView);
        return;
      }
    }
  }
  
  public void loadUrl(WebView paramWebView, String paramString)
  {
    if ((this.sendMessageMethod == null) && (!this.initFailed)) {
      initReflection(paramWebView);
    }
    if (this.sendMessageMethod != null) {
      paramWebView = Message.obtain(null, 194, paramString);
    }
    try
    {
      this.sendMessageMethod.invoke(this.webViewCore, new Object[] { paramWebView });
      return;
    }
    catch (Throwable paramWebView)
    {
      Log.e("RichEditorLoadUrlHooK", "Reflection message bridge failed.", paramWebView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.richeditor.QMUIRichEditorLoadUrlHook
 * JD-Core Version:    0.7.0.1
 */