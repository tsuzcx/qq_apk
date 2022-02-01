package com.tencent.mobileqq.ark.API;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import tkv;
import tlm;
import tlm.a;
import tlm.b;

class ArkAppNotifyCenter$GdtNotify$4
  implements Runnable
{
  ArkAppNotifyCenter$GdtNotify$4(ArkAppNotifyCenter.a parama, WeakReference paramWeakReference, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((this.gt == null) || (this.gt.get() == null) || (TextUtils.isEmpty(this.val$params))) {
      QLog.e("ark.ArkAppNotifyCenter", 1, "ark get_device_info error", null);
    }
    Object localObject2;
    do
    {
      return;
      try
      {
        localObject1 = new JSONObject(this.val$params).optJSONObject("params");
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((JSONObject)localObject1).optString("businessIdForAidTicketAndTaidTicket");
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Object localObject1;
          tlm.a locala;
          QLog.e("ark.ArkAppNotifyCenter", 1, "ark get_device_info error", localJSONException);
          localObject2 = null;
        }
        localObject2 = tkv.pbToJson(localObject2.b);
      }
      locala = new tlm.a();
      locala.aJy = ((String)localObject1);
      localObject1 = tlm.a((Context)this.gt.get(), locala);
      if ((localObject1 == null) || (((tlm.b)localObject1).b == null))
      {
        QLog.e("ark.ArkAppNotifyCenter", 1, "ark get_device_info error", null);
        return;
      }
    } while ((localObject2 == null) || (!(localObject2 instanceof JSONObject)));
    ArkAppCenter.a().postToArkThread(new ArkAppNotifyCenter.GdtNotify.4.1(this, localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.4
 * JD-Core Version:    0.7.0.1
 */