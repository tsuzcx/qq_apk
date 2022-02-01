package com.tencent.qqmini.sdk.ui;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class AddPhoneNumberFragment$9$1$1
  implements AsyncResult
{
  AddPhoneNumberFragment$9$1$1(AddPhoneNumberFragment.9.1 param1) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.d("AddPhoneNumberFragment", "addPhoneNumber isSuccess=" + paramBoolean + "; result=" + paramJSONObject);
    if (paramBoolean)
    {
      AppBrandTask.runTaskOnUiThread(new AddPhoneNumberFragment.9.1.1.1(this, paramJSONObject));
      return;
    }
    AppBrandTask.runTaskOnUiThread(new AddPhoneNumberFragment.9.1.1.2(this, paramJSONObject.optString("errMsg")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.9.1.1
 * JD-Core Version:    0.7.0.1
 */