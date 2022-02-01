import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfig;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class afam
{
  private static NativeMonitorConfig a = new NativeMonitorConfig();
  private static String aWF = "";
  private static boolean bXa;
  
  public static void HE(boolean paramBoolean)
  {
    if (AppSetting.aNU) {}
    do
    {
      do
      {
        return;
        paramBoolean = anpt.ayJ();
        if ((paramBoolean) && (Build.VERSION.SDK_INT <= 27) && (Build.VERSION.SDK_INT > 15) && (!AppSetting.aNU)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("NativeMonitorConfig", 2, "arm: " + paramBoolean + ", useASan: " + AppSetting.aNU);
      return;
      if (Build.VERSION.SDK_INT < 21)
      {
        QLog.i("NativeMonitorConfig", 1, "skip in release");
        return;
      }
      localObject1 = a(BaseApplicationImpl.getApplication().getRuntime());
      if (localObject1 != null)
      {
        BaseApplicationImpl.sNativeMonitorEscapedMsg = "open: " + ((NativeMonitorConfig)localObject1).getNativeMonitorOpened() + ", flag: " + ((NativeMonitorConfig)localObject1).getSwitchFlag();
        acmp.hQ(a.getTmChance());
      }
    } while ((localObject1 == null) || (((NativeMonitorConfig)localObject1).getNativeMonitorOpened() != 1));
    Object localObject2 = ((NativeMonitorConfig)localObject1).getAndroidVersionBlackList();
    long l2 = ((NativeMonitorConfig)localObject1).getSwitchFlag();
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = ((String)localObject2).split("\\|");
      if (localObject2 != null)
      {
        String str = Build.VERSION.SDK_INT + "";
        int j = localObject2.length;
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label264;
          }
          if (str.equals(localObject2[i])) {
            break;
          }
          i += 1;
        }
      }
    }
    label264:
    if (a((NativeMonitorConfig)localObject1))
    {
      QLog.i("NativeMonitorConfig", 1, "process id:" + BaseApplicationImpl.sProcessId + "  is in black list");
      return;
    }
    QLog.i("NativeMonitorConfig", 1, "process id:" + BaseApplicationImpl.sProcessId + "  not in black list");
    long l1 = l2;
    if (Build.VERSION.SDK_INT >= 21) {
      l1 = l2 & 0xFFFFFFFB;
    }
    l2 = l1;
    if (Build.VERSION.SDK_INT != 21)
    {
      l2 = l1;
      if (Build.VERSION.SDK_INT != 22) {
        l2 = l1 & 0xFFFFFFBF;
      }
    }
    localObject2 = ((NativeMonitorConfig)localObject1).getSoWhiteList();
    Object localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = ((String)localObject2).trim();
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      return;
      ((String)localObject1).split("\\|");
    }
  }
  
  private static NativeMonitorConfig a(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = paramSharedPreferences.getString(paramString + "_" + "native_monitor_config_content", "");
    if (!TextUtils.isEmpty(paramSharedPreferences)) {
      try
      {
        paramSharedPreferences = new JSONObject(paramSharedPreferences);
        return (NativeMonitorConfig)aiio.convertFromJSONObject(paramSharedPreferences, NativeMonitorConfig.class);
      }
      catch (JSONException paramSharedPreferences)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            paramSharedPreferences.printStackTrace();
          }
          paramSharedPreferences = null;
        }
      }
    }
    return null;
  }
  
  public static NativeMonitorConfig a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      String str = paramAppRuntime.getAccount();
      if ((!bXa) || (!aWF.equals(str)))
      {
        paramAppRuntime = PreferenceManager.getDefaultSharedPreferences(paramAppRuntime.getApplication());
        if (paramAppRuntime.contains(str + "_" + "native_monitor_config_version"))
        {
          paramAppRuntime = a(paramAppRuntime, str);
          if (paramAppRuntime != null) {
            a(paramAppRuntime);
          }
        }
        aWF = str;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NativeMonitorConfig", 2, "NativeMonitorConfig:" + a.toString());
    }
    bXa = true;
    return a;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, ConfigurationService.Config paramConfig)
  {
    int j = paramConfig.version.get();
    int i = aqmj.bo(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int k = aqmj.bp(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int m = AppSetting.getAppId();
    if (QLog.isColorLevel()) {
      QLog.d("NativeMonitorConfig", 1, String.format("received nativeMonitorConfig remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m) }));
    }
    if (k != m)
    {
      aqmj.aC(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), m);
      i = 0;
    }
    String str;
    if (j != i)
    {
      str = aevk.a(paramConfig, i, paramInt);
      if (!TextUtils.isEmpty(str)) {
        QLog.d("NativeMonitorConfig", 1, "receiveAllConfigs|type: " + paramInt + ",content: " + str + ",version: " + j);
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new JSONObject(str);
        paramConfig = (NativeMonitorConfig)aiio.convertFromJSONObject(paramConfig, NativeMonitorConfig.class);
        if (paramConfig == null)
        {
          a(new NativeMonitorConfig());
          aqmj.h(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), j, "");
          aqmj.aN(paramQQAppInterface.getApp(), 0);
          QLog.d("NativeMonitorConfig", 1, "Resolve Config failure, use default config");
          HE(true);
          return;
        }
      }
      catch (JSONException paramConfig)
      {
        if (QLog.isDevelopLevel()) {
          paramConfig.printStackTrace();
        }
        paramConfig = null;
        continue;
        QLog.d("NativeMonitorConfig", 1, "start to update config:" + paramConfig.toString());
        if (paramConfig.getTimeLimited() <= 0L)
        {
          paramConfig.setTimeLimitedDefault();
          if (QLog.isColorLevel()) {
            QLog.d("NativeMonitorConfig", 2, "time limited is too small, setToDefault");
          }
        }
        if (paramConfig.getMemoryLimited() <= 0L)
        {
          paramConfig.setMemoryLimitedDefault();
          if (QLog.isColorLevel()) {
            QLog.d("NativeMonitorConfig", 2, "memory limited is too small, setToDefault");
          }
        }
        if (paramConfig.getCountLimted() <= 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("NativeMonitorConfig", 2, "count limited is too small, setToDefault");
          }
          paramConfig.setCountLimitedDefault();
        }
        if (QLog.isColorLevel()) {
          QLog.d("NativeMonitorConfig", 2, "soHook = " + paramConfig.soHook);
        }
        a(paramConfig);
        aqmj.h(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), j, str);
        aqmj.aN(paramQQAppInterface.getApp(), paramConfig.soHook);
        continue;
      }
      a(new NativeMonitorConfig());
      aqmj.h(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), j, "");
      aqmj.aN(paramQQAppInterface.getApp(), 0);
      QLog.d("NativeMonitorConfig", 1, "config is null, use default config");
      continue;
      QLog.d("NativeMonitorConfig", 1, "config version not updated, nothing to do");
    }
  }
  
  public static void a(NativeMonitorConfig paramNativeMonitorConfig)
  {
    bXa = true;
    a.update(paramNativeMonitorConfig);
  }
  
  private static boolean a(@NonNull NativeMonitorConfig paramNativeMonitorConfig)
  {
    boolean bool2 = false;
    paramNativeMonitorConfig = paramNativeMonitorConfig.getProcessBlackList();
    boolean bool1;
    int j;
    int i;
    if (TextUtils.isEmpty(paramNativeMonitorConfig))
    {
      paramNativeMonitorConfig = null;
      bool1 = bool2;
      if (paramNativeMonitorConfig != null)
      {
        j = paramNativeMonitorConfig.length;
        i = 0;
      }
    }
    label96:
    for (;;)
    {
      bool1 = bool2;
      String str;
      if (i < j) {
        str = paramNativeMonitorConfig[i];
      }
      try
      {
        int k = Integer.valueOf(str).intValue();
        if (k != BaseApplicationImpl.sProcessId) {
          break label96;
        }
        bool1 = true;
        return bool1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (!QLog.isColorLevel()) {
          break label96;
        }
        QLog.d("NativeMonitorConfig", 2, localNumberFormatException, new Object[0]);
        i += 1;
      }
      paramNativeMonitorConfig = paramNativeMonitorConfig.split("\\|");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afam
 * JD-Core Version:    0.7.0.1
 */