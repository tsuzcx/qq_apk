package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class AppBrandPageContainer$1$2
  implements Runnable
{
  AppBrandPageContainer$1$2(AppBrandPageContainer.1 param1) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("height", 0);
      localJSONObject.put("inputId", this.this$1.this$0.getCurShowingInputId());
      if (this.this$1.this$0.mEventListener != null) {
        this.this$1.this$0.mEventListener.onWebViewEvent("onKeyboardHeightChange", localJSONObject.toString(), this.this$1.this$0.getShowingPageWebViewId());
      }
      this.this$1.this$0.resetCurShowingInputId();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("minisdk-start-AppBrandPageContainer", "KeyboardObserver error, ", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.1.2
 * JD-Core Version:    0.7.0.1
 */