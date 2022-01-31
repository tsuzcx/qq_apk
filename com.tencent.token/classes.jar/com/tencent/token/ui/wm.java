package com.tencent.token.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import com.tencent.token.global.e;

final class wm
  extends BroadcastReceiver
{
  wm(RealNameStep0VerifyMobileDownActivity paramRealNameStep0VerifyMobileDownActivity) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 0;
    try
    {
      if (!"android.provider.Telephony.SMS_RECEIVED".equals(paramIntent.getAction())) {
        return;
      }
      paramContext = RealNameStep0VerifyMobileDownActivity.access$000(this.a, paramIntent);
      if (paramContext == null) {
        return;
      }
      e.a("current time: " + System.currentTimeMillis());
      e.a("msgs count: " + paramContext.length + ", msgs[0] time: " + paramContext[0].getTimestampMillis());
      RealNameStep0VerifyMobileDownActivity.access$100(this.a);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
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
      paramIntent = paramContext[i].getDisplayMessageBody();
      e.a("msg[" + i + "]: " + paramIntent);
      j = paramIntent.indexOf(RealNameStep0VerifyMobileDownActivity.access$200(this.a));
      if (j >= 0)
      {
        i = RealNameStep0VerifyMobileDownActivity.access$200(this.a).length() + j;
        while ((i < paramIntent.length()) && (paramIntent.charAt(i) <= '9') && (paramIntent.charAt(i) >= '0')) {
          i += 1;
        }
        RealNameStep0VerifyMobileDownActivity.access$300(this.a, paramIntent.substring(j + RealNameStep0VerifyMobileDownActivity.access$200(this.a).length(), i));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wm
 * JD-Core Version:    0.7.0.1
 */