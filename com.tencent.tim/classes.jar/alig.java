import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class alig
{
  private static long agD = 1L;
  private static long agE = 2L;
  private static long agF = 4L;
  private static long agG = 8L;
  private static long agH = 16L;
  private static boolean cxh;
  private static int daB;
  private static int dug = 1;
  private static int duh = 1;
  private static int dui = 1;
  private static int duj = 1;
  private static int duk;
  private static int dul = 1;
  private static int tryCount;
  
  static
  {
    daB = 480000;
    tryCount = 9;
    duk = 3;
  }
  
  public static void M(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool = cxh;
        if ((bool) && (!paramBoolean)) {
          return;
        }
        cxh = true;
        try
        {
          Object localObject = z(paramQQAppInterface);
          if (QLog.isColorLevel()) {
            QLog.d("PttOptimizeParams", 2, "initPttOptimizeCfgStr: " + (String)localObject);
          }
          if (localObject != null)
          {
            localObject = ((String)localObject).split("\\|");
            dug = Integer.valueOf(localObject[0]).intValue();
            duh = Integer.valueOf(localObject[1]).intValue();
            daB = Integer.valueOf(localObject[2]).intValue();
            tryCount = Integer.valueOf(localObject[3]).intValue();
            duk = Integer.valueOf(localObject[4]).intValue();
            dui = Integer.valueOf(localObject[5]).intValue();
            duj = Integer.valueOf(localObject[6]).intValue();
            dul = Integer.valueOf(localObject[7]).intValue();
          }
          localObject = paramQQAppInterface.getCurrentAccountUin();
          if (dug == 0)
          {
            if (!((String)localObject).endsWith("1")) {
              break label514;
            }
            dug = 2;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PttOptimizeParams", 2, "initDirectDownloadCfgStr: " + dug);
          }
          if (duh == 0)
          {
            if (!((String)localObject).endsWith("2")) {
              break label521;
            }
            duh = 2;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PttOptimizeParams", 2, "initSSCMCfgStr: " + duh);
          }
          if (dui == 0)
          {
            if (!((String)localObject).endsWith("3")) {
              break label528;
            }
            dui = 2;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PttOptimizeParams", 2, "initActivateNet: " + dui);
          }
          if (duj == 0)
          {
            if (!paramQQAppInterface.getCurrentAccountUin().endsWith("5")) {
              break label535;
            }
            duj = 2;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PttOptimizeParams", 2, "initHttpSideWay: " + duj);
          }
          if (dul == 0)
          {
            if (!((String)localObject).endsWith("4")) {
              break label542;
            }
            dul = 2;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("PttOptimizeParams", 2, "sPreSendSwitch: " + dul);
        }
        catch (Exception paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PttOptimizeParams", 2, "initOptimizeCfg exception: " + paramQQAppInterface);
          }
          dug = 1;
          duh = 1;
          daB = 480000;
          tryCount = 9;
          duk = 3;
          dui = 1;
          duj = 1;
          dul = 1;
        }
        continue;
        dug = 1;
      }
      finally {}
      label514:
      continue;
      label521:
      duh = 1;
      continue;
      label528:
      dui = 1;
      continue;
      label535:
      duj = 1;
      continue;
      label542:
      dul = 1;
    }
  }
  
  public static int T(QQAppInterface paramQQAppInterface)
  {
    M(paramQQAppInterface, false);
    return daB;
  }
  
  public static int U(QQAppInterface paramQQAppInterface)
  {
    M(paramQQAppInterface, false);
    return tryCount;
  }
  
  public static int V(QQAppInterface paramQQAppInterface)
  {
    M(paramQQAppInterface, false);
    return duk;
  }
  
  public static int W(QQAppInterface paramQQAppInterface)
  {
    M(paramQQAppInterface, false);
    return dul;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    long l2 = 0L;
    if (bt(paramQQAppInterface)) {
      l2 = 0L | agD;
    }
    long l1 = l2;
    if (bu(paramQQAppInterface)) {
      l1 = l2 | agE;
    }
    l2 = l1;
    if (bv(paramQQAppInterface)) {
      l2 = l1 | agF;
    }
    l1 = l2;
    if (bw(paramQQAppInterface)) {
      l1 = l2 | agG;
    }
    l2 = l1;
    if (paramBoolean) {
      l2 = l1 | agH;
    }
    return l2;
  }
  
  public static void aw(QQAppInterface paramQQAppInterface, String paramString)
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("RecordParams_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit().putString("ptt_optimize_cfg_v2", paramString).commit();
    if (QLog.isColorLevel()) {
      QLog.d("PttOptimizeParams", 2, "savePttOptimizeCfg: " + paramString);
    }
  }
  
  public static boolean bt(QQAppInterface paramQQAppInterface)
  {
    M(paramQQAppInterface, false);
    if (QLog.isColorLevel()) {
      QLog.d("PttOptimizeParams", 2, "doesSupportDirectDownload:" + dug);
    }
    return dug == 1;
  }
  
  public static boolean bu(QQAppInterface paramQQAppInterface)
  {
    M(paramQQAppInterface, false);
    if (QLog.isColorLevel()) {
      QLog.d("PttOptimizeParams", 2, "doesSupportSSCM:" + duh);
    }
    return duh == 1;
  }
  
  public static boolean bv(QQAppInterface paramQQAppInterface)
  {
    M(paramQQAppInterface, false);
    if (QLog.isColorLevel()) {
      QLog.d("PttOptimizeParams", 2, "doesSupportActivateNet:" + dui);
    }
    return dui == 1;
  }
  
  public static boolean bw(QQAppInterface paramQQAppInterface)
  {
    M(paramQQAppInterface, false);
    if (QLog.isColorLevel()) {
      QLog.d("PttOptimizeParams", 2, "doesSupportHttpSideWay:" + duj);
    }
    return duj == 1;
  }
  
  public static long m(QQAppInterface paramQQAppInterface)
  {
    return a(paramQQAppInterface, false);
  }
  
  private static String z(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences("RecordParams_" + paramQQAppInterface.getCurrentAccountUin(), 0).getString("ptt_optimize_cfg_v2", null);
    if (QLog.isColorLevel()) {
      QLog.d("PttOptimizeParams", 2, "getSavedPttOptimizeCfg: " + paramQQAppInterface);
    }
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alig
 * JD-Core Version:    0.7.0.1
 */