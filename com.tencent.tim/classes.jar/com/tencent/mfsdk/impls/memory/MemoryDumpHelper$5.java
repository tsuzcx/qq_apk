package com.tencent.mfsdk.impls.memory;

import android.os.Build;
import android.os.Build.VERSION;
import anpc;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qapmsdk.base.meta.DumpResult;
import com.tencent.qapmsdk.common.util.InspectUUID;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.os.MqqHandler;
import txj;
import txk;
import tyf;
import tyj;

public class MemoryDumpHelper$5
  implements Runnable
{
  public MemoryDumpHelper$5(tyf paramtyf, boolean paramBoolean1, InspectUUID paramInspectUUID, String paramString, boolean paramBoolean2) {}
  
  public void run()
  {
    Object localObject2;
    Object localObject1;
    if (this.aQH)
    {
      str = this.a.toString();
      if (!this.aQH) {
        break label396;
      }
      localObject2 = MagnifierSDK.a().a().b(str);
      localObject1 = localObject2;
      if (((DumpResult)localObject2).success)
      {
        MagnifierSDK.a().a().report(System.currentTimeMillis(), ((DumpResult)localObject2).zipFilePath);
        localObject1 = localObject2;
      }
      label71:
      File localFile = new File(((DumpResult)localObject1).zipFilePath);
      if (QLog.isColorLevel()) {
        QLog.d("MemoryDumpHelper", 2, "leakFlag=true,ZipFile=true,leakName=" + str + ",dumpPath=" + localFile.getAbsolutePath());
      }
      tyf.c(this.this$0);
      ThreadManager.getUIHandler().post(new MemoryDumpHelper.5.1(this));
      if ((((DumpResult)localObject1).success) && (!this.aQH))
      {
        long l = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) * 100L / Runtime.getRuntime().maxMemory();
        localObject2 = new HashMap(16);
        ((HashMap)localObject2).put("osVersion", Build.VERSION.RELEASE);
        ((HashMap)localObject2).put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
        ((HashMap)localObject2).put("maxHeap", String.valueOf(Runtime.getRuntime().maxMemory()));
        ((HashMap)localObject2).put("totalHeap", String.valueOf(Runtime.getRuntime().totalMemory()));
        ((HashMap)localObject2).put("freeHeap", String.valueOf(Runtime.getRuntime().freeMemory()));
        ((HashMap)localObject2).put("threhold", String.valueOf(l));
        ((HashMap)localObject2).put("dumpFileSize", String.valueOf(((DumpResult)localObject1).hprofFileSize));
        ((HashMap)localObject2).put("zipFileSize", String.valueOf(localFile.length()));
        if (!tyf.aQG) {
          break label426;
        }
      }
    }
    label396:
    label426:
    for (String str = "1";; str = "0")
    {
      ((HashMap)localObject2).put("miniDump", str);
      anpc.a(BaseApplication.getContext()).collectPerformance("", "MemoryPeakDump", true, 0L, 0L, (HashMap)localObject2, "");
      tyj.a().bEV();
      return;
      str = this.aJW;
      break;
      localObject1 = MagnifierSDK.a().a().a(str);
      MagnifierSDK.a().a().report((DumpResult)localObject1);
      break label71;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.impls.memory.MemoryDumpHelper.5
 * JD-Core Version:    0.7.0.1
 */