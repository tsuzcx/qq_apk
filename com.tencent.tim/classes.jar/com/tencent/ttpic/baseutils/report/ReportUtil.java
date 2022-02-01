package com.tencent.ttpic.baseutils.report;

public class ReportUtil
{
  private static ReportListener listener;
  
  public static void report(String paramString)
  {
    if (listener != null) {
      listener.report(paramString);
    }
  }
  
  public static void setListener(ReportListener paramReportListener)
  {
    listener = paramReportListener;
  }
  
  public static abstract interface ReportListener
  {
    public abstract void report(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.report.ReportUtil
 * JD-Core Version:    0.7.0.1
 */