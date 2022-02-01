package com.tencent.mobileqq.ark;

import adqy.a;
import adqz;
import android.text.TextUtils;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.qphone.base.util.QLog;

public class ArkAppPreDownloadMgr$3$1
  implements Runnable
{
  ArkAppPreDownloadMgr$3$1(ArkAppPreDownloadMgr.3 param3) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a.a.appname))
    {
      if (!TextUtils.isEmpty(ArkAppMgr.getInstance().getAppPathByNameFromLocal(this.a.a.appname, "", null, false))) {
        break label106;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAppPreDownloadMgr", 2, new Object[] { "profiling preDownloadApp begin app = ", this.a.a.appname });
      }
      ArkAppMgr.getInstance().getAppPathByName(this.a.a.appname, "", "0.0.0.1", null, new adqz(this));
    }
    label106:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ArkApp.ArkAppPreDownloadMgr", 2, new Object[] { "profiling preDownloadApp app", this.a.a.appname, "allready downloaded" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.3.1
 * JD-Core Version:    0.7.0.1
 */