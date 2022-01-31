import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.pb.PBInt32Field;
import org.json.JSONObject;

public class yjx
{
  private static boolean a;
  
  public static void a()
  {
    yny.b("GdtAnalysisConfigUtil", "handleNotResponse");
  }
  
  public static void a(ConfigurationService.Config paramConfig)
  {
    if ((paramConfig == null) || (paramConfig.type.get() != 237))
    {
      yny.d("GdtAnalysisConfigUtil", "handleResponse error");
      return;
    }
    Object localObject = null;
    try
    {
      paramConfig = amnh.b(paramConfig, 0, paramConfig.type.get());
      a(paramConfig);
      yny.b("GdtAnalysisConfigUtil", String.format("handleResponse %s", new Object[] { paramConfig }));
      return;
    }
    catch (Throwable paramConfig)
    {
      for (;;)
      {
        yny.d("GdtAnalysisConfigUtil", "handleResponse", paramConfig);
        paramConfig = localObject;
      }
    }
  }
  
  public static void a(ConfigurationService.ConfigSeq paramConfigSeq)
  {
    if (paramConfigSeq == null)
    {
      yny.d("GdtAnalysisConfigUtil", "handleRequest error");
      return;
    }
    yny.b("GdtAnalysisConfigUtil", "handleRequest");
    paramConfigSeq.version.set(0);
    paramConfigSeq.compress.set(1);
  }
  
  private static void a(String paramString)
  {
    boolean bool = true;
    yny.b("GdtAnalysisConfigUtil", String.format("parseResponse %s", new Object[] { paramString }));
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = ynw.a(paramString);
    } while ((paramString == null) || (paramString == JSONObject.NULL));
    for (;;)
    {
      try
      {
        if (Integer.valueOf(paramString.getJSONObject("sdkConfiguration").getString("GdtAdMonitorSwitch")).intValue() != 0)
        {
          a = bool;
          yny.b("GdtAnalysisConfigUtil", String.format("parseResponse enabled:%b", new Object[] { Boolean.valueOf(a) }));
          return;
        }
      }
      catch (Throwable paramString)
      {
        yny.d("GdtAnalysisConfigUtil", "parseResponse", paramString);
        return;
      }
      bool = false;
    }
  }
  
  public static boolean a()
  {
    if (BaseApplicationImpl.getApplication() == null) {}
    while (BaseApplicationImpl.getApplication().getRuntime() == null) {
      return false;
    }
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return a;
    }
    return yjw.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yjx
 * JD-Core Version:    0.7.0.1
 */