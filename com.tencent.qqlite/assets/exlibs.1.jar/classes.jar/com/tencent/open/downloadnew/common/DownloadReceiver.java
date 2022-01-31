package com.tencent.open.downloadnew.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appcommon.Common;
import com.tencent.open.business.base.AppUtil;
import fie;

public class DownloadReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1;
    if (paramIntent != null)
    {
      str1 = paramIntent.getStringExtra("processName");
      if ((!TextUtils.isEmpty(str1)) && (str1.equalsIgnoreCase(Common.p()))) {
        break label29;
      }
    }
    label29:
    String str2;
    do
    {
      do
      {
        return;
        str1 = paramIntent.getAction();
        paramIntent = (NoticeParam)paramIntent.getParcelableExtra("noticeParam");
      } while (paramIntent == null);
      if (IntentFactory.f.equals(str1))
      {
        AppUtil.a(paramContext, paramIntent.d);
        return;
      }
      str2 = paramIntent.a;
    } while (TextUtils.isEmpty(str2));
    ThreadManager.b(new fie(this, str2, paramIntent, str1, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.DownloadReceiver
 * JD-Core Version:    0.7.0.1
 */