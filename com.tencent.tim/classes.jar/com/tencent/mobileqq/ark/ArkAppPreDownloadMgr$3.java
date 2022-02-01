package com.tencent.mobileqq.ark;

import adqy;
import adqy.a;
import aopm;
import aopo;
import aopp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ArkAppPreDownloadMgr$3
  implements Runnable
{
  public ArkAppPreDownloadMgr$3(adqy paramadqy, adqy.a parama) {}
  
  public void run()
  {
    Object localObject = new ArkAppPreDownloadMgr.3.1(this);
    QQAppInterface localQQAppInterface = (QQAppInterface)adqy.a(this.this$0).get();
    if (localQQAppInterface != null) {}
    for (aopo localaopo = (aopo)localQQAppInterface.getManager(193);; localaopo = null)
    {
      if (localaopo != null)
      {
        adqy.a(this.this$0);
        QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling add ark predowload to scheduler,app=", this.a.appname });
        localObject = new aopp(localQQAppInterface, this.a.appname, (Runnable)localObject, 10000L);
        localaopo.a(10080, "prd", this.a.appname, adqy.b(this.this$0), this.a.appname, "", 1, 0, false, (aopm)localObject);
        return;
      }
      QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling add ark predowload to scheduler fail for predownloadCtrl null,app=", this.a.appname });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.3
 * JD-Core Version:    0.7.0.1
 */