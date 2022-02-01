package com.tencent.qqmail.utilities.log;

import android.os.Environment;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.feedback.upload.UploadHandleListener;
import com.tencent.qqmail.QMApplicationContext;
import java.io.File;

public class RDMCrashReportHelper
{
  public static CrashHandleListener getCrashHandleListener()
  {
    return new RDMCrashReportHelper.1();
  }
  
  public static CrashStrategyBean getCrashStrategyBean()
  {
    CrashStrategyBean localCrashStrategyBean = new CrashStrategyBean();
    localCrashStrategyBean.setMerged(false);
    localCrashStrategyBean.setStoreCrashSdcard(true);
    localCrashStrategyBean.setCrashSdcardMaxSize(3000);
    localCrashStrategyBean.setMaxStoredNum(10);
    localCrashStrategyBean.setMaxUploadNumGprs(2);
    localCrashStrategyBean.setMaxUploadNumWifi(20);
    localCrashStrategyBean.setMaxLogRow(10);
    localCrashStrategyBean.setOnlyLogTag("eup");
    return localCrashStrategyBean;
  }
  
  public static String getStoreCrashLogPath()
  {
    return Environment.getExternalStorageDirectory().getPath() + "/Tencent/" + QMApplicationContext.sharedInstance().getPackageName() + "/euplog.txt";
  }
  
  public static UploadHandleListener getUploadHandleListener()
  {
    return new RDMCrashReportHelper.2();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.RDMCrashReportHelper
 * JD-Core Version:    0.7.0.1
 */