package com.tencent.qqmail.utilities.ui;

import Override;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.InlineImage.timing.ReadMailTimer;
import com.tencent.qqmail.utilities.log.QMLog;

class QMScaleWebViewController$5
  extends WebChromeClient
{
  QMScaleWebViewController$5(QMScaleWebViewController paramQMScaleWebViewController) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    String str1 = paramConsoleMessage.message();
    int i = paramConsoleMessage.lineNumber();
    String str2 = paramConsoleMessage.sourceId();
    QMLog.log(4, "webview_js_log", String.format("message: %s sourceID: %s lineNumber:", new Object[] { str1, str2 }) + i);
    return super.onConsoleMessage(paramConsoleMessage);
  }
  
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
    if (paramInt == 100)
    {
      QMLog.log(4, "QMScaleWebViewCtrlr", "Finish load mail progress");
      if ((paramWebView != null) && (paramWebView.getSettings() != null)) {
        paramWebView.getSettings().setLoadsImagesAutomatically(true);
      }
      ReadMailTimer.updateLastTime();
    }
    super.onProgressChanged(paramWebView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMScaleWebViewController.5
 * JD-Core Version:    0.7.0.1
 */