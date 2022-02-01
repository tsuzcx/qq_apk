import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.report.IMTAReporter;
import com.tencent.mobileqq.msf.sdk.report.MTAReportManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatReportStrategy;
import com.tencent.stat.StatServiceImpl;
import com.tencent.stat.StatSpecifyReportedInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

public class anol
  implements IMTAReporter
{
  private static volatile anol a;
  private boolean cIT;
  private Context context;
  private StatSpecifyReportedInfo f = new StatSpecifyReportedInfo();
  private volatile String mUin;
  
  private anol(Context paramContext)
  {
    this.context = paramContext.getApplicationContext();
    this.cIT = anog.l(this.context, true);
  }
  
  private void Qk(boolean paramBoolean)
  {
    StatConfig.setStatSendStrategy(StatReportStrategy.PERIOD);
    StatConfig.setSendPeriodMinutes(30);
    StatConfig.setEnableSmartReporting(true);
    StatConfig.setStatReportUrl("http://sngmta.qq.com:80/mstat/report/");
    String str = this.mUin;
    if (str != null)
    {
      StatConfig.setCustomUserId(this.context, str);
      if (paramBoolean)
      {
        this.mUin = null;
        StatServiceImpl.reportQQ(this.context, str, this.f);
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        if (!(localObject instanceof QQAppInterface)) {
          break label175;
        }
      }
    }
    label175:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      Date localDate = new Date(NetConnInfoCenter.getServerTimeMillis());
      anot.a((QQAppInterface)localObject, "dc00898", "", "", "0X80075F3", "0X80075F3", 0, 0, new SimpleDateFormat("yyyyMMdd", Locale.US).format(localDate), "", "", "");
      MTAReportManager.setMTAReporter(a);
      if (QLog.isColorLevel()) {
        QLog.d("MTAReportController", 2, "calledBeforeStat:" + str + ", " + paramBoolean);
      }
      return;
    }
  }
  
  public static anol a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new anol(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public void QT(String paramString)
  {
    StatConfig.setMTAPreferencesFileName(paramString);
  }
  
  public void enableDebug(boolean paramBoolean)
  {
    StatConfig.setDebugEnable(paramBoolean);
  }
  
  public void initMtaConfig(String paramString1, String paramString2)
  {
    this.f.setAppKey(paramString2);
    this.f.setInstallChannel(paramString1);
    StatConfig.setEnableConcurrentProcess(true);
    StatConfig.setAutoExceptionCaught(false);
    StatServiceImpl.setContext(this.context);
    Qk(false);
  }
  
  public boolean isMtaSupported()
  {
    return this.cIT;
  }
  
  public void reportKVEvent(String paramString, Properties paramProperties)
  {
    if (!this.cIT) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MTAReportController", 2, "reportKVEvent " + paramString + " \n\t\t" + paramProperties);
    }
    Qk(true);
    StatServiceImpl.trackCustomKVEvent(this.context, paramString, paramProperties, this.f);
  }
  
  public void reportTimeKVEvent(String paramString, Properties paramProperties, int paramInt)
  {
    if (!this.cIT) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MTAReportController", 2, "reportKVEvent " + paramString + " " + paramInt + "\n\t\t" + paramProperties);
    }
    Qk(true);
    StatServiceImpl.trackCustomKVTimeIntervalEvent(this.context, paramString, paramProperties, paramInt, this.f);
  }
  
  public void setUin(String paramString)
  {
    this.mUin = paramString;
  }
  
  public void trackBeginPage(String paramString)
  {
    if (!this.cIT) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MTAReportController", 2, "trackBeginPage " + paramString);
    }
    Qk(true);
    StatServiceImpl.trackBeginPage(this.context, paramString, this.f);
  }
  
  public void trackEndPage(String paramString)
  {
    if (!this.cIT) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MTAReportController", 2, "trackEndPage " + paramString);
    }
    Qk(true);
    StatServiceImpl.trackEndPage(this.context, paramString, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anol
 * JD-Core Version:    0.7.0.1
 */