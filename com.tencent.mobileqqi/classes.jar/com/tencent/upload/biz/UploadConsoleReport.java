package com.tencent.upload.biz;

import com.tencent.upload.common.UploadLog;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.Report;

public class UploadConsoleReport
  implements IUploadReport
{
  private static final String tag = "ConsoleReport";
  
  public void batchComplete()
  {
    UploadLog.i("ConsoleReport", "batchComplate");
  }
  
  public void onUploadReport(Report paramReport)
  {
    UploadLog.i("ConsoleReport", paramReport.toString());
  }
  
  public void openSessionReport(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    UploadLog.i("ConsoleReport", "wnsSessionReport() " + paramInt1 + " " + paramString1 + " " + paramString2 + " " + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.upload.biz.UploadConsoleReport
 * JD-Core Version:    0.7.0.1
 */