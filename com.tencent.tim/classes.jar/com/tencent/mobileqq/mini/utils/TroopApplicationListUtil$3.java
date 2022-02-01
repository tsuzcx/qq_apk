package com.tencent.mobileqq.mini.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import arcz.b;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class TroopApplicationListUtil$3
  extends Handler
{
  TroopApplicationListUtil$3(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof arcz.b))
    {
      paramMessage = (arcz.b)paramMessage.obj;
      if (paramMessage.resultCode == 0) {
        try
        {
          QLog.d("TroopApplicationListUtil", 1, new Object[] { "handleMessage cgiState.htmlBody: ", paramMessage.czO });
          TroopApplicationListUtil.access$000(new JSONObject(paramMessage.czO).optInt("ec", -1));
          return;
        }
        catch (Exception paramMessage)
        {
          QLog.e("TroopApplicationListUtil", 1, "handleMessage addMiniAppToTroopApplicationList exception ", paramMessage);
          return;
        }
      }
      QLog.d("TroopApplicationListUtil", 1, new Object[] { "handleMessage cgiState.resultCode: ", Integer.valueOf(paramMessage.resultCode) });
      return;
    }
    QLog.e("TroopApplicationListUtil", 1, new Object[] { "handleMessage addMiniAppToTroopApplicationList ", " invalid msg.obj" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.3
 * JD-Core Version:    0.7.0.1
 */