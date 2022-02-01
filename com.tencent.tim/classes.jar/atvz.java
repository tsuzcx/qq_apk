import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class atvz
{
  public static boolean cen;
  public static boolean ceo;
  public static boolean cep = true;
  
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
    long l1 = Long.parseLong(audx.kX("OfflineConfigFlowSize"));
    try
    {
      long l2 = Long.parseLong(y(BaseApplicationImpl.getContext(), "FlowSize"));
      l1 = l2;
    }
    catch (Exception localException)
    {
      label23:
      break label23;
    }
    return l1 * 1024L + 1L;
  }
  
  public static long fK()
  {
    long l1 = Long.parseLong(audx.kX("OfflineConfigFlowTime"));
    try
    {
      long l2 = Long.parseLong(y(BaseApplicationImpl.getContext(), "FlowTime"));
      l1 = l2;
    }
    catch (Exception localException)
    {
      label23:
      break label23;
    }
    return l1 * 60L;
  }
  
  public static long fL()
  {
    long l1 = Long.parseLong(audx.kX("OfflineConfigFtnThumbMaxSize"));
    try
    {
      long l2 = Long.parseLong(y(BaseApplicationImpl.getContext(), "FtnThumbMaxSize"));
      l1 = l2;
    }
    catch (Exception localException)
    {
      label23:
      break label23;
    }
    return l1 * 1024L;
  }
  
  public static String j(Context paramContext, String paramString1, String paramString2)
  {
    return b(paramContext, "OnlinePreView", aueh.getExtension(paramString1).replace(".", ""), paramString2);
  }
  
  public static String w(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("OfflineFileConfigV2", 0).getString(paramString.toLowerCase(), null);
    if ((paramContext != null) && (paramContext.length() > 0)) {
      return paramContext;
    }
    return audx.kX(paramString);
  }
  
  public static String y(Context paramContext, String paramString)
  {
    return b(paramContext, "OfflineConfig", paramString, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atvz
 * JD-Core Version:    0.7.0.1
 */