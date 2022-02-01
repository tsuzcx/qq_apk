package com.tencent.mobileqq.richmedia.dc;

import android.os.Handler;
import android.os.HandlerThread;
import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class DataReport
{
  private static HandlerThread U = new HandlerThread("Reportor-Tasker");
  private static DataReport a = new DataReport();
  private Handler mHandler = new Handler(U.getLooper());
  
  static
  {
    U.start();
  }
  
  public static DataReport a()
  {
    return a;
  }
  
  public void a(ReportTask paramReportTask)
  {
    if (paramReportTask == null) {
      return;
    }
    this.mHandler.post(paramReportTask);
  }
  
  public static class ReportTask
    implements Runnable
  {
    String bZE;
    HashMap<String, String> mI;
    
    public ReportTask(String paramString, HashMap<String, String> paramHashMap)
    {
      this.bZE = paramString;
      this.mI = paramHashMap;
    }
    
    public void run()
    {
      if ((this.bZE == null) || (this.mI == null) || (this.mI.isEmpty())) {
        if (QLog.isColorLevel()) {
          QLog.i("DataReport", 2, "You must set mEventCode before report data!");
        }
      }
      do
      {
        return;
        anpc.a(BaseApplication.getContext()).collectPerformance(null, this.bZE, true, 0L, 0L, this.mI, "");
      } while (!QLog.isColorLevel());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("eventCode:" + this.bZE + "\n");
      localStringBuilder.append(this.mI.toString());
      QLog.i("DataReport", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DataReport
 * JD-Core Version:    0.7.0.1
 */