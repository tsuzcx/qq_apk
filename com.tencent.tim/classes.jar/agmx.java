import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.MobileQQ;

public class agmx
{
  public static boolean cen;
  public static boolean ceo;
  public static boolean cep = true;
  private static boolean ceq = true;
  private static boolean cer = true;
  QQAppInterface app;
  
  public agmx(QQAppInterface paramQQAppInterface, ahav.c paramc, long paramLong)
  {
    this.app = paramQQAppInterface;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfigV2", 0).edit();
    paramQQAppInterface.clear();
    Object localObject1 = (HashMap)paramc.getMapResult().get("OnlinePreView");
    Object localObject2 = ((HashMap)localObject1).keySet().iterator();
    Object localObject3;
    Object localObject4;
    Object localObject5;
    String str1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = (HashMap)((HashMap)localObject1).get(localObject3);
      localObject5 = ((HashMap)localObject4).keySet().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        str1 = (String)((Iterator)localObject5).next();
        String str2 = String.valueOf(((HashMap)localObject4).get(str1));
        paramQQAppInterface.putString(("OnlinePreView" + (String)localObject3 + str1).toLowerCase(), str2);
      }
    }
    paramc = (HashMap)paramc.getMapResult().get("OfflineConfig");
    localObject1 = paramc.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = paramc.get(localObject2);
      if ((localObject3 instanceof HashMap))
      {
        localObject3 = (HashMap)localObject3;
        localObject4 = ((HashMap)localObject3).keySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          str1 = String.valueOf(((HashMap)localObject3).get(localObject5));
          paramQQAppInterface.putString(("OfflineConfig" + (String)localObject2 + (String)localObject5).toLowerCase(), str1);
        }
      }
      else if ((localObject3 instanceof String))
      {
        paramQQAppInterface.putString(("OfflineConfig" + (String)localObject2).toLowerCase(), (String)localObject3);
      }
    }
    paramQQAppInterface.putLong("FileOnlinePreviewVersionKey", paramLong);
    long l = anaz.gQ();
    paramQQAppInterface.putLong("FMConfigUpdateLastTime", l);
    paramQQAppInterface.commit();
    QLog.i("FMConfig<FileAssistant>", 1, "commit Config data, time[" + l + "], ver[" + paramLong + "]");
  }
  
  public static int Es()
  {
    int i;
    try
    {
      i = Integer.parseInt(y(BaseApplicationImpl.getContext(), "TimAioCount"));
      if ((i != 0) && (TextUtils.isEmpty(vi()))) {
        return 0;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = 0;
      }
    }
    return i;
  }
  
  public static boolean aE(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("file_config_" + paramQQAppInterface.getCurrentUin(), 0).getBoolean("https_c2c_up", false);
  }
  
  public static boolean aF(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("file_config_" + paramQQAppInterface.getCurrentUin(), 0).getBoolean("https_c2c_down", false);
  }
  
  public static boolean aG(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("file_config_" + paramQQAppInterface.getCurrentUin(), 0).getBoolean("https_c2czip_down", false);
  }
  
  public static boolean aH(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("file_config_" + paramQQAppInterface.getCurrentUin(), 0).getBoolean("https_c2c_thumb", false);
  }
  
  public static boolean aI(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("file_config_" + paramQQAppInterface.getCurrentUin(), 0).getBoolean("https_disc_up", false);
  }
  
  public static boolean aJ(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("file_config_" + paramQQAppInterface.getCurrentUin(), 0).getBoolean("https_disc_down", false);
  }
  
  public static boolean aK(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("file_config_" + paramQQAppInterface.getCurrentUin(), 0).getBoolean("https_disczip_down", false);
  }
  
  public static boolean aL(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("file_config_" + paramQQAppInterface.getCurrentUin(), 0).getBoolean("https_disc_thumb", false);
  }
  
  public static boolean alL()
  {
    boolean bool = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131697129), "qqsetting_auto_receive_pic_key", true);
    QLog.i("FMConfig<FileAssistant>", 1, "PreloadThumb switch is[" + bool + "]");
    return bool;
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return w(paramContext, paramString1 + paramString2 + paramString3);
  }
  
  public static long fJ()
  {
    long l1 = Long.parseLong(ahav.kX("OfflineConfigFlowSize"));
    try
    {
      long l2 = Long.parseLong(y(BaseApplicationImpl.getContext(), "FlowSize"));
      l1 = l2;
    }
    catch (Exception localException)
    {
      label24:
      break label24;
    }
    return l1 * 1024L + 1L;
  }
  
  public static long fK()
  {
    long l1 = Long.parseLong(ahav.kX("OfflineConfigFlowTime"));
    try
    {
      long l2 = Long.parseLong(y(BaseApplicationImpl.getContext(), "FlowTime"));
      l1 = l2;
    }
    catch (Exception localException)
    {
      label25:
      break label25;
    }
    return l1 * 60L;
  }
  
  public static long fL()
  {
    long l1 = Long.parseLong(ahav.kX("OfflineConfigFtnThumbMaxSize"));
    try
    {
      long l2 = Long.parseLong(y(BaseApplicationImpl.getContext(), "FtnThumbMaxSize"));
      l1 = l2;
    }
    catch (Exception localException)
    {
      label25:
      break label25;
    }
    return l1 * 1024L;
  }
  
  public static String j(Context paramContext, String paramString1, String paramString2)
  {
    return b(paramContext, "OnlinePreView", ahbj.getExtension(paramString1).replace(".", ""), paramString2);
  }
  
  public static String vi()
  {
    Object localObject1 = "";
    try
    {
      localObject2 = y(BaseApplicationImpl.getContext(), "TimGuideUrl");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label16:
      break label16;
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "https://mma.qq.com/tim/timoffice/office.html";
    }
    return localObject2;
  }
  
  public static String w(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("OfflineFileConfigV2", 0).getString(paramString.toLowerCase(), null);
    if ((paramContext != null) && (paramContext.length() > 0)) {
      return paramContext;
    }
    return ahav.kX(paramString);
  }
  
  public static String y(Context paramContext, String paramString)
  {
    return b(paramContext, "OfflineConfig", paramString, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agmx
 * JD-Core Version:    0.7.0.1
 */