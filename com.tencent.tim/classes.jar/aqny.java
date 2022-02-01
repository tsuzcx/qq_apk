import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.confighandler.ConfigHandler;
import com.tencent.qphone.base.util.QLog;

public class aqny
{
  public static PromotionConfigInfo a(String paramString1, String paramString2)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString2))
        {
          Object localObject = m(paramString1);
          if (localObject != null)
          {
            paramString2 = ((SharedPreferences)localObject).getString("config", null);
            QLog.w(adca.TAG, 1, "ConfigInfo.get, step[" + i + "], configText[" + paramString2 + "]");
            localObject = new PromotionConfigInfo();
            ((PromotionConfigInfo)localObject).setUin(paramString1);
            if (!TextUtils.isEmpty(paramString2)) {
              ((PromotionConfigInfo)localObject).tryParse(adca.TAG, paramString2);
            }
            return localObject;
          }
          i = 2;
          continue;
        }
        i = 0;
      }
      finally {}
    }
  }
  
  public static SharedPreferences b(String paramString1, String paramString2)
  {
    return aqnz.a(adca.TAG, paramString1, "res_qq.android.ar_" + paramString2);
  }
  
  public static boolean b(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    return BusinessCommonConfig.isResReady(adca.TAG + "_" + paramString2, b(paramString1, paramString2), "md5_" + paramInt, paramString3, paramString4);
  }
  
  public static int fn(String paramString)
  {
    int i = 0;
    paramString = n(paramString);
    if (paramString != null) {
      i = ConfigHandler.getConfigVer(paramString, "config", "ver");
    }
    return i;
  }
  
  public static int fo(String paramString)
  {
    int i = 0;
    paramString = m(paramString);
    if (paramString != null) {
      i = ConfigHandler.getConfigVer(paramString, "config", "ver");
    }
    return i;
  }
  
  public static void h(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    BusinessCommonConfig.saveMd5(adca.TAG, b(paramString1, paramString2), "md5_" + paramInt, paramString3);
  }
  
  public static SharedPreferences m(String paramString)
  {
    return aqnz.a(adca.TAG, paramString, "config_qq.android.ar_");
  }
  
  public static SharedPreferences n(String paramString)
  {
    return aqnz.a(adca.TAG, paramString, "res_qq.android.ar_");
  }
  
  public static String pI(String paramString)
  {
    Object localObject = null;
    SharedPreferences localSharedPreferences = n(paramString);
    paramString = localObject;
    if (localSharedPreferences != null) {
      paramString = localSharedPreferences.getString("config", null);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqny
 * JD-Core Version:    0.7.0.1
 */