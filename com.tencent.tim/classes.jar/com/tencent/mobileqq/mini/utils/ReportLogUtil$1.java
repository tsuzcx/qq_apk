package com.tencent.mobileqq.mini.utils;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class ReportLogUtil$1
  implements ReportLogUtil.UploadLogListener
{
  ReportLogUtil$1(String paramString1, String paramString2, long paramLong) {}
  
  public void onFail(String paramString)
  {
    QLog.d("ReportLogUtil", 1, "upload log fail: " + this.val$logPath);
    paramString = new File(this.val$logPath);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  public void onSuccess(String paramString)
  {
    QLog.d("ReportLogUtil", 1, " upload log success: " + this.val$logPath);
    MiniAppCmdUtil.getInstance().reportLogFileUrl(null, this.val$appid, paramString, this.val$fileSize, new ReportLogUtil.1.1(this, paramString));
    paramString = new File(this.val$logPath);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.ReportLogUtil.1
 * JD-Core Version:    0.7.0.1
 */