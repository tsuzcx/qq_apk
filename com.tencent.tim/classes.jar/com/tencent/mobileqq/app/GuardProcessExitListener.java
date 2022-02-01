package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.text.format.Time;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.Foreground;
import skj;

public abstract class GuardProcessExitListener
  extends BroadcastReceiver
{
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
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return true;
    }
    return paramArrayList.contains(getCurrentProcessName());
  }
  
  private boolean isLegalBroadcast(String paramString, ArrayList<String> paramArrayList)
  {
    if (Foreground.sCountActivity > 0) {}
    while ((paramString == null) || (paramString.length() == 0) || ((!paramString.equals(getLocalVerify(paramArrayList, false))) && (!paramString.equals(getLocalVerify(paramArrayList, true))))) {
      return false;
    }
    return true;
  }
  
  public void exitProcess(boolean paramBoolean)
  {
    Process.killProcess(Process.myPid());
  }
  
  protected String getCurrentProcessName()
  {
    return skj.getCurrentProcessName();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!"com.tencent.process.exit".equals(paramContext));
        paramContext = paramIntent.getExtras();
      } while (paramContext == null);
      paramContext = paramContext.getStringArrayList("procNameList");
    } while ((!isLegalBroadcast(paramIntent.getExtras().getString("verify"), paramContext)) || (!isContainsProc(paramContext)));
    if (QLog.isColorLevel()) {
      QLog.e("GuardProcessExitListener", 2, "***exitProcexx*** receive broacast action=" + paramIntent.getAction());
    }
    exitProcess(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.GuardProcessExitListener
 * JD-Core Version:    0.7.0.1
 */