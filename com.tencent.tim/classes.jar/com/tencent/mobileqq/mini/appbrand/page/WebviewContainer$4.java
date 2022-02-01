package com.tencent.mobileqq.mini.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class WebviewContainer$4
  implements View.OnClickListener
{
  WebviewContainer$4(WebviewContainer paramWebviewContainer, String paramString) {}
  
  public void onClick(View paramView)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", this.val$data);
      this.this$0.pageWebview.evaluateSubcribeJS("onImageViewClick", localJSONObject.toString(), this.this$0.pageWebview.pageWebviewId);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("WebViewContainer", 1, "evaluateSubcribeJS error.", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.WebviewContainer.4
 * JD-Core Version:    0.7.0.1
 */