package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.ValueCallback;

class PageWebviewContainer$6$1
  implements ValueCallback<String>
{
  PageWebviewContainer$6$1(PageWebviewContainer.6 param6) {}
  
  public void onReceiveValue(String paramString)
  {
    QMLog.d("PageWebviewContainer", "openFileReader callback  : " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.6.1
 * JD-Core Version:    0.7.0.1
 */