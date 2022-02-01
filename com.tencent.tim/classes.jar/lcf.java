import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class lcf
{
  private static boolean aiX;
  private static final aczc.b b = new lcg("readinjoy_anti_cheating", false);
  
  private static boolean BI()
  {
    Object localObject = (QQAppInterface)kxm.getAppRuntime();
    if ((localObject == null) || (!((QQAppInterface)localObject).isLogin()))
    {
      QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: NO, app is null or not login, do not request.");
      return false;
    }
    if (aiX)
    {
      QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: NO, isRequestingLbs.");
      return false;
    }
    if (a() != null)
    {
      QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: NO, cache is valid, no need to request.");
      return false;
    }
    localObject = BaseApplicationImpl.getApplication().getApplicationContext();
    if ((localObject != null) && (Build.VERSION.SDK_INT >= 23) && (((Context)localObject).checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0))
    {
      QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: NO, no location permission.");
      return false;
    }
    localObject = Aladdin.getConfig(165);
    if (localObject != null)
    {
      int i = ((AladdinConfig)localObject).getIntegerFromString("lbs_switch", 1);
      QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "lbsSwitch = ", Integer.valueOf(i) });
      if (i != 1)
      {
        QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: NO, switch is OFF, do not request.");
        return false;
      }
      i = ((AladdinConfig)localObject).getIntegerFromString("lbs_request_interval", 2);
      long l1 = ((Long)awit.f("readinjoy_sp_key_app_launch_time", Long.valueOf(System.currentTimeMillis()))).longValue();
      long l2 = (System.currentTimeMillis() - l1) / 1000L / 60L;
      QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "from app launch interval = ", Long.valueOf(l2), ", lbsRequestInterval = ", Integer.valueOf(i), ", appLaunchTime = ", Long.valueOf(l1) });
      if (l2 <= i)
      {
        QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: NO, less than lbs request interval.");
        return false;
      }
      i = ((AladdinConfig)localObject).getIntegerFromString("lbs_day_limit", 1);
      int j = oq();
      QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "lbsDayLimit = ", Integer.valueOf(i), ", todayRequestTime = ", Integer.valueOf(j) });
      if (j >= i)
      {
        QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: NO, over lbs day limit.");
        return false;
      }
    }
    QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: YES !!!");
    return true;
  }
  
  public static void U(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    SosoInterface.SosoLocation localSosoLocation = a();
    if (localSosoLocation != null) {}
    for (;;)
    {
      try
      {
        paramJSONObject.put("longitude", localSosoLocation.ce);
        paramJSONObject.put("latitude", localSosoLocation.cd);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInJoySpEventReportUtil", 2, new Object[] { "json = ", paramJSONObject });
        return;
      }
      catch (JSONException localJSONException)
      {
        QLog.d("ReadInJoySpEventReportUtil", 1, "addLbsInfo e = ", localJSONException);
        continue;
      }
      aJK();
    }
  }
  
  private static SosoInterface.SosoLocation a()
  {
    SosoInterface.SosoLbsInfo localSosoLbsInfo = aczc.a("readinjoy_anti_cheating");
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.a != null)) {
      return localSosoLbsInfo.a;
    }
    return null;
  }
  
  private static void aJK()
  {
    if (BI())
    {
      aczc.a(b);
      aiX = true;
      aJL();
    }
  }
  
  private static void aJL()
  {
    String str = jf();
    Object localObject = (String)awit.f("readinjoy_sp_key_last_request_lbs_date", "");
    QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "updateToadyRequestLbsTime, today = ", str, ", lastRequestLbsDate = ", localObject });
    if (str.equals(localObject))
    {
      localObject = (Integer)awit.f("readinjoy_sp_key_toady_request_lbs_time", Integer.valueOf(0));
      QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "updateToadyRequestLbsTime, todayTime = ", localObject });
      awit.H("readinjoy_sp_key_toady_request_lbs_time", Integer.valueOf(((Integer)localObject).intValue() + 1));
    }
    for (;;)
    {
      awit.H("readinjoy_sp_key_last_request_lbs_date", str);
      return;
      QLog.d("ReadInJoySpEventReportUtil", 1, "updateToadyRequestLbsTime, first time today.");
      awit.H("readinjoy_sp_key_toady_request_lbs_time", Integer.valueOf(1));
    }
  }
  
  public static void init()
  {
    long l = System.currentTimeMillis();
    QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "init, app launch time = ", Long.valueOf(l) });
    awit.H("readinjoy_sp_key_app_launch_time", Long.valueOf(l));
  }
  
  private static String jf()
  {
    return new SimpleDateFormat("yyyy.MM.dd").format(new Date());
  }
  
  private static int oq()
  {
    String str1 = jf();
    String str2 = (String)awit.f("readinjoy_sp_key_last_request_lbs_date", "");
    QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "getToadyRequestLbsTime, today = ", str1, ", lastRequestLbsDate = ", str2 });
    if (str1.equals(str2)) {
      return ((Integer)awit.f("readinjoy_sp_key_toady_request_lbs_time", Integer.valueOf(0))).intValue();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lcf
 * JD-Core Version:    0.7.0.1
 */