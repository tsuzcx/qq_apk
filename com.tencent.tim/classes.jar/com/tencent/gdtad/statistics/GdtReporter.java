package com.tencent.gdtad.statistics;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import tkw;

public class GdtReporter
{
  public static final int REPORT_DEEP_LINK_SUCCESS = 137;
  public static final int REPORT_OPEN_MAIN_PAGE = 138;
  
  public static void doCgiReport(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.post(new GdtCgiReportRunnable(paramString), 2, null, false);
    tkw.i("GDT_CGI_REPORT", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtReporter
 * JD-Core Version:    0.7.0.1
 */