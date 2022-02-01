package com.tencent.mobileqq.apollo.sdk;

import absb;
import absh;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class CmShowSpriteDrawerInfoBridge$4$1
  implements Runnable
{
  public CmShowSpriteDrawerInfoBridge$4$1(absh paramabsh, String paramString, absb paramabsb) {}
  
  public void run()
  {
    try
    {
      Object localObject = new JSONObject(this.bhy).optJSONArray("sprites");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("dressInfos", localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("changeDress('").append(localJSONObject.toString()).append("');");
      this.b.CN(((StringBuilder)localObject).toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("CmShow_SpriteDrawerInfoBridge", 1, "checkfDressChanged onCallback e:", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowSpriteDrawerInfoBridge.4.1
 * JD-Core Version:    0.7.0.1
 */