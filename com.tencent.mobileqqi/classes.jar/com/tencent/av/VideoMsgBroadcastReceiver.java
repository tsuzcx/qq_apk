package com.tencent.av;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AccountNotMatchException;
import mqq.app.MobileQQ;

public class VideoMsgBroadcastReceiver
  extends BroadcastReceiver
{
  static final String a = "VideoMsgBroadcastReceiver";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    String str1 = localBundle.getString("uin");
    String str2 = localBundle.getString("fromUin");
    String str3 = localBundle.getString("gatewayip");
    if (str1 == null) {}
    label281:
    label460:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("VideoMsgBroadcastReceiver", 2, "Recv uin = " + str1 + " action " + paramIntent.getAction());
          }
          try
          {
            paramContext = (VideoAppInterface)((MobileQQ)paramContext.getApplicationContext()).getAppRuntime(str1);
            if (paramContext != null)
            {
              if (str3 != null) {
                paramContext.a().d(str3, 0);
              }
              if (!paramIntent.getAction().equals("com.tencent.av.ui.qqi.VChatActivity")) {
                break label281;
              }
              if (QLog.isColorLevel()) {
                QLog.d("VideoMsgBroadcastReceiver", 2, "Video process wake up");
              }
              int i = localBundle.getInt("istatus");
              if (QLog.isColorLevel()) {
                QLog.d("VideoMsgBroadcastReceiver", 2, "my status = " + i);
              }
              switch (i)
              {
              default: 
                return;
              }
            }
          }
          catch (AccountNotMatchException paramContext) {}
        }
        paramContext.a().d(0);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("VideoMsgBroadcastReceiver", 1, "Account not match: uin = " + str1);
      return;
      paramContext.a().d(1);
      return;
      if (paramIntent.getAction().equals("tencent.video.q2v.RecvVideoCall"))
      {
        paramContext.a().a(localBundle);
        return;
      }
      if (paramIntent.getAction().equals("tencent.video.q2v.UpdateConfig"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoMsgBroadcastReceiver", 2, "updateConfigInfo");
        }
        paramContext.a().i();
        return;
      }
      if (paramIntent.getAction().equals("tencent.video.q2v.RecvSharpVideoCall"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoMsgBroadcastReceiver", 2, "onRecvSharpOfflineMsg");
        }
        long l = localBundle.getLong("onLineStatus");
        boolean bool = localBundle.getBoolean("isRequest");
        if (l == 11L) {
          paramContext.a().d(0);
        }
        for (;;)
        {
          paramContext.a().b(localBundle);
          if (!bool) {
            break;
          }
          paramContext.a().a(201, 2, str2);
          if (paramContext.a().c() != 0) {
            break label460;
          }
          paramContext.a().a(207, 2, str2);
          return;
          paramContext.a().d(1);
        }
        paramContext.a().a(206, 2, str2);
        return;
      }
    } while (!paramIntent.getAction().equals("tencent.video.q2v.RecvMultiVideoCall"));
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgBroadcastReceiver", 2, "onRecvMultiVideoOfflineMsg");
    }
    paramContext.a().c(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.VideoMsgBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */