package com.tencent.qqmail.utilities.log;

import android.util.Log;
import com.tencent.feedback.upload.UploadHandleListener;

final class RDMCrashReportHelper$2
  implements UploadHandleListener
{
  public void onUploadEnd(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    if (paramInt1 == 206) {
      Log.i("myLog", "上报异常数据结果：\n上行流量：" + paramLong1 + "\n下行流量：" + paramLong2 + "\n成功与否：" + paramBoolean + "\n额外信息：" + paramString);
    }
  }
  
  public void onUploadStart(int paramInt)
  {
    if (paramInt == 206) {
      Log.i("myLog", "开始上报异常数据");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.RDMCrashReportHelper.2
 * JD-Core Version:    0.7.0.1
 */