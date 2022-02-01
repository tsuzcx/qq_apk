package com.tencent.mobileqq.ark.API;

import adnq;
import adoj;
import adoj.f;
import android.text.TextUtils;
import com.tencent.ark.ark.Application;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkAppSchemeCenter$TelSchemeHandler$2
  implements Runnable
{
  public ArkAppSchemeCenter$TelSchemeHandler$2(adoj.f paramf, String paramString1, String paramString2, long paramLong, String paramString3) {}
  
  public void run()
  {
    Object localObject1 = ark.Application.Create(this.val$appName, this.val$path);
    if (localObject1 == null)
    {
      QLog.i("ArkApp", 1, "ArkAppSchemeCenter.navigate create application error");
      return;
    }
    if (!adnq.a(this.val$appName, this.Vv, (ark.Application)localObject1, "permission.TELEPHONE"))
    {
      ((ark.Application)localObject1).Release();
      QLog.i("ArkApp", 1, "ArkAppSchemeCenter.navigate check Permission fail");
      return;
    }
    ((ark.Application)localObject1).Release();
    str = this.val$path;
    localObject1 = str;
    if (TextUtils.isEmpty(str)) {}
    try
    {
      Object localObject3 = adoj.b(new JSONObject(this.buP)).get("number");
      localObject1 = str;
      if (localObject3 != null) {
        localObject1 = localObject3.toString();
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.i("ArkApp", 1, "ArkAppSchemeCenter.navigate parameter error: " + localJSONException.getMessage());
        Object localObject2 = str;
      }
    }
    this.this$0.GG((String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler.2
 * JD-Core Version:    0.7.0.1
 */