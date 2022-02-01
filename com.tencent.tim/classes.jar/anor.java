import NS_MOBILE_EXTRA.mobile_get_qzone_public_msg_rsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

public class anor
{
  private static AtomicLong J;
  private static anor.a a = new anor.a();
  private static long amJ;
  public static boolean cIV;
  private static Calendar calendar;
  private static AtomicInteger cc;
  private static int dKM = 2;
  private static int dKN;
  public static int dKO;
  private static int dKP;
  private static AtomicBoolean dP;
  private static int failed;
  
  static
  {
    cc = new AtomicInteger(2);
    dKO = 3;
    dP = new AtomicBoolean(false);
    J = new AtomicLong();
    calendar = Calendar.getInstance();
  }
  
  public static int Kj()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    String str = ((AppRuntime)localObject).getAccount();
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneReport", 2, "qzone report with empty account");
      }
      return -1;
    }
    if (!((acja)((AppRuntime)localObject).getManager(56)).f(Long.valueOf(Long.parseLong("2290230341"))))
    {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneReport", 2, "haven't yet follow qzone");
      }
      return -1;
    }
    long l = NetConnInfoCenter.getServerTime();
    if (amJ == 0L)
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime().getPreferences();
      dKM = ((SharedPreferences)localObject).getInt(str + "_" + "qzone_xp_max_req", 2);
      amJ = ((SharedPreferences)localObject).getLong(str + "_" + "qzone_xp_first_req", l);
      cc.set(((SharedPreferences)localObject).getInt(str + "_" + "qzone_xp_req_left", dKM));
      dKO = ((SharedPreferences)localObject).getInt(str + "_" + "qzone_xp_req_gap", 3);
      calendar.setTimeInMillis(amJ * 1000L);
      dKP = calendar.get(5);
      failed = 0;
      dP.set(false);
    }
    if ((failed >= 5) || (dP.get()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneReport", 2, "retry: " + failed + ", sending: " + dP.get());
      }
      return -1;
    }
    calendar.setTimeInMillis(l * 1000L);
    if (calendar.get(5) != dKP)
    {
      amJ = l;
      cc.set(dKM);
      BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt(str + "_" + "qzone_xp_req_left", dKM).putLong(str + "_" + "qzone_xp_first_req", amJ).apply();
    }
    if (cc.get() <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneReport", 2, "left: 0");
      }
      calendar.set(5, calendar.get(5) + 1);
      calendar.set(11, 0);
      calendar.set(12, 0);
      calendar.set(13, 0);
      return (int)((calendar.getTimeInMillis() - l * 1000L) / 1000L);
    }
    return Math.max(0, (int)(dKN - l));
  }
  
  public static void S(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZoneReport", 2, "sending");
    }
    dP.set(true);
    J.set(NetConnInfoCenter.getServerTime());
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), anex.class);
    localNewIntent.putExtra("key_uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localNewIntent.putExtra("has_photo", str);
      BaseApplicationImpl.getApplication().getRuntime().registObserver(a);
      BaseApplicationImpl.getApplication().getRuntime().startServlet(localNewIntent);
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X800915C", "0X800915C", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public static void Vk(int paramInt)
  {
    if ((paramInt == 1) && (cIV)) {
      return;
    }
    if (paramInt == 1) {
      cIV = true;
    }
    LpReportInfo_dc02880 localLpReportInfo_dc02880 = new LpReportInfo_dc02880(6, paramInt);
    LpReportManager.getInstance().reportToDC02880(localLpReportInfo_dc02880, false, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, int paramInt, String paramString)
  {
    int i = paramConfig.version.get();
    int j = aqmj.i(paramQQAppInterface.getApp(), "qzone_xp_config_version", paramString);
    if (QLog.isColorLevel()) {
      QLog.i("QZoneReport", 2, String.format(Locale.getDefault(), "received qzone xp Config remote version: %d, localVersion: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    }
    if (i != j)
    {
      paramConfig = aevk.a(paramConfig, j, paramInt);
      if (!TextUtils.isEmpty(paramConfig)) {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneReport", 2, "receiveAllConfigs|type: " + paramInt + ",content: " + paramConfig + ",version: " + i);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        try
        {
          paramInt = Math.max(0, dKM - cc.get());
          paramConfig = new JSONObject(paramConfig);
          dKM = paramConfig.optInt("maxReq", 2);
          cc.set(Math.max(0, dKM - paramInt));
          dKO = paramConfig.optInt("reqGap", 3);
          BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt(paramString + "_" + "qzone_xp_max_req", dKM).putInt(paramString + "_" + "qzone_xp_req_gap", dKO).putInt(paramString + "_" + "qzone_xp_req_left", cc.get()).apply();
          aqmj.g(paramQQAppInterface.getApp(), "qzone_xp_config_version", paramString, i);
          return;
        }
        catch (JSONException paramConfig)
        {
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              paramConfig.printStackTrace();
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.i("QZoneReport", 2, "config is null");
      return;
    }
    QLog.i("QZoneReport", 2, "config version not updated, nothing to do");
  }
  
  public static void clear()
  {
    amJ = 0L;
  }
  
  public static void dV(QQAppInterface paramQQAppInterface)
  {
    avzf.a().a(new anos(paramQQAppInterface));
    long l = LocalMultiProcConfig.getLong("SP_LAST_UPDATE_TIME", 0L);
    QLog.d("[PhotoAlbum]QZoneReport", 1, new Object[] { "getTravelGroup SP_LAST_UPDATE_TIME lastUpdateTime:", Long.valueOf(l) });
    avzf.a().a().nO(l);
  }
  
  static class a
    extends akln
  {
    protected void M(boolean paramBoolean, Bundle paramBundle)
    {
      paramBundle = paramBundle.getSerializable("data");
      if ((paramBoolean) && (paramBundle != null) && ((paramBundle instanceof mobile_get_qzone_public_msg_rsp)))
      {
        int i = anor.cc.decrementAndGet();
        anor.access$102(0);
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        localAppRuntime.getPreferences().edit().putInt(localAppRuntime.getAccount() + "_" + "qzone_xp_req_left", i).apply();
        anor.access$202(((mobile_get_qzone_public_msg_rsp)paramBundle).next_req_tmstamp);
        if (QLog.isColorLevel()) {
          QLog.i("QZoneReport", 2, "next req time: " + anor.dKN + ", left: " + i);
        }
        anot.a(null, "CliOper", "", "", "0X800915D", "0X800915D", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        anor.e().set(false);
        BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(anor.a());
        return;
        anor.access$108();
        if (QLog.isColorLevel()) {
          QLog.w("QZoneReport", 2, "qzone report failed");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anor
 * JD-Core Version:    0.7.0.1
 */