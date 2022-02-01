import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class anoe
{
  public static boolean cIP;
  private static boolean cIQ;
  public static boolean cIR;
  public static boolean isDebug = false;
  
  public static void QS(String paramString)
  {
    annt.e(new Throwable(paramString));
  }
  
  public static void aC(MessageRecord paramMessageRecord)
  {
    try
    {
      if (paramMessageRecord.msgtype == -2011)
      {
        paramMessageRecord = (MessageForStructing)paramMessageRecord;
        if (paramMessageRecord.structingMsg != null)
        {
          int i = paramMessageRecord.structingMsg.mMsgServiceID;
          b(paramMessageRecord.structingMsg);
        }
      }
      return;
    }
    catch (Throwable paramMessageRecord)
    {
      QLog.d("FightReporter_", 1, paramMessageRecord, new Object[0]);
    }
  }
  
  public static void b(AbsStructMsg paramAbsStructMsg)
  {
    wip localwip1;
    do
    {
      try
      {
        int i = paramAbsStructMsg.mMsgServiceID;
        if ((i < 0) || (i > 6)) {
          break;
        }
        wip localwip2 = wiq.a;
        localwip1 = localwip2;
        if (!isDebug) {
          continue;
        }
        localwip1 = localwip2;
        if (localwip2 != null) {
          continue;
        }
        localwip1 = new wip();
        localwip1.bNu = 1;
        localwip1.bNv = 1;
        localwip1.bNw = 5;
      }
      catch (Throwable paramAbsStructMsg)
      {
        QLog.d("FightReporter_", 1, paramAbsStructMsg, new Object[0]);
        return;
      }
      if (localwip1.bNu == 0) {
        break;
      }
      hv("FightReporter_structMsgServiceID", paramAbsStructMsg.getXml());
      return;
    } while (localwip1 != null);
  }
  
  public static void dSE()
  {
    if (Build.VERSION.SDK_INT > 28) {}
    for (;;)
    {
      return;
      if (!cIR)
      {
        if (!PreferenceManager.getDefaultGlobalPreference(BaseApplicationImpl.getContext()).getBoolean("saveIDA", false)) {
          dSH();
        }
        cIR = true;
      }
      if (cIP) {
        continue;
      }
      Object localObject = wiq.a;
      if ((localObject == null) || (((wip)localObject).bNz != 1)) {
        continue;
      }
      cIP = true;
      localObject = PreferenceManager.getDefaultGlobalPreference(BaseApplicationImpl.getContext());
      if (((SharedPreferences)localObject).getBoolean("FightReporter_deviceid", false)) {
        continue;
      }
      ((SharedPreferences)localObject).edit().putBoolean("FightReporter_deviceid", true).apply();
      String str2 = auri.getIMEI("0");
      try
      {
        localObject = alla.getString(BaseApplicationImpl.getContext().getContentResolver(), "android_id");
        HashMap localHashMap = new HashMap();
        localHashMap.put("imei", str2);
        localHashMap.put("androidID", localObject);
        String str3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance(str3, "FightReporter_deviceid", true, 0L, 0L, localHashMap, null);
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("FightReporter_", 2, "rYU.i.A.report real...IMEI = " + str2 + ",androidID = " + (String)localObject);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str1 = "";
        }
      }
    }
  }
  
  public static void dSF()
  {
    if (cIQ) {}
    do
    {
      return;
      cIQ = true;
      localObject = PreferenceManager.getDefaultGlobalPreference(BaseApplicationImpl.getContext());
    } while (((SharedPreferences)localObject).getBoolean("FightReporter_cpu_abi", false));
    ((SharedPreferences)localObject).edit().putBoolean("FightReporter_cpu_abi", true).apply();
    HashMap localHashMap = new HashMap();
    if (Build.VERSION.SDK_INT >= 21) {}
    for (Object localObject = Build.SUPPORTED_ABIS[0];; localObject = Build.CPU_ABI)
    {
      localHashMap.put("cpu_abi", localObject);
      localHashMap.put("sdk", Build.VERSION.SDK_INT + "");
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(str, "FightReporter_cpu_abi", true, 0L, 0L, localHashMap, null);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("FightReporter_", 2, "rYU.i.A.report real...cpu abi = " + (String)localObject + ",sdk = " + Build.VERSION.SDK_INT);
      return;
    }
  }
  
  public static void dSG()
  {
    wip localwip = wiq.a;
    if ((localwip != null) && (localwip.bNy == 1)) {
      QS("FightReporter_openthirdappnullinfo");
    }
  }
  
  public static void dSH()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultGlobalPreference(BaseApplicationImpl.getContext());
    String str3 = SecurityUtile.encode("d_iemi");
    String str2 = SecurityUtile.encode("d_idandroid");
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    String str4 = auri.getIMEI("0");
    Object localObject = "";
    try
    {
      str1 = alla.getString(BaseApplicationImpl.getContext().getContentResolver(), "android_id");
      localObject = str1;
    }
    catch (Exception localException)
    {
      String str1;
      label53:
      break label53;
    }
    str1 = SecurityUtile.encode(str4);
    localObject = SecurityUtile.encode((String)localObject);
    localEditor.putString(str3, str1);
    localEditor.putString(str2, (String)localObject);
    localEditor.putBoolean("saveIDA", true);
    localEditor.apply();
    if (QLog.isDevelopLevel())
    {
      localObject = localSharedPreferences.getString(str3, "");
      str1 = localSharedPreferences.getString(str2, "");
      QLog.d("FightReporter_", 4, "has save suc,spIMStr = " + (String)localObject + ", imei = " + SecurityUtile.encode((String)localObject) + ",androidid = " + SecurityUtile.encode(str1));
    }
  }
  
  public static void dSI() {}
  
  public static void hv(String paramString1, String paramString2)
  {
    annt.e(new Throwable(paramString1), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anoe
 * JD-Core Version:    0.7.0.1
 */