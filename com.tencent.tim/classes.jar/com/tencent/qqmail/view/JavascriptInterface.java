package com.tencent.qqmail.view;

import android.util.Log;
import com.tencent.qqmail.utilities.log.QMLog;

public abstract class JavascriptInterface
{
  @android.webkit.JavascriptInterface
  public void log(String paramString)
  {
    Log.v("webview_js_log", paramString);
  }
  
  @android.webkit.JavascriptInterface
  public void logFile(String paramString)
  {
    QMLog.log(4, "webview_js_log", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.JavascriptInterface
 * JD-Core Version:    0.7.0.1
 */