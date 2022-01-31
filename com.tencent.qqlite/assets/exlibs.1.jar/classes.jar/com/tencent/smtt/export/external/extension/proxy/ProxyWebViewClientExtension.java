package com.tencent.smtt.export.external.extension.proxy;

import android.os.Bundle;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;

public abstract class ProxyWebViewClientExtension
  implements IX5WebViewClientExtension
{
  protected IX5WebViewClientExtension mWebViewClientExt;
  
  public void handlePluginTag(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.handlePluginTag(paramString1, paramString2, paramBoolean, paramString3);
    }
  }
  
  public void hideAddressBar()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.hideAddressBar();
    }
  }
  
  public void onDoubleTapStart()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onDoubleTapStart();
    }
  }
  
  public void onFlingScrollBegin(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onFlingScrollBegin(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onFlingScrollEnd()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onFlingScrollEnd();
    }
  }
  
  public void onHideListBox()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onHideListBox();
    }
  }
  
  public void onHistoryItemChanged()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onHistoryItemChanged();
    }
  }
  
  public void onInputBoxTextChanged(IX5WebViewExtension paramIX5WebViewExtension, String paramString)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onInputBoxTextChanged(paramIX5WebViewExtension, paramString);
    }
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    if (this.mWebViewClientExt != null) {
      return this.mWebViewClientExt.onMiscCallBack(paramString, paramBundle);
    }
    return null;
  }
  
  public void onMissingPluginClicked(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onMissingPluginClicked(paramString1, paramString2, paramString3, paramInt);
    }
  }
  
  public void onNativeCrashReport(int paramInt, String paramString)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onNativeCrashReport(paramInt, paramString);
    }
  }
  
  public void onPinchToZoomStart()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onPinchToZoomStart();
    }
  }
  
  public void onPreReadFinished()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onPreReadFinished();
    }
  }
  
  public void onPromptScaleSaved()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onPromptScaleSaved();
    }
  }
  
  public void onReportAdFilterInfo(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onReportAdFilterInfo(paramInt1, paramInt2, paramString, paramBoolean);
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onSetButtonStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onSetButtonStatus(paramBoolean1, paramBoolean2);
    }
  }
  
  public void onShowListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onShowListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramInt);
    }
  }
  
  public void onShowMutilListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onShowMutilListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    }
  }
  
  public void onSlidingTitleOffScreen(int paramInt1, int paramInt2)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onSlidingTitleOffScreen(paramInt1, paramInt2);
    }
  }
  
  public void onSoftKeyBoardHide(int paramInt)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onSoftKeyBoardHide(paramInt);
    }
  }
  
  public void onSoftKeyBoardShow()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onSoftKeyBoardShow();
    }
  }
  
  public void onTransitionToCommitted()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onTransitionToCommitted();
    }
  }
  
  public void onUploadProgressChange(int paramInt1, int paramInt2, String paramString)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onUploadProgressChange(paramInt1, paramInt2, paramString);
    }
  }
  
  public void onUploadProgressStart(int paramInt)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onUploadProgressStart(paramInt);
    }
  }
  
  public void onUrlChange(String paramString1, String paramString2)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onUrlChange(paramString1, paramString2);
    }
  }
  
  public boolean preShouldOverrideUrlLoading(IX5WebViewExtension paramIX5WebViewExtension, String paramString)
  {
    if (this.mWebViewClientExt != null) {
      return this.mWebViewClientExt.preShouldOverrideUrlLoading(paramIX5WebViewExtension, paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension
 * JD-Core Version:    0.7.0.1
 */