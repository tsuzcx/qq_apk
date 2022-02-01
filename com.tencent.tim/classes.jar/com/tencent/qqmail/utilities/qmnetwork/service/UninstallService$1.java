package com.tencent.qqmail.utilities.qmnetwork.service;

import android.os.Environment;
import android.os.Process;
import android.util.Log;
import com.tencent.qqmail.utilities.deviceid.DeviceInfo;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.Hex;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

class UninstallService$1
  implements Runnable
{
  UninstallService$1(UninstallService paramUninstallService, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    QMLog.log(4, UninstallService.access$000(), "uninstallWatcher begin. vid:" + this.val$vid + " pid:" + Process.myPid());
    if (this.val$vid == 0L)
    {
      QMLog.log(5, UninstallService.access$000(), "uninstallWatcher vid 0");
      UninstallService.access$100(this.this$0);
      return;
    }
    if ((this.val$pwd == null) || (this.val$pwd.equals("")))
    {
      QMLog.log(5, UninstallService.access$000(), "uninstallWatcher pwd null or empty");
      UninstallService.access$100(this.this$0);
      return;
    }
    if (!UninstallService.access$200(this.this$0))
    {
      QMLog.log(6, UninstallService.access$000(), "copy mailwatchdog fail");
      return;
    }
    Object localObject1 = new StringBuilder();
    Object localObject2 = new StringBuilder();
    for (String str = new BigInteger(1, StringExtention.MD5(StringExtention.MD5(Hex.decodeHex(this.val$pwd.toCharArray())))).toString(16); str.length() < 32; str = "0" + str) {}
    ((StringBuilder)localObject2).append("v=").append(this.val$vid).append("&k=").append(str).append("&c=1").append("&d=").append(this.val$deviceid).append("&r=").append(this.val$appversion).append("&s=").append(DeviceUtil.getDeviceInfos().releaseVersion).append("&p=").append(this.val$brand);
    ((StringBuilder)localObject1).append("http://").append("qumas.mail.qq.com").append("/cgi-bin/uma_report_uninstall?").append(((StringBuilder)localObject2).toString());
    Log.e(UninstallService.access$000(), "cgistr:" + ((StringBuilder)localObject1).toString());
    localObject2 = Environment.getExternalStorageDirectory();
    str = "";
    if (localObject2 != null) {
      str = ((File)localObject2).getPath();
    }
    localObject2 = UninstallService.WATCHDOG_PATH;
    localObject1 = ((StringBuilder)localObject1).toString();
    try
    {
      Runtime.getRuntime().exec(new String[] { localObject2, "mailwatchdog", localObject1, "fork", str });
      QMLog.log(4, UninstallService.access$000(), "uninstallWatcher end. stop UninstallService.");
      Threads.runInBackground(new UninstallService.1.1(this), 200L);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QMLog.log(5, UninstallService.access$000(), "exec watchdog err:" + localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.UninstallService.1
 * JD-Core Version:    0.7.0.1
 */