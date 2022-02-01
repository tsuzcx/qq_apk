package com.tencent.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.smtt.sdk.WebView;

public class ProtectedWebView
  extends WebView
{
  private boolean mIsDestroyed;
  
  public ProtectedWebView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ProtectedWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ProtectedWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
    this.mIsDestroyed = false;
  }
  
  public boolean canGoBack()
  {
    if (!this.mIsDestroyed) {
      return super.canGoBack();
    }
    return false;
  }
  
  public boolean canGoBackOrForward(int paramInt)
  {
    if (!this.mIsDestroyed) {
      return super.canGoBackOrForward(paramInt);
    }
    return false;
  }
  
  public boolean canGoForward()
  {
    if (!this.mIsDestroyed) {
      return super.canGoForward();
    }
    return false;
  }
  
  public void clearView()
  {
    if (!this.mIsDestroyed) {
      super.clearView();
    }
  }
  
  public void destroy()
  {
    if (!this.mIsDestroyed)
    {
      this.mIsDestroyed = true;
      super.destroy();
    }
  }
  
  public void goBack()
  {
    if (!this.mIsDestroyed) {
      super.goBack();
    }
  }
  
  public void goBackOrForward(int paramInt)
  {
    if (!this.mIsDestroyed) {
      super.goBackOrForward(paramInt);
    }
  }
  
  public void loadUrl(String paramString)
  {
    if (!this.mIsDestroyed) {
      super.loadUrl(paramString);
    }
  }
  
  public void postUrl(String paramString, byte[] paramArrayOfByte)
  {
    if (!this.mIsDestroyed) {
      super.postUrl(paramString, paramArrayOfByte);
    }
  }
  
  public void reload()
  {
    if (!this.mIsDestroyed) {
      super.reload();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if (!this.mIsDestroyed) {
      super.setVisibility(paramInt);
    }
  }
  
  public void stopLoading()
  {
    if (!this.mIsDestroyed) {
      super.stopLoading();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.ProtectedWebView
 * JD-Core Version:    0.7.0.1
 */