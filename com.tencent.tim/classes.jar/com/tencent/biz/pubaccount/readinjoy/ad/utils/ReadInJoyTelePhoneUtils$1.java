package com.tencent.biz.pubaccount.readinjoy.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import jqc;
import knk;
import org.json.JSONObject;

public final class ReadInJoyTelePhoneUtils$1
  implements Runnable
{
  public ReadInJoyTelePhoneUtils$1(AdvertisementInfo paramAdvertisementInfo, Context paramContext) {}
  
  public void run()
  {
    try
    {
      Object localObject = jqc.a(BaseApplicationImpl.getContext(), this.a.mAdRl + "&acttype=9001", "GET", null, null);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyTelePhoneUtils", 1, "requestTelephoneInfoAndCall-> result bytes null");
        }
      }
      else
      {
        localObject = new String((byte[])localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyTelePhoneUtils", 1, "requestTelephoneInfoAndCall-> result = " + (String)localObject);
        }
        localObject = new JSONObject((String)localObject);
        if ((((JSONObject)localObject).optJSONObject("data") != null) && (!TextUtils.isEmpty(((JSONObject)localObject).optJSONObject("data").optString("fmcphone"))))
        {
          knk.a(this.val$context, ((JSONObject)localObject).optJSONObject("data").optString("fmcphone"), this.a);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.utils.ReadInJoyTelePhoneUtils.1
 * JD-Core Version:    0.7.0.1
 */