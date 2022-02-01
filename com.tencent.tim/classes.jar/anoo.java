import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.pluginsdk.IStatisticsUploader;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class anoo
  implements IStatisticsUploader
{
  public static final Random random = new Random();
  
  public static void J(String paramString, int paramInt, long paramLong)
  {
    if (random.nextInt(1000) != 0) {}
    do
    {
      do
      {
        return;
        localObject1 = new HashMap();
        ((HashMap)localObject1).put(BaseConstants.RDM_NoChangeFailCode, String.valueOf(paramInt));
        ((HashMap)localObject1).put("plugin_name", paramString);
        ((HashMap)localObject1).put("cost", String.valueOf(paramLong));
        ((HashMap)localObject1).put("result", String.valueOf(paramInt));
        localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      } while (localObject2 == null);
      Object localObject2 = ((AppRuntime)localObject2).getAccount();
      anpc.a(MobileQQ.sMobileQQ).collectPerformance((String)localObject2, "actPluginDexa2OatInfo", false, paramLong, 0L, (HashMap)localObject1, null);
    } while (!QLog.isColorLevel());
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("uploadDexOatInfo pluginId ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(String.valueOf(paramInt));
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(paramLong);
    QLog.d("PluginStatisticsCollector", 2, ((StringBuilder)localObject1).toString());
  }
  
  public void uploadStartupFailure(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    boolean bool = false;
    if ("success".equals(paramString5)) {
      bool = true;
    }
    String str = paramString5;
    if (paramString5 != null)
    {
      str = paramString5;
      if (paramString5.contains(ClassNotFoundException.class.getName()))
      {
        float f = aqhq.getAvailableInnernalMemorySize();
        str = "GetAvailableInnernalMemorySize:" + f + "__" + paramString5;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginStatisticsCollector", 2, "uploadStartupFailure result = " + bool + ", pluginName = " + paramString2 + ", extraInfo = " + str);
    }
    if (!bool)
    {
      paramString5 = new HashMap();
      paramString5.put(BaseConstants.RDM_NoChangeFailCode, "");
      paramString5.put("plugin_name", paramString2);
      paramString5.put("plugin_loc", paramString3);
      paramString5.put("plugin_activity", paramString4);
      paramString5.put("plugin_extra_info", str);
      anpc.a(paramContext).collectPerformance(paramString1, "actPluginStartupFailure", bool, 0L, 0L, paramString5, null);
    }
    paramString3 = new HashMap();
    paramString3.put(BaseConstants.RDM_NoChangeFailCode, "");
    paramString3.put("plugin_name", paramString2);
    anpc.a(paramContext).collectPerformance(paramString1, "actPluginStartupResult", bool, 0L, 0L, paramString3, null);
  }
  
  public void uploadStartupSpeedInfo(Context paramContext, Intent paramIntent)
  {
    long l1 = paramIntent.getLongExtra("launchTotal", 0L);
    long l2 = paramIntent.getLongExtra("pluginApkCost", 0L);
    long l3 = paramIntent.getLongExtra("pluginOatCost", 0L);
    long l4 = paramIntent.getLongExtra("pluginDownloadCost", 0L);
    long l5 = paramIntent.getLongExtra("pluginLibCost", 0L);
    long l6 = paramIntent.getLongExtra("pluginLoaderCost", 0L);
    String str1 = paramIntent.getStringExtra("launchComponent");
    String str2 = paramIntent.getStringExtra("launchProcName");
    String str3 = paramIntent.getStringExtra("pluginsdk_selfuin");
    String str4 = paramIntent.getStringExtra("pluginsdk_pluginName");
    String str5 = paramIntent.getStringExtra("pluginsdk_pluginLocation");
    String str6 = paramIntent.getStringExtra("pluginsdk_pluginpath");
    paramIntent = paramIntent.getStringExtra("pluginsdk_launchActivity");
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("plugin_name", str4);
    localHashMap.put("plugin_loc", str5);
    localHashMap.put("plugin_activity", paramIntent);
    localHashMap.put("plugin_extra_info", str6);
    localHashMap.put("pluginOatCost", String.valueOf(l3));
    localHashMap.put("pluginApkCost", String.valueOf(l2));
    localHashMap.put("pluginLoaderCost", String.valueOf(l6));
    localHashMap.put("launchTotal", String.valueOf(l1));
    anpc.a(paramContext).collectPerformance(str3, "actPluginSpeedInfoV2", false, l1, 0L, localHashMap, null);
    QLog.d("plugin_tag", 1, "uploadStartupSpeedInfo  " + str5 + ", launchTotal " + l1 + ", apkCost " + l2 + ", dex2OatCost " + l3 + ", libCost " + l5 + ", downloadCost " + l4 + ", loaderCost " + l6 + ", launchComponent " + str1 + ", procName " + str2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anoo
 * JD-Core Version:    0.7.0.1
 */