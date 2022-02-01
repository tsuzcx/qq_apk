package com.tencent.mobileqq.troop.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import anot;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

@Deprecated
public class TroopUsageTimeReport
  extends BroadcastReceiver
{
  private long ash;
  private long asi;
  private long asj;
  private long ask;
  public boolean cSR;
  public boolean cSS;
  private IntentFilter e = new IntentFilter();
  private QQAppInterface mApp;
  private SessionInfo mSessionInfo;
  private String mUin;
  
  private TroopUsageTimeReport()
  {
    this.e.addAction("android.intent.action.SCREEN_OFF");
    this.e.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    this.e.addAction("android.intent.action.ACTION_SHUTDOWN");
    this.e.addAction("android.intent.action.QUICKBOOT_POWEROFF");
  }
  
  public void ecq()
  {
    if (this.cSR)
    {
      this.asi = System.currentTimeMillis();
      long l = (this.asi - this.ash) / 1000L;
      int j = (int)l;
      int i = j;
      if (j <= 0) {
        i = 1;
      }
      SessionInfo localSessionInfo = this.mSessionInfo;
      if (localSessionInfo != null)
      {
        anot.b(this.mApp, "P_CliOper", "Grp_AIO", "", "time", "aio_time", 0, i, 0, localSessionInfo.aTl, "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("TroopUsageTimeReport-->AioUseTime", 2, "uin=" + this.mUin + ",mTroopUin=" + localSessionInfo.aTl + ",time=" + l + "s");
        }
      }
      this.cSR = false;
    }
  }
  
  public void ecr()
  {
    if (this.cSS)
    {
      this.ask = System.currentTimeMillis();
      long l = (this.ask - this.asj) / 1000L;
      int j = (int)l;
      int i = j;
      if (j <= 0) {
        i = 1;
      }
      SessionInfo localSessionInfo = this.mSessionInfo;
      if (localSessionInfo != null)
      {
        anot.b(this.mApp, "P_CliOper", "Grp_AIO", "", "time", "grp_time", 0, i, 0, localSessionInfo.aTl, "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("TroopUsageTimeReport-->TroopUseTime", 2, "uin=" + this.mUin + ",mTroopUin=" + localSessionInfo.aTl + ",time=" + l + "s");
        }
      }
      this.cSS = false;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("android.intent.action.SCREEN_OFF".equals(paramContext)) || ("android.intent.action.ACTION_SHUTDOWN".equals(paramContext)) || ("android.intent.action.QUICKBOOT_POWEROFF".equals(paramContext)))
    {
      ecq();
      ecr();
    }
    do
    {
      do
      {
        return;
      } while (!"android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramContext));
      paramContext = paramIntent.getStringExtra("reason");
    } while ((paramContext == null) || (!paramContext.equals("homekey")));
    ecr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopUsageTimeReport
 * JD-Core Version:    0.7.0.1
 */