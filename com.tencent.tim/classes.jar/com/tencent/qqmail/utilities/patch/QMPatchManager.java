package com.tencent.qqmail.utilities.patch;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import moai.patch.handle.PatchCleanTask;
import moai.patch.handle.PatchHandler;

public class QMPatchManager
{
  private static final int[] FILTER_LOGID = { 2006, 2007, 2021, 2001, 4002, 2024, 2026, 2027, 4000, 2023, 2022, 2000, 3000, 3002, 7001, 6001, 5000, 1011, 9008, 1001, 2017, 9005, 1013, 2031, 9004 };
  private static final String TAG = "QMPatchManager";
  
  public static void checkPatch()
  {
    if (TextUtils.isEmpty(SPManager.getSp("qmpatch_info", true).getString("patchtype", null)))
    {
      QMLog.log(4, "QMPatchManager", "no patch task to do, no need to start patch service");
      return;
    }
    QMApplicationContext.sharedInstance().startService(QMPatchManagerService.createCheckIntent());
  }
  
  public static void downloadPatch(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    QMApplicationContext.sharedInstance().startService(QMPatchManagerService.createDownloadPatchIntent(paramString, paramBoolean1, paramBoolean2));
  }
  
  private static boolean filtered(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = FILTER_LOGID;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == arrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static void handleSchema(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    QMApplicationContext.sharedInstance().startService(QMPatchManagerService.createSchemaIntent(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9));
  }
  
  public static void initLogger()
  {
    PatchHandler.setLogger(new QMPatchManager.1());
  }
  
  public static void installPatch(String paramString1, String paramString2, boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().startService(QMPatchManagerService.createInstallPatchIntent(paramString1, paramString2, paramBoolean));
  }
  
  public static boolean isPatched()
  {
    return AppConfig.getSystemVersionCode() != AppConfig.getPatchVersionCode();
  }
  
  public static void revertPatch()
  {
    QMLog.log(5, "QMPatchManager", "revertPatch!");
    SPManager.getEditor("moai_patch").putBoolean("patch_revert", true).commit();
    new PatchCleanTask().checkCleanPatch(QMApplicationContext.sharedInstance());
  }
  
  public static void stop()
  {
    QMApplicationContext.sharedInstance().startService(QMPatchManagerService.createStopImmedialyIntent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.patch.QMPatchManager
 * JD-Core Version:    0.7.0.1
 */