package com.tencent.android.tpush.d.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;

class b$1
  extends BroadcastReceiver
{
  b$1(b paramb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      String str;
      try
      {
        str = paramIntent.getAction();
        if (i.b(str)) {
          return;
        }
        TLogger.i("OtherPushHuaWeiImpl", "Receive broadcast action: " + str);
        if ("com.huawei.android.push.intent.REGISTRATION".equals(str))
        {
          paramIntent = paramIntent.getByteArrayExtra("device_token");
          if (paramIntent == null) {
            return;
          }
          paramIntent = new String(paramIntent, "UTF-8");
          TLogger.i("OtherPushHuaWeiImpl", "Get token from broadcast: " + paramIntent);
          if (i.b(paramIntent)) {
            return;
          }
          if (!paramIntent.equals(this.a.c(paramContext)))
          {
            this.a.c = paramIntent;
            SharePrefsUtil.setString(paramContext, "huawei_token", this.a.c);
          }
          d.a(this.a.a, "OtherPushHuaWeiImpl", "errCode : 0 , errMsg : success");
          return;
        }
      }
      catch (Throwable paramIntent)
      {
        TLogger.e("OtherPushHuaWeiImpl", "registerHuaweiRecevier ", paramIntent);
        SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -120 , errMsg : ").append(paramIntent.getLocalizedMessage()).toString());
        return;
      }
      if ("com.huawei.android.push.intent.RECEIVE".equals(str))
      {
        TLogger.d("OtherPushHuaWeiImpl", "reciver action com.huawei.android.push.intent.RECEIVE");
        return;
      }
      if ("com.huawei.intent.action.PUSH_STATE".equals(str)) {
        TLogger.d("OtherPushHuaWeiImpl", "reciver action com.huawei.intent.action.PUSH_STATEE");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.d.a.b.1
 * JD-Core Version:    0.7.0.1
 */