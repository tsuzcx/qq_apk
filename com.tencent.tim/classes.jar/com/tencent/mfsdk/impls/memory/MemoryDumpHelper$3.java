package com.tencent.mfsdk.impls.memory;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqju;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import tyf;

public class MemoryDumpHelper$3
  implements Runnable
{
  public void run()
  {
    try
    {
      if (!tyf.a(this.this$0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MemoryDumpHelper", 2, "init dialog error!");
        }
      }
      else if (!tyf.a(this.this$0).isShowing())
      {
        tyf.a(this.this$0).setMessage(this.val$title);
        tyf.a(this.this$0).setPositiveButton(this.aJV, this.e);
        tyf.a(this.this$0).show();
        int i = tyf.a(this.this$0).getInt("DumpCount" + AppSetting.getAppId(), 0);
        tyf.a(this.this$0).edit().putInt("DumpCount" + AppSetting.getAppId(), i + 1).putLong("DumpTime", System.currentTimeMillis()).commit();
        if (QLog.isColorLevel())
        {
          QLog.d("MemoryDumpHelper", 2, "ReportDump have show dump dialog");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MemoryDumpHelper", 2, "ReportDump startDumpingMemoryLeak Exception", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.impls.memory.MemoryDumpHelper.3
 * JD-Core Version:    0.7.0.1
 */