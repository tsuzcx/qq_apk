package com.tencent.token.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import com.tencent.token.db;
import com.tencent.token.global.e;

final class ago
  extends BroadcastReceiver
{
  ago(VryMobileForStrategyActivity paramVryMobileForStrategyActivity) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 0;
    try
    {
      if (!"android.provider.Telephony.SMS_RECEIVED".equals(paramIntent.getAction())) {
        return;
      }
      paramContext = VryMobileForStrategyActivity.access$000(this.a, paramIntent);
      if (paramContext == null) {
        return;
      }
      e.a("current time: " + System.currentTimeMillis());
      e.a("msgs count: " + paramContext.length + ", msgs[0] time: " + paramContext[0].getTimestampMillis());
      VryMobileForStrategyActivity.access$100(this.a);
      paramIntent = db.e;
      e.c("SMS_PREFRIX:" + paramIntent);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        String str;
        int j;
        paramContext.printStackTrace();
        return;
        i += 1;
      }
    }
    catch (Error paramContext)
    {
      paramContext.printStackTrace();
    }
    if (i < paramContext.length)
    {
      str = paramContext[i].getDisplayMessageBody();
      e.a("msg[" + i + "]: " + str);
      j = str.indexOf(paramIntent);
      if (j >= 0)
      {
        i = paramIntent.length() + j;
        while ((i < str.length()) && (str.charAt(i) <= '9') && (str.charAt(i) >= '0')) {
          i += 1;
        }
        VryMobileForStrategyActivity.access$200(this.a, str.substring(paramIntent.length() + j, i));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ago
 * JD-Core Version:    0.7.0.1
 */