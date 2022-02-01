package com.tencent.mobileqq.database.corrupt;

import afat;
import anaz;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import anpc;
import aqhq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class DBFixManager
  implements Manager
{
  private static String TAG = "DBFix";
  public static String bCE = "dbfix";
  public static String bCF = "dbfix_config";
  public static String bCG = "dbfix_flag";
  public static String bCH = "dbfix_count";
  public static String bCI;
  public static String bCJ;
  public static String bCK;
  public static String bCL;
  public static String bCM;
  public static String bCN;
  public static String bCO = "dbcorrupt_report_nodb";
  public static String bCP = "dbcorrupt_report_copy_fail";
  public static String bCQ = "dbcorrupt_report_fix";
  public static boolean bXb;
  public static int cPT = 5;
  public static int cPU;
  public static int cPV;
  public static int cPW;
  public static int cPX;
  public static int cPY;
  public static long corruptedTime = -1L;
  QQAppInterface mApp;
  Context mContext;
  String mUin;
  
  static
  {
    cPV = 5;
    bCI = "key_dbfixso_load_count";
    bCJ = "dbcorrupt_flag";
    bCK = "dbcorrupt_report_fix_succ";
    bCL = "dbcorrupt_report_fix_fail";
    bCM = "dbcorrupt_report_fix_other";
    bCN = "fix_fail_reason";
    cPW = 1;
    cPX = 2;
    cPY = 3;
  }
  
  public DBFixManager(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = this.mApp.getApp();
    this.mUin = this.mApp.getCurrentAccountUin();
  }
  
  public void C(Context paramContext, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.mApp.getApplication().getSharedPreferences(bCE, 0);
    String str = this.mApp.getCurrentAccountUin();
    boolean bool = localSharedPreferences.getBoolean(str + bCG, false);
    if ((paramBoolean) && (bool)) {}
    do
    {
      do
      {
        return;
        if (!aiG()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(TAG, 2, "onCorruptionInstant, db fixing");
      return;
      File localFile = this.mContext.getDatabasePath(this.mUin + ".db");
      if ((localFile.exists()) && (localFile.length() != 0L)) {
        break;
      }
      QLog.d(TAG, 1, new Object[] { "onCorruptionInstant, db not exists, ", Boolean.valueOf(localFile.exists()) });
      localSharedPreferences.edit().remove(str + bCJ).commit();
    } while (!bool);
    paramContext = localSharedPreferences.edit();
    paramContext.remove(str + bCG);
    paramContext.remove(str + bCH);
    paramContext.commit();
    return;
    if (paramBoolean) {
      cYi();
    }
    for (;;)
    {
      paramContext = localSharedPreferences.edit();
      if ((!TextUtils.isEmpty(str)) && (!bool)) {
        paramContext.putBoolean(str + bCG, true);
      }
      int i = localSharedPreferences.getInt(str + bCH, 0);
      str = str + bCH;
      i += 1;
      paramContext.putInt(str, i);
      paramContext.commit();
      QLog.d(TAG, 1, new Object[] { "onCorruptionInstant, start activity and write sp ", Integer.valueOf(i), " onCorrupt: ", Boolean.valueOf(paramBoolean) });
      return;
      new afat(paramContext, this.mApp).ii();
    }
  }
  
  public void HF(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mApp.sendOnlineStatus(AppRuntime.Status.offline, false, 0L, false);
      Intent localIntent = new Intent("mqq.intent.action.EXIT" + this.mContext.getPackageName());
      this.mContext.sendBroadcast(localIntent);
      return;
    }
    this.mApp.cLA();
  }
  
  public void HG(boolean paramBoolean)
  {
    Object localObject = this.mContext.getDatabasePath(this.mUin + ".db");
    long l = ((File)localObject).length();
    aqhq.deleteFile(((File)localObject).getPath());
    aqhq.deleteFile(this.mContext.getDatabasePath(this.mUin + ".db-journal").getPath());
    aqhq.deleteFile(this.mContext.getDatabasePath(this.mUin + "-wal").getPath());
    aqhq.deleteFile(this.mContext.getDatabasePath(this.mUin + "-shm").getPath());
    if (!paramBoolean)
    {
      localObject = this.mApp.getApplication().getSharedPreferences(bCE, 0);
      ((SharedPreferences)localObject).edit().remove(this.mUin + bCJ).commit();
      localObject = ((SharedPreferences)localObject).getString(this.mUin + bCN, "");
      HashMap localHashMap = new HashMap();
      localHashMap.put("failReason", localObject);
      localHashMap.put("dblen", String.valueOf(l));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, bCL, true, -1L, 0L, localHashMap, null, false);
      QLog.d(TAG, 1, new Object[] { "onCorruptionInstant, deleteDbFile, isSuc: ", Boolean.valueOf(paramBoolean), " failReason: ", localObject });
    }
  }
  
  public boolean aiF()
  {
    if ((!bXb) && (cPU == 0)) {
      cPU = this.mApp.getApplication().getSharedPreferences(bCE, 0).getInt(this.mUin + bCI, 0);
    }
    boolean bool;
    if ((!bXb) && (cPU <= cPV))
    {
      if (Build.VERSION.SDK_INT >= 18) {
        break label219;
      }
      if ((!SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "sqlite_qq")) || (!SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "DBFix"))) {
        break label214;
      }
      bool = true;
      bXb = bool;
      label110:
      if (bXb) {
        break label233;
      }
      cPU += 1;
      QLog.e(TAG, 1, new Object[] { "db fix so load failed, ", Integer.valueOf(cPU) });
    }
    for (;;)
    {
      SharedPreferences.Editor localEditor = this.mApp.getApplication().getSharedPreferences(bCE, 0).edit();
      localEditor.putInt(this.mUin + bCI, cPU);
      localEditor.commit();
      return bXb;
      label214:
      bool = false;
      break;
      label219:
      bXb = SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "DBFix");
      break label110;
      label233:
      cPU = 0;
    }
  }
  
  public boolean aiG()
  {
    return afat.dialog != null;
  }
  
  public void cYi()
  {
    Intent localIntent = new Intent(this.mContext, DBFixDialogActivity.class);
    localIntent.addFlags(268435456);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    localIntent.addFlags(131072);
    this.mContext.startActivity(localIntent);
  }
  
  public void cYj()
  {
    String str = this.mApp.getCurrentAccountUin();
    if (!TextUtils.isEmpty(str))
    {
      QLog.d(TAG, 1, "clearLocalSPFlag, remove sp");
      SharedPreferences.Editor localEditor = this.mApp.getApplication().getSharedPreferences(bCE, 0).edit();
      localEditor.remove(str + bCG);
      localEditor.remove(str + bCH);
      localEditor.commit();
    }
    anaz.dOT();
    this.mApp.getApp().getSharedPreferences("acc_info" + this.mApp.getAccount(), 0).edit().putBoolean("isFriendlistok", false).commit();
    QLog.d(TAG, 1, "cleared friendlist flag");
  }
  
  public void cYk()
  {
    QLog.d(TAG, 1, "exitQQMainProcess");
    HF(false);
    QLog.flushLog();
    if (QQPlayerService.isPlaying())
    {
      Intent localIntent = new Intent();
      localIntent.setAction("qqplayer_exit_action");
      this.mContext.sendBroadcast(localIntent);
    }
    QQMusicPlayService.LS(TAG);
    this.mApp.exit(false);
  }
  
  public native boolean dbfixRepair(String paramString1, String paramString2, DBFixResult paramDBFixResult);
  
  public native boolean dumpRepair(String paramString1, String paramString2, DBFixResult paramDBFixResult);
  
  public void ei(Context paramContext)
  {
    ThreadManager.postImmediately(new DBFixManager.1(this), null, true);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixManager
 * JD-Core Version:    0.7.0.1
 */