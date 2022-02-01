package com.tencent.mobileqq.mini.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import arcz.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONException;
import org.json.JSONObject;

final class TroopApplicationListUtil$4
  extends Handler
{
  TroopApplicationListUtil$4(Looper paramLooper, AsyncResult paramAsyncResult, String paramString1, String paramString2)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof arcz.b))
    {
      paramMessage = (arcz.b)paramMessage.obj;
      if (paramMessage.resultCode == 0)
      {
        try
        {
          if (paramMessage.czO != null)
          {
            QLog.d("TroopApplicationListUtil", 1, new Object[] { "handleMessage cgiState.htmlBody: ", paramMessage.czO });
            int i = new JSONObject(paramMessage.czO).optInt("ec", -1);
            TroopApplicationListUtil.access$000(i);
            paramMessage = new JSONObject();
            if ((i == 0) || (i == 41012))
            {
              paramMessage.put("errorCode", i);
              this.val$listener.onReceiveResult(true, paramMessage);
            }
            for (;;)
            {
              TroopApplicationListUtil.access$100(i, this.val$groupUin, this.val$appId);
              return;
              paramMessage.put("errorCode", i);
              this.val$listener.onReceiveResult(false, paramMessage);
            }
          }
          new JSONObject().put("errMsg", "htmlBody is null");
        }
        catch (JSONException paramMessage)
        {
          QLog.e("TroopApplicationListUtil", 1, "handleMessage addMiniAppToTroopApplicationList exception ", paramMessage);
          this.val$listener.onReceiveResult(false, null);
          return;
        }
        this.val$listener.onReceiveResult(false, null);
        return;
      }
      QLog.e("TroopApplicationListUtil", 1, "handleMessage addMiniAppToTroopApplicationList ,resultCode : " + paramMessage.resultCode);
      this.val$listener.onReceiveResult(false, null);
      return;
    }
    QLog.e("TroopApplicationListUtil", 1, new Object[] { "handleMessage addMiniAppToTroopApplicationList ", " invalid msg.obj" });
    this.val$listener.onReceiveResult(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.4
 * JD-Core Version:    0.7.0.1
 */