import android.content.Context;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.Calendar;
import java.util.Map;
import org.json.JSONObject;

public class acyu
{
  private static long RD;
  public static final int canOpenApp = QzoneConfig.getInstance().getConfig("qqminiapp", "miniapp_able2show", 1);
  
  public static boolean bN(long paramLong)
  {
    return paramLong > fe();
  }
  
  public static int dp2px(Context paramContext, int paramInt)
  {
    return aqcx.dip2px(paramContext, paramInt);
  }
  
  public static boolean f(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQDailyUtils", 2, "param is null");
      }
      return false;
    }
    String str1 = (String)paramMap.get("appname");
    String str2 = (String)paramMap.get("appview");
    String str3 = (String)paramMap.get("appversion");
    paramMap = (String)paramMap.get("metaData");
    if (QLog.isColorLevel()) {
      QLog.d("QQDailyUtils", 2, "appName: " + str1 + "\nappView: " + str2 + "\nappVersion: " + str3 + "\nmetaData: " + paramMap);
    }
    return (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(paramMap));
  }
  
  private static long fe()
  {
    long l = System.currentTimeMillis() / 1000L;
    if ((RD != 0L) && (86400L + RD > l)) {
      return RD;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    l = localCalendar.getTimeInMillis() / 1000L;
    RD = l;
    return l;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
  }
  
  public static String jG(String paramString)
  {
    String str = "{" + paramString + "}";
    paramString = "";
    try
    {
      str = new JSONObject(str).get("metaData").toString();
      paramString = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQDailyUtils", 2, localException, new Object[0]);
    }
    return paramString;
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acyu
 * JD-Core Version:    0.7.0.1
 */