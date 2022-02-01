import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

public class iih
{
  private boolean PL;
  private VideoAppInterface mApp;
  private BroadcastReceiver qqExitBroadcastReceiver = new iih.a();
  
  public iih(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
  }
  
  private String getCurProcessName(Context paramContext)
  {
    try
    {
      int i = Process.myPid();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == i)
        {
          paramContext = localRunningAppProcessInfo.processName;
          return paramContext;
        }
      }
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  private String getLocalVerify(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label142;
      }
    }
    label142:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  private boolean isContainsProc(ArrayList<String> paramArrayList)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      bool1 = true;
    }
    String str;
    do
    {
      return bool1;
      str = getCurProcessName(this.mApp.getApplication());
      bool1 = bool2;
    } while (TextUtils.isEmpty(str));
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramArrayList.size()) {
        break;
      }
      if (str.equals(paramArrayList.get(i))) {
        return true;
      }
      i += 1;
    }
  }
  
  private boolean isLegalBroadcast(String paramString, ArrayList<String> paramArrayList)
  {
    if (Foreground.sCountActivity > 0) {}
    while ((paramString == null) || (paramString.length() == 0) || ((!paramString.equals(getLocalVerify(paramArrayList, false))) && (!paramString.equals(getLocalVerify(paramArrayList, true))))) {
      return false;
    }
    return true;
  }
  
  public void amw()
  {
    if (this.PL)
    {
      this.mApp.getApplication().unregisterReceiver(this.qqExitBroadcastReceiver);
      this.PL = false;
    }
  }
  
  public void amx()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GKillProcessMonitor", 2, "regist QQ Process Exit Receiver");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.process.exit");
    if (this.mApp.getApplication().registerReceiver(this.qqExitBroadcastReceiver, localIntentFilter) != null) {
      this.PL = true;
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent != null) && ("com.tencent.process.exit".equals(paramIntent.getAction())))
      {
        paramContext = paramIntent.getExtras().getStringArrayList("procNameList");
        paramIntent = paramIntent.getExtras().getString("verify");
        if ((iih.a(iih.this, paramIntent, paramContext)) && (iih.a(iih.this, paramContext)))
        {
          paramContext = iih.a(iih.this).b();
          if ((paramContext == null) || (paramContext.b().sY()))
          {
            if (paramContext != null) {
              paramContext.alW();
            }
            QLog.d("GKillProcessMonitor", 1, "qqExitBroadcastReceiver");
            Process.killProcess(Process.myPid());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iih
 * JD-Core Version:    0.7.0.1
 */