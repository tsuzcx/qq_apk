package com.tencent.mobileqq.mini.mainpage;

import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class AddPhoneNumberFragment$8$1$1
  implements MiniAppCmdInterface
{
  AddPhoneNumberFragment$8$1$1(AddPhoneNumberFragment.8.1 param1) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("AddPhoneNumberFragment", 1, "addPhoneNumber isSuc : " + paramBoolean + "; " + paramJSONObject);
    if (!paramBoolean)
    {
      AppBrandTask.runTaskOnUiThread(new AddPhoneNumberFragment.8.1.1.1(this, paramJSONObject.optString("errMsg")));
      return;
    }
    AppBrandTask.runTaskOnUiThread(new AddPhoneNumberFragment.8.1.1.2(this, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.8.1.1
 * JD-Core Version:    0.7.0.1
 */