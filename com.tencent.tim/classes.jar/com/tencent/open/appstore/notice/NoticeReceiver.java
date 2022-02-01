package com.tencent.open.appstore.notice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import arug;
import arwt;
import arxn;
import asad;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.common.NoticeParam;

public class NoticeReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str2;
    if (paramIntent != null)
    {
      str2 = paramIntent.getStringExtra("processName");
      if ((!TextUtils.isEmpty(str2)) && (str2.equalsIgnoreCase(arug.getProcessName()))) {
        break label32;
      }
    }
    label32:
    String str1;
    Object localObject;
    do
    {
      do
      {
        return;
        str1 = paramIntent.getAction();
        localObject = (NoticeParam)paramIntent.getParcelableExtra("noticeParam");
      } while (localObject == null);
      paramIntent = str2.replace(":", ".");
      if ((asad.cDU + "." + paramIntent).equals(str1))
      {
        arxn.db(paramContext, ((NoticeParam)localObject).packName);
        return;
      }
      arwt.i("NoticeReceiver", "processName :" + str2 + " | formatStr:" + paramIntent);
      str2 = ((NoticeParam)localObject).packName;
      localObject = ((NoticeParam)localObject).cDW;
    } while ((TextUtils.isEmpty(str2)) && (TextUtils.isEmpty((CharSequence)localObject)));
    ThreadManager.executeOnSubThread(new NoticeReceiver.1(this, (String)localObject, paramIntent, str1, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.notice.NoticeReceiver
 * JD-Core Version:    0.7.0.1
 */