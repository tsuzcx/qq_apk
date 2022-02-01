package com.tencent.mobileqq.activity.qwallet;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
import zxx;
import zxx.a;

public class PublicQuickPayManager$1
  extends ResultReceiver
{
  public PublicQuickPayManager$1(zxx paramzxx, Handler paramHandler, zxx.a parama, String paramString)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    paramInt = -2;
    Object localObject = paramBundle.getString("result");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        if (localObject != null) {
          paramInt = ((JSONObject)localObject).optInt("resultCode", -2);
        }
        if ((paramInt == -3) || (paramInt == -4) || (paramInt == -6)) {
          this.jdField_a_of_type_Zxx.showDialog();
        }
        zxx.a(this.jdField_a_of_type_Zxx, this.jdField_a_of_type_Zxx$a, paramInt, paramBundle.getString("retmsg"), paramBundle.getString("payTime"), this.bbj);
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      paramInt = -2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PublicQuickPayManager.1
 * JD-Core Version:    0.7.0.1
 */