package com.tencent.mobileqq.mini.mainpage;

import android.content.Intent;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class PhoneNumberManagementFragment$1
  implements MiniAppController.ActivityResultListener
{
  PhoneNumberManagementFragment$1(PhoneNumberManagementFragment paramPhoneNumberManagementFragment) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d("PhoneNumberManagementFragment", 2, "doOnActivityResult : " + paramInt1);
    if (paramInt1 == 1090)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {}
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("phoneType", 1);
          localJSONObject.put("purePhoneNumber", paramIntent.getStringExtra("phoneNumber"));
          localJSONObject.put("countryCode", "+86");
          localJSONObject.put("iv", paramIntent.getStringExtra("iv"));
          localJSONObject.put("encryptedData", paramIntent.getStringExtra("encryptedData"));
          if (PhoneNumberManagementFragment.access$000(this.this$0) != null)
          {
            QLog.d("PhoneNumberManagementFragment", 1, "mPhoneNumberArray put : " + localJSONObject.toString());
            PhoneNumberManagementFragment.access$000(this.this$0).put(localJSONObject);
            PhoneNumberManagementFragment.access$100(this.this$0);
          }
          return true;
        }
        catch (Throwable paramIntent)
        {
          QLog.e("PhoneNumberManagementFragment", 1, "REQUEST_CODE_ADD_PHONENUMBER error, ", paramIntent);
          return true;
        }
      }
      QLog.e("PhoneNumberManagementFragment", 1, "REQUEST_CODE_ADD_PHONENUMBER " + paramInt2);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.PhoneNumberManagementFragment.1
 * JD-Core Version:    0.7.0.1
 */