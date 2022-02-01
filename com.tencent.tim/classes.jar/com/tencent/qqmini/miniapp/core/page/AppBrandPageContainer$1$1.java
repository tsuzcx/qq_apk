package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import org.json.JSONObject;

class AppBrandPageContainer$1$1
  implements Runnable
{
  AppBrandPageContainer$1$1(AppBrandPageContainer.1 param1, int paramInt) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("height", (int)(this.val$realKeyboardHeight / DisplayUtil.getDensity(AppBrandPageContainer.access$000(this.this$1.this$0).getContext())));
      localJSONObject.put("inputId", this.this$1.this$0.getCurShowingInputId());
      if (this.this$1.this$0.mEventListener != null)
      {
        QMLog.d("minisdk-start-AppBrandPageContainer", "onKeyboardHeightChange : " + localJSONObject.toString());
        this.this$1.this$0.mEventListener.onWebViewEvent("onKeyboardHeightChange", localJSONObject.toString(), this.this$1.this$0.getShowingPageWebViewId());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start-AppBrandPageContainer", "KeyboardObserver error, ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.1.1
 * JD-Core Version:    0.7.0.1
 */