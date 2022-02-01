import android.content.Intent;
import android.telephony.TelephonyManager;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AuthDevUgActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.statistics.Reporting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class anot
{
  public static final HashMap<String, anot.a> nx = new HashMap();
  
  static
  {
    nx.put("dc01160", new kzz());
  }
  
  private static String Aj()
  {
    int i = aqgz.getCpuNumber();
    long l = aqgz.getSystemTotalMemory() / 1024L / 1024L;
    long[] arrayOfLong = aqgz.getRomMemroy();
    String str2 = ((TelephonyManager)BaseApplicationImpl.getContext().getSystemService("phone")).getNetworkOperator();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    str2 = String.format("%.2f", new Object[] { Double.valueOf(aqgz.A()) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i).append(";").append(l).append(";").append(arrayOfLong[0]).append(";").append(arrayOfLong[1]).append(";").append(str1.replaceAll(";", "")).append(";").append(str2).append(";").append(azbx.SCREEN_WIDTH).append(";").append(azbx.cIE).append(";");
    str1 = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "getExtraDeviceInfo=" + str1);
    }
    return str1;
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      localStringBuilder.append(paramString2).append('|');
    }
    if (paramString1.equals("dc01440")) {
      localStringBuilder.append("0").append('|');
    }
    localStringBuilder.append(paramString3).append('|');
    localStringBuilder.append(paramString4).append('|');
    localStringBuilder.append(paramString5).append('|');
    localStringBuilder.append(paramString6).append('|');
    localStringBuilder.append(paramInt1).append('|');
    localStringBuilder.append("${count_unknown}").append('|');
    localStringBuilder.append(paramInt3).append('|');
    localStringBuilder.append(paramString7).append('|');
    localStringBuilder.append(paramString8).append('|');
    localStringBuilder.append(paramString9).append('|');
    localStringBuilder.append(paramString10).append('|');
    return localStringBuilder.toString();
  }
  
  private static String a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    String str = "";
    if (paramBoolean) {
      str = NetConnInfoCenter.getSystemNetStateString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(NetConnInfoCenter.getServerTime()).append("|").append(AppSetting.getAppId()).append("|").append("android").append("|").append(paramString1).append("|").append(paramString2).append("|").append(paramString3).append("|").append(paramString4).append("|").append(paramString5).append("|").append(paramInt).append("|").append(paramString6).append("|").append(aqgz.getIMEI()).append("|").append("|").append(aqgz.BY()).append("|").append(aqgz.getModel()).append("|").append(str).append("|").append(aqgz.getDeviceOSVersion()).append("|").append(ROMUtil.getRomDetailInfo()).append("|").append(paramString7).append("|").append(paramString8).append("|").append(paramString9).append("|").append(paramString10).append("|").append(paramString11).append("|").append(paramString12).append("|").append(paramString13).append("|").append(paramString14).append("|");
    paramString1 = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "getDC04272ReportDetail=" + paramString1);
    }
    return paramString1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, "", "", "", "", "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    b(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, Aj(), paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    QQAppInterface localQQAppInterface = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localQQAppInterface = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        localQQAppInterface = paramQQAppInterface;
        if (localAppRuntime != null)
        {
          localQQAppInterface = paramQQAppInterface;
          if ((localAppRuntime instanceof QQAppInterface)) {
            localQQAppInterface = (QQAppInterface)localAppRuntime;
          }
        }
      }
    }
    if (localQQAppInterface == null)
    {
      paramQQAppInterface = a(true, "${uin_unknown}", paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13);
      paramString1 = new Intent();
      paramString1.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramString1.putExtra("reporting_tag", "dc04272");
      paramString1.putExtra("reporting_detail", paramQQAppInterface);
      paramString1.putExtra("reporting_count", paramInt);
      paramString1.putExtra("is_runtime", 1);
      BaseApplicationImpl.getApplication().sendBroadcast(paramString1);
      return;
    }
    n(localQQAppInterface, "dc04272", a(true, localQQAppInterface.getCurrentAccountUin(), paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13), paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    QQAppInterface localQQAppInterface = paramQQAppInterface;
    Object localObject;
    if (paramQQAppInterface == null)
    {
      localQQAppInterface = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
        localQQAppInterface = paramQQAppInterface;
        if (localObject != null)
        {
          localQQAppInterface = paramQQAppInterface;
          if ((localObject instanceof QQAppInterface)) {
            localQQAppInterface = (QQAppInterface)localObject;
          }
        }
      }
    }
    if (localQQAppInterface == null)
    {
      paramQQAppInterface = a(paramString1, paramString2, "${uin_unknown}", paramString3, paramString4, paramString5, paramInt1, paramInt3, paramInt2, paramString6, paramString7, paramString8, paramString9);
      paramString2 = new Intent();
      paramString2.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramString2.putExtra("reporting_tag", paramString1);
      paramString2.putExtra("reporting_detail", paramQQAppInterface);
      paramString2.putExtra("reporting_count", paramInt3);
      paramString2.putExtra("is_runtime", 1);
      BaseApplicationImpl.getApplication().sendBroadcast(paramString2);
      if (!"CliOper".equals(paramString1)) {
        awiy.a().bC(paramString4, paramQQAppInterface);
      }
      return;
    }
    if ((NotificationActivity.pq.contains(paramString4)) || (AuthDevUgActivity.oR.contains(paramString4))) {
      paramQQAppInterface = "";
    }
    for (;;)
    {
      paramQQAppInterface = a(paramString1, paramString2, paramString3, paramQQAppInterface, paramString4, paramString5, paramInt1, paramInt3, paramInt2, paramString6, paramString7, paramString8, paramString9);
      n(localQQAppInterface, paramString1, paramQQAppInterface, paramInt3);
      if ("CliOper".equals(paramString1)) {
        break;
      }
      awiy.a().bC(paramString4, paramQQAppInterface);
      return;
      localObject = localQQAppInterface.getCurrentAccountUin();
      paramQQAppInterface = paramString3;
      paramString3 = (String)localObject;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    b(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, 1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    QQAppInterface localQQAppInterface = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localQQAppInterface = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        localQQAppInterface = paramQQAppInterface;
        if (localAppRuntime != null)
        {
          localQQAppInterface = paramQQAppInterface;
          if ((localAppRuntime instanceof QQAppInterface)) {
            localQQAppInterface = (QQAppInterface)localAppRuntime;
          }
        }
      }
    }
    if (localQQAppInterface == null)
    {
      paramQQAppInterface = a(paramBoolean, "${uin_unknown}", paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13);
      paramString1 = new Intent();
      paramString1.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramString1.putExtra("reporting_tag", "dc04272");
      paramString1.putExtra("reporting_detail", paramQQAppInterface);
      paramString1.putExtra("reporting_count", paramInt);
      paramString1.putExtra("is_runtime", 1);
      BaseApplicationImpl.getApplication().sendBroadcast(paramString1);
      return;
    }
    n(localQQAppInterface, "dc04272", a(paramBoolean, localQQAppInterface.getCurrentAccountUin(), paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13), paramInt);
  }
  
  public static void a(PluginRuntime paramPluginRuntime)
  {
    paramPluginRuntime.setClickEventReportor(new anou());
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, Aj(), "", "", "", "", "", "", "");
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    QQAppInterface localQQAppInterface = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localQQAppInterface = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        localQQAppInterface = paramQQAppInterface;
        if (localAppRuntime != null)
        {
          localQQAppInterface = paramQQAppInterface;
          if ((localAppRuntime instanceof QQAppInterface)) {
            localQQAppInterface = (QQAppInterface)localAppRuntime;
          }
        }
      }
    }
    if (localQQAppInterface == null)
    {
      paramQQAppInterface = a(true, "${uin_unknown}", paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13);
      paramString1 = new Intent();
      paramString1.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramString1.putExtra("reporting_tag", "dc04272");
      paramString1.putExtra("reporting_detail", paramQQAppInterface);
      paramString1.putExtra("reporting_count", paramInt);
      paramString1.putExtra("is_runtime", 0);
      BaseApplicationImpl.getApplication().sendBroadcast(paramString1);
      return;
    }
    m(localQQAppInterface, "dc04272", a(true, localQQAppInterface.getCurrentAccountUin(), paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13), paramInt);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    QQAppInterface localQQAppInterface = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localQQAppInterface = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        localQQAppInterface = paramQQAppInterface;
        if (localAppRuntime != null)
        {
          localQQAppInterface = paramQQAppInterface;
          if ((localAppRuntime instanceof QQAppInterface)) {
            localQQAppInterface = (QQAppInterface)localAppRuntime;
          }
        }
      }
    }
    if (localQQAppInterface == null)
    {
      paramQQAppInterface = a(paramString1, paramString2, "${uin_unknown}", paramString3, paramString4, paramString5, paramInt1, paramInt2, paramInt3, paramString6, paramString7, paramString8, paramString9);
      paramString2 = new Intent();
      paramString2.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramString2.putExtra("reporting_tag", paramString1);
      paramString2.putExtra("reporting_detail", paramQQAppInterface);
      paramString2.putExtra("reporting_count", paramInt2);
      paramString2.putExtra("is_runtime", 0);
      BaseApplicationImpl.getApplication().sendBroadcast(paramString2);
      if (!"CliOper".equals(paramString1)) {
        awiy.a().bC(paramString4, paramQQAppInterface);
      }
    }
    do
    {
      return;
      paramQQAppInterface = a(paramString1, paramString2, localQQAppInterface.getCurrentAccountUin(), paramString3, paramString4, paramString5, paramInt1, paramInt2, paramInt3, paramString6, paramString7, paramString8, paramString9);
      m(localQQAppInterface, paramString1, paramQQAppInterface, paramInt2);
    } while ("CliOper".equals(paramString1));
    awiy.a().bC(paramString4, paramQQAppInterface);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, 1, paramString6, paramString7, paramString8, paramString9);
  }
  
  public static void dW(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "stopReportLooper");
    }
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.stop();
    }
  }
  
  public static boolean h(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "startReportLooper");
    }
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface != null) {
      if (paramBoolean) {
        break label37;
      }
    }
    label37:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramQQAppInterface.start(paramBoolean);
      return true;
    }
  }
  
  public static void m(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramString2 != null)
    {
      anot localanot = paramQQAppInterface.a();
      if (localanot != null)
      {
        String str = paramString2;
        if (paramString2.contains("${uin_unknown}")) {
          str = paramString2.replace("${uin_unknown}", paramQQAppInterface.getCurrentAccountUin());
        }
        localanot.U(paramString1, str, paramInt);
      }
    }
  }
  
  public static void n(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    Object localObject = paramString2;
    if (paramString2.contains("${uin_unknown}"))
    {
      String str = paramQQAppInterface.getCurrentAccountUin();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localObject = paramString2.replace("${uin_unknown}", (CharSequence)localObject);
    }
    paramString2 = ((String)localObject).replace("${count_unknown}", Integer.toString(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "ReportRuntime: " + paramString1 + ", " + paramString2);
    }
    for (;;)
    {
      localObject = new NewIntent(paramQQAppInterface.getApplication(), anfa.class);
      ((NewIntent)localObject).putExtra("sendType", 2);
      ((NewIntent)localObject).putExtra("tag", paramString1);
      ((NewIntent)localObject).putExtra("content", paramString2);
      ((NewIntent)localObject).setWithouLogin(true);
      paramQQAppInterface.startServlet((NewIntent)localObject);
      return;
      if (!paramQQAppInterface.isLogin()) {
        QLog.d("ReportController", 1, "ReportRuntime: " + paramString1 + ", " + paramString2);
      }
    }
  }
  
  public static void onTouchEvent(MotionEvent paramMotionEvent)
  {
    anzh.a().onTouchEvent(paramMotionEvent);
  }
  
  public static boolean pt(String paramString)
  {
    boolean bool = false;
    if (("P_CliOper".equals(paramString)) || ("CliOper".equals(paramString)) || ("on_off".equals(paramString)) || ("CliStatus".equals(paramString))) {
      bool = true;
    }
    return bool;
  }
  
  protected void U(String paramString1, String paramString2, int paramInt) {}
  
  protected anot.a a(String paramString)
  {
    if (nx.containsKey(paramString)) {
      return (anot.a)nx.get(paramString);
    }
    return null;
  }
  
  protected void dSJ()
  {
    Iterator localIterator = nx.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (anot.a)nx.get(localObject);
      if (localObject != null) {
        ((anot.a)localObject).aIl();
      }
    }
  }
  
  protected boolean pu(String paramString)
  {
    if ("dc01160".equals(paramString)) {
      return kzi.Bn();
    }
    return false;
  }
  
  protected void start(boolean paramBoolean) {}
  
  protected void stop() {}
  
  public static abstract interface a
  {
    public abstract void a(Reporting paramReporting);
    
    public abstract void aIl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anot
 * JD-Core Version:    0.7.0.1
 */