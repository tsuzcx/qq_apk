import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReport_Retention_dc03208;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class avzp
{
  public static final Set<String> dx = new HashSet();
  
  public static void p(String paramString, HashMap<String, String> paramHashMap)
  {
    Object localObject = paramHashMap;
    if (paramHashMap == null) {}
    try
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("function_id", paramString);
      paramHashMap = new Properties();
      paramHashMap.putAll((Map)localObject);
      anol.a(BaseApplicationImpl.getContext()).reportKVEvent("qzone_retention_" + paramString, paramHashMap);
      return;
    }
    catch (Exception paramString)
    {
      QZLog.e("Retention.Report", "统计率上报失败", paramString);
    }
  }
  
  public static void report(int paramInt)
  {
    report(String.valueOf(paramInt), null);
  }
  
  public static void report(String paramString, HashMap<String, String> paramHashMap)
  {
    if (tD(paramString))
    {
      i = QzoneConfig.getInstance().getConfig("ClientReport", "retention_report", 0);
      if ((i == 0) || (i == 2)) {
        p(paramString, paramHashMap);
      }
      if ((i == 0) || (i == 1)) {
        LpReport_Retention_dc03208.report(paramString, paramHashMap);
      }
      if (QZLog.isColorLevel()) {
        QZLog.i("Retention.Report", 2, new Object[] { "RetentionReport, functionid:", paramString });
      }
    }
    while (!QZLog.isColorLevel())
    {
      int i;
      return;
    }
    QZLog.i("Retention.Report", 2, new Object[] { "not meet condition, functionid:", paramString });
  }
  
  public static boolean tD(String paramString)
  {
    if (dx.size() == 0)
    {
      Object localObject = QzoneConfig.getInstance().getConfig("ClientReport", "retention_report_blacklist", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            CharSequence localCharSequence = localObject[i];
            if (!TextUtils.isEmpty(localCharSequence)) {}
            try
            {
              dx.add(localCharSequence);
              i += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QZLog.e("Retention.Report", "meetConditon error", localException);
              }
            }
          }
        }
      }
    }
    return (dx.size() <= 0) || (!dx.contains(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avzp
 * JD-Core Version:    0.7.0.1
 */