package com.tencent.replacemonitor.replace.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import java.util.Map;

class b
  implements com.tencent.replacemonitor.replace.b
{
  b(a parama) {}
  
  public void a(int paramInt1, int paramInt2, long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    ab.c("WashMonitor", "ReplaceMonitorImpl >>onGetMonitorInfoSuccess reqId = " + paramInt1 + " appType = " + paramInt2 + " fileSize = " + paramLong1 + " apkMd5 = " + paramString1 + " runMd5FileSize = " + paramLong2 + " cpChannelId = " + paramString2);
    Object localObject = (Long)a.a(this.a).get(Integer.valueOf(paramInt1));
    if (localObject != null) {}
    for (long l = ((Long)localObject).longValue();; l = 0L)
    {
      localObject = com.tencent.replacemonitor.replace.b.a.a().a(l);
      ab.c("WashMonitor", "ReplaceMonitorImpl >>onGetMonitorInfoSuccess task = " + localObject);
      if (localObject != null)
      {
        if (((MonitorTask)localObject).fileSize <= 0L) {
          ((MonitorTask)localObject).fileSize = paramLong1;
        }
        if (TextUtils.isEmpty(((MonitorTask)localObject).fileMd5)) {
          ((MonitorTask)localObject).fileMd5 = paramString1;
        }
        if (TextUtils.isEmpty(((MonitorTask)localObject).cpChannelId)) {
          ((MonitorTask)localObject).cpChannelId = paramString2;
        }
        ((MonitorTask)localObject).appType = paramInt2;
        com.tencent.replacemonitor.replace.b.a.a().a((MonitorTask)localObject);
      }
      if (paramLong2 > 0L)
      {
        com.tencent.replacemonitor.a.a = paramLong2;
        paramString1 = GlobalUtil.getInstance().getContext();
        if (paramString1 != null) {
          paramString1.getSharedPreferences("replace_monitor_spf", 0).edit().putLong("md5_check_max_file_size", paramLong2).apply();
        }
      }
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    ab.d("WashMonitor", "ReplaceMonitorImpl >>onGetMonitorInfoFailed reqId = " + paramInt1 + " errorCode = " + paramInt2 + " errorMsg = " + paramString);
    paramString = (Long)a.a(this.a).get(Integer.valueOf(paramInt1));
    if (paramString != null) {}
    for (long l = paramString.longValue();; l = 0L)
    {
      paramString = com.tencent.replacemonitor.replace.b.a.a().a(l);
      if (paramString != null) {
        ab.d("WashMonitor", "ReplaceMonitorImpl >>onGetMonitorInfoFailed task.packageName = " + paramString.packageName + " apkId = " + paramString.yybApkId + " appId = " + paramString.yybAppId);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.c.b
 * JD-Core Version:    0.7.0.1
 */