package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

class AppBrandPageContainer$5
  implements Runnable
{
  AppBrandPageContainer$5(AppBrandPageContainer paramAppBrandPageContainer, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    for (int i = -1;; i = -16777216)
    {
      try
      {
        boolean bool = "light".equals(new JSONObject(this.val$req.jsonParams).optString("textStyle", "light"));
        if (!bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Iterator localIterator;
          QMLog.e("minisdk-start-AppBrandPageContainer", this.val$req.event + " error.", localException);
          i = -1;
        }
        this.val$req.ok();
      }
      localIterator = AppBrandPageContainer.access$200(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((AppBrandPage)localIterator.next()).notifyChangePullDownRefreshStyle(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.5
 * JD-Core Version:    0.7.0.1
 */