package com.tencent.mobileqq.ark;

import adqt;
import adqy;
import adqy.a;
import android.text.TextUtils;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ArkAppPreDownloadMgr$2
  implements Runnable
{
  public ArkAppPreDownloadMgr$2(adqy paramadqy) {}
  
  public void run()
  {
    if ((adqy.a(this.this$0).size() == 0) || (adqy.a(this.this$0))) {}
    for (;;)
    {
      return;
      adqy.a(this.this$0, true);
      if ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null)
      {
        QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling predownload error for invalid ArkAppMgr");
        return;
      }
      Iterator localIterator = adqy.a(this.this$0).entrySet().iterator();
      while (localIterator.hasNext())
      {
        adqy.a locala = (adqy.a)((Map.Entry)localIterator.next()).getValue();
        if ((!TextUtils.isEmpty(locala.appname)) && (!TextUtils.isEmpty(ArkAppMgr.getInstance().getAppPathByNameFromLocal(locala.appname, "", null, false))))
        {
          if (adqt.lf(locala.appname))
          {
            locala.cJt = 0;
            QLog.w("ArkApp.ArkAppPreDownloadMgr", 1, "profiling disable to preload ArkApp name = " + locala.appname);
          }
          if (locala.cJt == 1)
          {
            QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling need to preload ArkApp name = " + locala.appname);
            String str = ArkAppMgr.getInstance().getAppPathByNameFromLocal(locala.appname, "", "0.0.0.1", false);
            adqy.a(this.this$0, locala.appname, str, adqy.a(this.this$0), 1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.2
 * JD-Core Version:    0.7.0.1
 */