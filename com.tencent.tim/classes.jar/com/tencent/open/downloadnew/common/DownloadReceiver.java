package com.tencent.open.downloadnew.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import arug;
import arvu;
import arwt;
import arxn;
import asad;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str3;
    if (paramIntent != null)
    {
      str3 = paramIntent.getStringExtra("processName");
      if ((!TextUtils.isEmpty(str3)) && (str3.equalsIgnoreCase(arug.getProcessName()))) {
        break label32;
      }
    }
    label32:
    String str1;
    String str2;
    String str4;
    do
    {
      do
      {
        return;
        str1 = paramIntent.getAction();
        paramIntent = (NoticeParam)paramIntent.getParcelableExtra("noticeParam");
      } while (paramIntent == null);
      str2 = str3.replace(":", ".");
      if ((asad.cDU + "." + str2).equals(str1))
      {
        arxn.db(paramContext, paramIntent.packName);
        return;
      }
      arwt.i("vivi", "processName :" + str3 + " | formatStr:" + str2);
      str3 = paramIntent.appId;
      str4 = paramIntent.packName;
    } while ((TextUtils.isEmpty(str3)) && (TextUtils.isEmpty(str4)));
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    while (i < arrayOfStackTraceElement.length)
    {
      localStringBuilder.append(arrayOfStackTraceElement[i].toString());
      i += 1;
    }
    if (!TextUtils.isEmpty(str3)) {
      arvu.jk.put(str3, localStringBuilder.toString());
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new DownloadReceiver.1(this, str3, str4, paramIntent, str2, str1, paramContext));
      return;
      if (!TextUtils.isEmpty(paramIntent.cDW)) {
        arvu.jk.put(paramIntent.cDW, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.DownloadReceiver
 * JD-Core Version:    0.7.0.1
 */