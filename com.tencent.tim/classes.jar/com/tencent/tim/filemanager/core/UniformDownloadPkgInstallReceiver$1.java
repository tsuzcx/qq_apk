package com.tencent.tim.filemanager.core;

import atur;
import atur.c;
import atuv;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class UniformDownloadPkgInstallReceiver$1
  implements Runnable
{
  UniformDownloadPkgInstallReceiver$1(UniformDownloadPkgInstallReceiver paramUniformDownloadPkgInstallReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (("android.intent.action.PACKAGE_ADDED".equalsIgnoreCase(this.val$action)) || ("android.intent.action.PACKAGE_REPLACED".equalsIgnoreCase(this.val$action)))
    {
      Object localObject = atur.a().d(this.abn, true);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          atur.c localc = (atur.c)((Iterator)localObject).next();
          if (localc != null)
          {
            QLog.i("UniformDownloadPkgInstallReceiver<FileAssistant>", 1, "[UniformDL] send cancel notification.pkgName:" + this.abn + " notificationId:" + localc.notificationId);
            atuv.a().F(localc.notificationId, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.UniformDownloadPkgInstallReceiver.1
 * JD-Core Version:    0.7.0.1
 */