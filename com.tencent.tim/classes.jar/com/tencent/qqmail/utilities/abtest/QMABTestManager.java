package com.tencent.qqmail.utilities.abtest;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qqmail.utilities.BrandUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushManager;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import moai.oss.OssHelper;

public class QMABTestManager
{
  private static final String KEY_ID_SUFFIX = "_id";
  private static final String KEY_ON_SUFFIX = "_on";
  private static final String KEY_TYPE_SUFFIX = "_type";
  private static final String SP_NAME = "abtest_info";
  private static final String TAG = "QMABTestManager";
  private static final String TASK_HW_PUSH = "hw_push";
  private static final String TASK_MI_PUSH = "mi_push";
  private static final String TASK_NOTIFY_SUB = "notify_sub";
  private static final String TASK_SENDMAIL_BY_FTN = "sendmail_by_ftn";
  private static Map<String, Method> sMethods = new HashMap();
  
  static
  {
    try
    {
      Method[] arrayOfMethod = QMABTestManager.class.getDeclaredMethods();
      if ((arrayOfMethod != null) && (arrayOfMethod.length > 0))
      {
        int j = arrayOfMethod.length;
        int i = 0;
        while (i < j)
        {
          Method localMethod = arrayOfMethod[i];
          OnABTest localOnABTest = (OnABTest)localMethod.getAnnotation(OnABTest.class);
          if (localOnABTest != null) {
            sMethods.put(localOnABTest.task(), localMethod);
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMABTestManager", "init ABTest failed", localException);
    }
  }
  
  private static void clear(String paramString)
  {
    SPManager.getEditor("abtest_info").remove(paramString + "_on").remove(paramString + "_id").remove(paramString + "_type").apply();
  }
  
  public static void enableHwPush(boolean paramBoolean)
  {
    setEnable("hw_push", paramBoolean);
  }
  
  public static void enableMiPush(boolean paramBoolean)
  {
    setEnable("mi_push", paramBoolean);
  }
  
  public static void enableSendMailByFtn(boolean paramBoolean)
  {
    setEnable("sendmail_by_ftn", paramBoolean);
  }
  
  public static void handle(String paramString1, String paramString2, String paramString3)
  {
    QMLog.log(4, "QMABTestManager", "handle, task: " + paramString1 + ", id: " + paramString2 + ", type: " + paramString3);
    Method localMethod = (Method)sMethods.get(paramString1);
    if (localMethod != null)
    {
      Object localObject = (OnABTest)localMethod.getAnnotation(OnABTest.class);
      if (TextUtils.equals(paramString1, ((OnABTest)localObject).task()))
      {
        boolean bool = isTaskOn(((OnABTest)localObject).policy(), paramString3, ((OnABTest)localObject).defaultOn());
        localObject = paramString1 + "_on";
        String str = paramString1 + "_type";
        paramString1 = paramString1 + "_id";
        SPManager.getEditor("abtest_info").putBoolean((String)localObject, bool).putString(str, paramString3).putString(paramString1, paramString2).apply();
        localObject = localMethod.getParameterTypes();
        if (localObject.length > 0)
        {
          paramString2 = new ArrayList();
          int j = localObject.length;
          int i = 0;
          paramString1 = paramString2;
          if (i < j)
          {
            paramString1 = localObject[i];
            if (paramString1 == Boolean.TYPE) {
              paramString2.add(Boolean.valueOf(bool));
            }
            for (;;)
            {
              i += 1;
              break;
              if (paramString1 == String.class) {
                paramString2.add(paramString3);
              }
            }
          }
        }
        else
        {
          paramString1 = null;
        }
        try
        {
          QMLog.log(4, "QMABTestManager", "try invoke: " + localMethod + ", with: " + paramString1);
          if (paramString1 == null)
          {
            localMethod.invoke(null, new Object[0]);
            return;
          }
          localMethod.invoke(null, paramString1.toArray());
          return;
        }
        catch (Exception paramString1)
        {
          QMLog.log(6, "QMABTestManager", "invoke ABTest method failed", paramString1);
        }
      }
    }
  }
  
  @OnABTest(defaultOn=true, task="hw_push")
  private static void hwPush(boolean paramBoolean, String paramString)
  {
    if (!BrandUtil.isEmui()) {
      clear("hw_push");
    }
    for (;;)
    {
      return;
      if (paramBoolean) {
        QMPushManager.register();
      }
      while ("abtest".equals(paramString))
      {
        OssHelper.hwPushAbtest(SPManager.getSp("abtest_info").getString("hw_push_id", null), new Object[] { Boolean.valueOf(paramBoolean) });
        return;
        QMPushManager.unregister(true);
      }
    }
  }
  
  public static void hwPushDelay(String paramString, long paramLong)
  {
    if (!BrandUtil.isEmui()) {}
    while ((paramLong < 0L) || (paramLong > 432000L) || (!"abtest".equals(SPManager.getSp("abtest_info").getString("hw_push_type", null)))) {
      return;
    }
    OssHelper.hwPushDelay(SPManager.getSp("abtest_info").getString("hw_push_id", null), new Object[] { Boolean.valueOf(SPManager.getSp("abtest_info").getBoolean("hw_push_on", false)), paramString, Long.valueOf(paramLong) });
  }
  
  public static void hwPushWakeup()
  {
    if (!BrandUtil.isEmui()) {}
    while (!"abtest".equals(SPManager.getSp("abtest_info").getString("hw_push_type", null))) {
      return;
    }
    OssHelper.hwPushWakeUp(SPManager.getSp("abtest_info").getString("hw_push_id", null), new Object[] { Boolean.valueOf(SPManager.getSp("abtest_info").getBoolean("hw_push_on", false)) });
  }
  
  private static boolean isEnable(String paramString)
  {
    String str = paramString + "_on";
    paramString = (Method)sMethods.get(paramString);
    SharedPreferences localSharedPreferences = SPManager.getSp("abtest_info");
    if ((paramString != null) && (((OnABTest)paramString.getAnnotation(OnABTest.class)).defaultOn())) {}
    for (boolean bool = true;; bool = false) {
      return localSharedPreferences.getBoolean(str, bool);
    }
  }
  
  public static boolean isEnableHwPush()
  {
    return isEnable("hw_push");
  }
  
  public static boolean isEnableMiPush()
  {
    return isEnable("mi_push");
  }
  
  public static boolean isEnableNotifySub()
  {
    return isEnable("notify_sub");
  }
  
  public static boolean isSendMailByFtn()
  {
    return isEnable("sendmail_by_ftn");
  }
  
  private static boolean isTaskOn(OnABTest.Policy paramPolicy, String paramString, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (QMABTestManager.1.$SwitchMap$com$tencent$qqmail$utilities$abtest$OnABTest$Policy[paramPolicy.ordinal()])
    {
    default: 
      bool1 = paramBoolean;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while ("on".equals(paramString));
      if ("off".equals(paramString)) {
        return false;
      }
      if (!"abtest".equals(paramString)) {
        break;
      }
      bool1 = bool2;
    } while (new Random().nextInt(2) == 1);
    return false;
  }
  
  @OnABTest(defaultOn=true, task="mi_push")
  private static void miPush(boolean paramBoolean, String paramString)
  {
    if (!BrandUtil.isMiui()) {
      clear("mi_push");
    }
    for (;;)
    {
      return;
      if (paramBoolean) {
        QMPushManager.register();
      }
      while ("abtest".equals(paramString))
      {
        OssHelper.miPushAbtest(SPManager.getSp("abtest_info").getString("mi_push_id", null), new Object[] { Boolean.valueOf(paramBoolean) });
        return;
        QMPushManager.unregister(true);
      }
    }
  }
  
  public static void miPushDelay(String paramString, long paramLong)
  {
    if (!BrandUtil.isMiui()) {}
    while ((paramLong < 0L) || (paramLong > 432000L) || (!"abtest".equals(SPManager.getSp("abtest_info").getString("mi_push_type", null)))) {
      return;
    }
    OssHelper.miPushDelay(SPManager.getSp("abtest_info").getString("mi_push_id", null), new Object[] { Boolean.valueOf(SPManager.getSp("abtest_info").getBoolean("mi_push_on", false)), paramString, Long.valueOf(paramLong) });
  }
  
  public static void miPushWakeup()
  {
    if (!BrandUtil.isMiui()) {}
    while (!"abtest".equals(SPManager.getSp("abtest_info").getString("mi_push_type", null))) {
      return;
    }
    OssHelper.miPushWakeUp(SPManager.getSp("abtest_info").getString("mi_push_id", null), new Object[] { Boolean.valueOf(SPManager.getSp("abtest_info").getBoolean("mi_push_on", false)) });
  }
  
  @OnABTest(task="notify_sub")
  private static void notifySub(boolean paramBoolean, String paramString)
  {
    QMLog.log(4, "QMABTestManager", "notifySub, on: " + paramBoolean + ", type: " + paramString);
    if ("abtest".equals(paramString)) {
      OssHelper.notifySubAbtest(SPManager.getSp("abtest_info").getString("notify_sub_id", null), new Object[] { Boolean.valueOf(paramBoolean) });
    }
  }
  
  public static void notifySubReceive(boolean paramBoolean)
  {
    if ("abtest".equals(SPManager.getSp("abtest_info").getString("notify_sub_type", null))) {
      OssHelper.notifySubReceive(SPManager.getSp("abtest_info").getString("notify_sub_id", null), new Object[] { Boolean.valueOf(SPManager.getSp("abtest_info").getBoolean("notify_sub_on", false)), Boolean.valueOf(paramBoolean) });
    }
  }
  
  public static void notifySubWakeup()
  {
    if ("abtest".equals(SPManager.getSp("abtest_info").getString("notify_sub_type", null))) {
      OssHelper.notifySubWakeUp(SPManager.getSp("abtest_info").getString("notify_sub_id", null), new Object[] { Boolean.valueOf(SPManager.getSp("abtest_info").getBoolean("notify_sub_on", false)) });
    }
  }
  
  @OnABTest(defaultOn=true, task="sendmail_by_ftn")
  private static void sendMailByFtn() {}
  
  private static void setEnable(String paramString, boolean paramBoolean)
  {
    paramString = paramString + "_on";
    SPManager.getEditor("abtest_info").putBoolean(paramString, paramBoolean).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.abtest.QMABTestManager
 * JD-Core Version:    0.7.0.1
 */