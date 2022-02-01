package com.tencent.open.downloadnew;

import android.os.Bundle;
import arwt;
import arwy;
import aryv;
import arzk;
import arzl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import oicq.wlogin_sdk.tools.util;

public class MyAppApi$10$1
  implements Runnable
{
  public MyAppApi$10$1(arzl paramarzl, byte[] paramArrayOfByte, String paramString) {}
  
  public void run()
  {
    boolean bool2 = false;
    this.a.b.destory();
    for (;;)
    {
      boolean bool3;
      try
      {
        ThreadManager.excute(new MyAppApi.10.1.1(this, this.a.this$0.a(this.a.d, this.a.val$params)), 32, null, true);
        if ((this.hp != null) && (this.hp.length != 0))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          this.a.d.uin = (this.val$uin + "&identity=" + util.buf_to_string(this.hp));
          this.a.this$0.awQ = this.a.awR;
        }
        arwt.v("MyAppApi", "OpenSDK startToAppDetail param SNGAppId=" + this.a.d.SNGAppId + " apkId=" + this.a.d.taskApkId + " taskAppId=" + this.a.d.taskAppId + " packageName=" + this.a.d.taskPackageName + " version=" + this.a.d.taskVersion + " uin=" + this.a.d.uin + " via=" + this.a.d.via);
        arwt.d("TIME-STATISTIC", "mDownloadSdk.startToAppDetail");
        if (this.a.this$0.getApiLevel() <= 2)
        {
          ((TMAssistantCallYYB_V1)this.a.this$0.a()).startToAppDetail(this.a.val$context, this.a.d, this.a.val$autoDownload, this.a.val$autoInstall);
          return;
        }
        int i = this.a.val$params.getInt(aryv.PARAM_ACTIONCODE);
        int j = this.a.this$0.H(this.a.val$params);
        boolean bool1 = this.a.val$autoDownload;
        bool3 = this.a.val$autoInstall;
        if (i == 3)
        {
          bool1 = false;
          ((TMAssistantCallYYB_V2)this.a.this$0.a()).startToAppDetail(this.a.val$context, this.a.d, bool1, bool2, j);
          return;
        }
      }
      catch (Exception localException)
      {
        arwt.w("MyAppApi", "startToAppDetail err", localException);
        return;
      }
      bool2 = bool3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.10.1
 * JD-Core Version:    0.7.0.1
 */