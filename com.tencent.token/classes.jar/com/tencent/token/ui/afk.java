package com.tencent.token.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.TextView;

final class afk
  extends BroadcastReceiver
{
  afk(UtilsModSetMobileStep2Activity paramUtilsModSetMobileStep2Activity) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (!"android.provider.Telephony.SMS_RECEIVED".equals(paramIntent.getAction())) {
        return;
      }
      paramContext = UtilsModSetMobileStep2Activity.access$100(this.a, paramIntent);
      if ((paramContext == null) || (UtilsModSetMobileStep2Activity.access$200(this.a) == null)) {
        return;
      }
      if (UtilsModSetMobileStep2Activity.access$200(this.a).length() == 0) {
        return;
      }
      UtilsModSetMobileStep2Activity.access$000(this.a);
      i = 0;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        int i;
        int k;
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
      k = paramIntent.indexOf(UtilsModSetMobileStep2Activity.access$200(this.a));
      if (k >= 0)
      {
        j = UtilsModSetMobileStep2Activity.access$200(this.a).length() + k;
        for (;;)
        {
          if ((j < paramIntent.length()) && (paramIntent.charAt(j) <= '9') && (paramIntent.charAt(j) >= '0'))
          {
            j += 1;
          }
          else
          {
            paramIntent = paramIntent.substring(k + UtilsModSetMobileStep2Activity.access$200(this.a).length(), j);
            if (UtilsModSetMobileStep2Activity.access$300(this.a) != null)
            {
              UtilsModSetMobileStep2Activity.access$300(this.a).setText(paramIntent);
              UtilsModSetMobileStep2Activity.access$300(this.a).postDelayed(new afl(this), 1000L);
              return;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afk
 * JD-Core Version:    0.7.0.1
 */