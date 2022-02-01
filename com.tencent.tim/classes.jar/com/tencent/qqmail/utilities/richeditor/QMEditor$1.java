package com.tencent.qqmail.utilities.richeditor;

import Override;
import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.HttpAuthHandler;
import android.webkit.WebView;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.activity.webviewexplorer.BaseSafeWebViewClient;

class QMEditor$1
  extends BaseSafeWebViewClient
{
  QMEditor$1(QMEditor paramQMEditor) {}
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onSafePageFinished(WebView paramWebView, String paramString)
  {
    Log.v("baggio", "Finished loading URL: " + paramString);
  }
  
  public void onSafeReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    Log.v("baggio", "Error: " + paramString1 + "; " + paramString2);
  }
  
  public void onSafeReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    Log.v("baggio", "onReceivedHttpAuthRequest: " + paramString1 + "; " + paramString2);
  }
  
  public boolean shouldSafeOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Log.v("baggio", "Processing webview url click... : " + paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.richeditor.QMEditor.1
 * JD-Core Version:    0.7.0.1
 */