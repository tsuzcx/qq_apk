package com.tencent.qqmini.sdk.ui;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class AddPhoneNumberFragment$3$1
  implements AsyncResult
{
  AddPhoneNumberFragment$3$1(AddPhoneNumberFragment.3 param3) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.d("AddPhoneNumberFragment", "sendSmsCodeRequest isSuccess=" + paramBoolean + "; result=" + paramJSONObject);
    if (paramBoolean)
    {
      int i = paramJSONObject.optInt("intervalTime", 60);
      AddPhoneNumberFragment.access$300(this.this$1.this$0, i);
      return;
    }
    AppBrandTask.runTaskOnUiThread(new AddPhoneNumberFragment.3.1.1(this, paramJSONObject.optString("message", "")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.3.1
 * JD-Core Version:    0.7.0.1
 */