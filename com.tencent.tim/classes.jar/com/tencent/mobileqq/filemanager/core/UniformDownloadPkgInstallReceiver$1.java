package com.tencent.mobileqq.filemanager.core;

import agil;
import aglz;
import aglz.c;
import agme;
import ahbj;
import android.content.Context;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.util.Iterator;
import java.util.List;

class UniformDownloadPkgInstallReceiver$1
  implements Runnable
{
  UniformDownloadPkgInstallReceiver$1(UniformDownloadPkgInstallReceiver paramUniformDownloadPkgInstallReceiver, String paramString1, String paramString2, Context paramContext) {}
  
  public void run()
  {
    if (("android.intent.action.PACKAGE_ADDED".equalsIgnoreCase(this.val$action)) || ("android.intent.action.PACKAGE_REPLACED".equalsIgnoreCase(this.val$action)))
    {
      Object localObject = aglz.a().d(this.abn, true);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          aglz.c localc = (aglz.c)((Iterator)localObject).next();
          if (localc != null)
          {
            QLog.i("UniformDownloadPkgInstallReceiver<FileAssistant>", 1, "[UniformDL] send cancel notification.pkgName:" + this.abn + " notificationId:" + localc.notificationId);
            agme.a().F(localc.notificationId, null);
            if (ahbj.fileExistsAndNotEmpty(localc.bIe))
            {
              QbSdk.openFileWithQB(this.val$context, localc.bIe, "biz_src_jc_file");
              if (QLog.isDevelopLevel()) {
                QLog.i("UniformDownloadPkgInstallReceiver<FileAssistant>", 1, "浏览器安装成功，准备打开文件:" + localc.bIe);
              }
            }
            if (localc.aW.containsKey("params_open_with_yyb")) {
              agil.eC(localc.aW.getString("params_open_with_yyb", ""), 2);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadPkgInstallReceiver.1
 * JD-Core Version:    0.7.0.1
 */