import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.vipreport.ArkVipReporter.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class adty
{
  private static HashMap<String, adtz> jK = new HashMap(2);
  private static HashMap<String, adtx> jL = new HashMap(2);
  private static boolean sEnable;
  private static Object sLock = new Object();
  
  static
  {
    sEnable = true;
  }
  
  private static adtz a(String paramString)
  {
    Iterator localIterator = jK.entrySet().iterator();
    while (localIterator.hasNext())
    {
      adtz localadtz = (adtz)((Map.Entry)localIterator.next()).getValue();
      if ((localadtz.ce != null) && (localadtz.ce.contains(paramString))) {
        return localadtz;
      }
    }
    return null;
  }
  
  public static void a(String paramString, adtz paramadtz)
  {
    aeix.e locale = aeiy.b(380).a();
    if ((locale != null) && (locale.a() != null)) {
      sEnable = locale.a().bUn;
    }
    if ((sEnable) && (!TextUtils.isEmpty(paramString)) && (!jK.containsKey(paramadtz))) {
      jK.put(paramString, paramadtz);
    }
    QLog.d("ArkVipReporter", 1, new Object[] { "initScene() sceneName=", paramString, ", enable =", Boolean.valueOf(sEnable) });
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong, HashMap<String, String> paramHashMap)
  {
    if ((sEnable) && (aqft.aCc()) && (!TextUtils.isEmpty(paramString))) {
      synchronized (sLock)
      {
        adtz localadtz = a(paramString);
        if (localadtz != null)
        {
          adtx localadtx = (adtx)jL.get(localadtz.scene);
          if (localadtx == null) {
            return;
          }
          adtw localadtw = new adtw();
          localadtw.bvy = paramString;
          localadtw.index = localadtx.uK.size();
          localadtw.result = paramBoolean;
          localadtw.endTime = System.currentTimeMillis();
          localadtw.costTime = paramLong;
          localadtw.startTime = (localadtw.endTime - paramLong);
          localadtw.VB = aqiw.getNetworkType(null);
          localadtw.params = paramHashMap;
          localadtx.uK.add(localadtw);
          QLog.d("ArkVipReporter", 1, new Object[] { "addEventToScene() evt:", paramString, ", cost time=", Long.valueOf(paramLong) });
          if (paramString.equals(localadtz.bvA)) {
            report(localadtz.scene);
          }
        }
        return;
      }
    }
  }
  
  public static void ag(String paramString, long paramLong)
  {
    if ((sEnable) && (aqft.aCc()) && (!TextUtils.isEmpty(paramString))) {
      synchronized (sLock)
      {
        adtz localadtz = a(paramString);
        if ((localadtz != null) && (paramString.equals(localadtz.bvz)))
        {
          String str = localadtz.scene;
          if (jL.containsKey(str)) {
            report(str);
          }
          adtx localadtx = new adtx();
          localObject1 = BaseApplicationImpl.getApplication().getRuntime();
          if (((AppRuntime)localObject1).getAccount() == null)
          {
            localObject1 = "";
            localadtx.uin = ((String)localObject1);
            localadtx.SB = (Build.MANUFACTURER + "_" + Build.MODEL);
            localadtx.os = "android";
            localadtx.qqver = "3.4.4_3058";
            localadtx.scene = str;
            localadtx.bvz = localadtz.bvz;
            localadtx.bvA = localadtz.bvA;
            localadtx.startTime = paramLong;
            localadtx.uK = new ArrayList(8);
            jL.put(str, localadtx);
            QLog.d("ArkVipReporter", 1, new Object[] { "startSceneByEvent() sceneName=", str, ",evt =", paramString });
            ArkDispatchTask.getInstance().postToArkThreadDelay(new ArkVipReporter.1(str, localadtz), localadtz.timeOut);
          }
        }
        else
        {
          return;
        }
        Object localObject1 = ((AppRuntime)localObject1).getAccount();
      }
    }
  }
  
  private static void report(String paramString)
  {
    synchronized (sLock)
    {
      adtx localadtx = (adtx)jL.remove(paramString);
      if (localadtx != null)
      {
        localadtx.endTime = System.currentTimeMillis();
        localadtx.costTime = (localadtx.endTime - localadtx.startTime);
        ??? = localadtx.getJsonObject().toString();
        QLog.d("ArkVipReporter", 1, new Object[] { "report() sceneName:", paramString, ",total cost time=", Long.valueOf(localadtx.costTime) });
        if (1 != BaseApplicationImpl.sProcessId) {
          break label136;
        }
        paramString = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if (paramString != null)
        {
          paramString = ((ArkAppCenter)paramString.getManager(121)).a();
          if (paramString != null) {
            paramString.GJ((String)???);
          }
        }
      }
      return;
    }
    label136:
    paramString = new Bundle();
    paramString.putString("reportContent", (String)???);
    adst.a().a("callVIPReport", paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adty
 * JD-Core Version:    0.7.0.1
 */