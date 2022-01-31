package com.tencent.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Field;

public class ProtectedWebView
  extends WebView
{
  private boolean a;
  
  public ProtectedWebView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public ProtectedWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public ProtectedWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  public static Object a(String paramString1, String paramString2, Object paramObject)
  {
    try
    {
      paramString1 = Class.forName(paramString2).getDeclaredField(paramString1);
      paramString1.setAccessible(true);
      paramString1 = paramString1.get(paramObject);
      return paramString1;
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  private void b()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
    this.a = false;
  }
  
  protected void a() {}
  
  public boolean canGoBack()
  {
    if (!this.a) {
      return super.canGoBack();
    }
    return false;
  }
  
  public boolean canGoBackOrForward(int paramInt)
  {
    if (!this.a) {
      return super.canGoBackOrForward(paramInt);
    }
    return false;
  }
  
  public boolean canGoForward()
  {
    if (!this.a) {
      return super.canGoForward();
    }
    return false;
  }
  
  public void clearView()
  {
    if (!this.a) {
      super.clearView();
    }
  }
  
  public void destroy()
  {
    if (!this.a)
    {
      this.a = true;
      super.destroy();
    }
  }
  
  public void goBack()
  {
    if (!this.a) {
      super.goBack();
    }
  }
  
  public void goBackOrForward(int paramInt)
  {
    if (!this.a) {
      super.goBackOrForward(paramInt);
    }
  }
  
  public void loadUrl(String paramString)
  {
    if (!this.a) {
      super.loadUrl(paramString);
    }
  }
  
  public void postUrl(String paramString, byte[] paramArrayOfByte)
  {
    if (!this.a) {
      super.postUrl(paramString, paramArrayOfByte);
    }
  }
  
  public void reload()
  {
    if (!this.a) {
      super.reload();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if (!this.a) {
      super.setVisibility(paramInt);
    }
  }
  
  public void stopLoading()
  {
    if (!this.a) {
      super.stopLoading();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.ProtectedWebView
 * JD-Core Version:    0.7.0.1
 */