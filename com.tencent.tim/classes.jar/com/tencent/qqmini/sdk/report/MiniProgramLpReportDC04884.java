package com.tencent.qqmini.sdk.report;

import android.os.Handler;

public class MiniProgramLpReportDC04884
{
  private static final String TAG = "MiniProgramLpReportDC04";
  
  public static void reportApiReport(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new MiniProgramLpReportDC04884.1(paramString2, paramString1, paramString3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04884
 * JD-Core Version:    0.7.0.1
 */