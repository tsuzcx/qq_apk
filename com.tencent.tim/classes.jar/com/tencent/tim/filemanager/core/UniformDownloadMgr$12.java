package com.tencent.tim.filemanager.core;

import android.os.Bundle;
import anpb;
import atur;
import atur.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class UniformDownloadMgr$12
  implements Runnable
{
  public UniformDownloadMgr$12(atur paramatur, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    if ((this.ajI == null) || (this.aS == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] onDownloadNotificationBeClean. param error!!");
      return;
    }
    int i = this.aS.getInt("_notify_param_Id");
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>onDownloadNotificationBeClean. URL:" + this.ajI + " nofiyid:" + i);
    atur.a locala = this.this$0.a(this.ajI);
    if ((locala != null) && (this.this$0.app != null))
    {
      if (locala.mDownloadType != 1) {
        break label175;
      }
      anpb.F(this.this$0.app.getApplication().getApplicationContext(), this.this$0.app.getCurrentAccountUin(), "Stop_download_2-1_3-0");
    }
    for (;;)
    {
      atur.c(this.this$0, this.ajI);
      atur.a(this.this$0, this.ajI);
      this.this$0.IX(this.ajI);
      atur.b(this.this$0);
      return;
      label175:
      anpb.F(this.this$0.app.getApplication().getApplicationContext(), this.this$0.app.getCurrentAccountUin(), "Stop_download_2-1_3-1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.UniformDownloadMgr.12
 * JD-Core Version:    0.7.0.1
 */