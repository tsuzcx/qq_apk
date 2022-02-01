package com.tencent.mobileqq.widget.qqfloatingscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import arlf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class FloatingScreenStatusReceiver
  extends BroadcastReceiver
{
  private static int ekf = BaseApplicationImpl.sProcessId;
  private arlf a;
  private boolean dce;
  private int ekg;
  private Context mContext;
  
  public FloatingScreenStatusReceiver(Context paramContext)
  {
    this.mContext = paramContext;
    paramContext = new IntentFilter();
    paramContext.addAction("tencent.mobileqq.floatingscreen.statuschange");
    paramContext.addAction("mqq.intent.action.QQ_BACKGROUND");
    paramContext.addAction("mqq.intent.action.QQ_FOREGROUND");
    paramContext.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    paramContext.addAction("mqq.intent.action.ACCOUNT_KICKED");
    paramContext.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    paramContext.addAction("mqq.intent.action.FORCE_LOGOUT");
    paramContext.addAction("mqq.intent.action.LOGOUT");
    paramContext.addAction("android.intent.action.SCREEN_OFF");
    this.mContext.getApplicationContext().registerReceiver(this, paramContext);
  }
  
  private boolean mM(int paramInt)
  {
    return (paramInt == -1) || (paramInt == this.ekg);
  }
  
  public void a(int paramInt, arlf paramarlf)
  {
    this.ekg = paramInt;
    this.a = paramarlf;
  }
  
  public void destroy()
  {
    this.mContext.getApplicationContext().unregisterReceiver(this);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 1;
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("FSReceiver", 4, new Object[] { "action: ", paramIntent.getAction() });
        }
        if ("tencent.mobileqq.floatingscreen.statuschange".equals(paramIntent.getAction()))
        {
          i = paramIntent.getIntExtra("param_concern_floating_type", -1);
          if (!mM(i))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FSReceiver", 2, new Object[] { "type not available, concern:", Integer.valueOf(i), " ,curr:", Integer.valueOf(this.ekg) });
            }
          }
          else
          {
            i = paramIntent.getIntExtra("param_curr_window_status", 0);
            int j = paramIntent.getIntExtra("param_busitype", -1);
            if (QLog.isColorLevel()) {
              QLog.d("FSReceiver", 2, new Object[] { "busiType:", Integer.valueOf(j), " ,status:", Integer.valueOf(i), " ,hide:", Boolean.valueOf(this.dce) });
            }
            if (paramIntent.hasExtra("param_ignored_processid"))
            {
              j = paramIntent.getIntExtra("param_ignored_processid", -1);
              if (ekf == j) {}
            }
            else
            {
              switch (i)
              {
              default: 
                return;
              case 102: 
                this.a.ekc();
                this.dce = true;
                return;
              case 103: 
                this.a.TZ(true);
                this.dce = false;
                return;
              }
              this.a.ccz();
            }
          }
        }
        else
        {
          if ("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()))
          {
            this.a.ekb();
            return;
          }
          if ("mqq.intent.action.QQ_BACKGROUND".equals(paramIntent.getAction()))
          {
            this.a.ekc();
            return;
          }
          if (!"mqq.intent.action.QQ_FOREGROUND".equals(paramIntent.getAction())) {
            break;
          }
          paramContext = paramIntent.getStringExtra("process_name");
          if ((paramContext != null) && (paramContext.contains("openSdk"))) {}
          while ((i == 0) && (!this.dce))
          {
            this.a.TZ(false);
            return;
            i = 0;
          }
        }
      }
    } while ((!"mqq.intent.action.ACCOUNT_CHANGED".equals(paramIntent.getAction())) && (!"mqq.intent.action.ACCOUNT_KICKED".equals(paramIntent.getAction())) && (!"mqq.intent.action.ACCOUNT_EXPIRED".equals(paramIntent.getAction())) && (!"mqq.intent.action.FORCE_LOGOUT".equals(paramIntent.getAction())) && (!"mqq.intent.action.LOGOUT".equals(paramIntent.getAction())));
    i = paramIntent.getIntExtra("type", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FSReceiver", 2, "cnrType=" + i + " action=" + paramIntent.getAction());
    }
    this.a.ccz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenStatusReceiver
 * JD-Core Version:    0.7.0.1
 */