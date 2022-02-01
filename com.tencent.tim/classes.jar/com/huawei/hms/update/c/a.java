package com.huawei.hms.update.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.huawei.hms.support.log.HMSLog;

public class a
  extends BroadcastReceiver
{
  private Handler a;
  
  public a(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            try
            {
              paramIntent.getStringExtra("TestIntent");
              paramContext = paramIntent.getAction();
              if ("com.huawei.appmarket.service.downloadservice.Receiver".equals(paramContext))
              {
                paramContext = paramIntent.getExtras();
                if (paramContext == null) {
                  continue;
                }
                paramIntent = new Message();
                paramIntent.what = 101;
                paramIntent.obj = paramContext;
                this.a.sendMessage(paramIntent);
              }
            }
            catch (Exception paramContext)
            {
              HMSLog.e("SilentInstallReceive", "intent has some error" + paramContext.getMessage());
              return;
            }
          }
          if (!"com.huawei.appmarket.service.downloadservice.progress.Receiver".equals(paramContext)) {
            break;
          }
          paramContext = paramIntent.getExtras();
        } while (paramContext == null);
        paramIntent = new Message();
        paramIntent.what = 102;
        paramIntent.obj = paramContext;
        this.a.sendMessage(paramIntent);
        return;
      } while (!"com.huawei.appmarket.service.installerservice.Receiver".equals(paramContext));
      paramContext = paramIntent.getExtras();
    } while (paramContext == null);
    paramIntent = new Message();
    paramIntent.what = 103;
    paramIntent.obj = paramContext;
    this.a.sendMessage(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.update.c.a
 * JD-Core Version:    0.7.0.1
 */