import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.ServerConfigManager.ConfigType;

final class aqjd
  extends AsyncTask<Void, Void, Void>
{
  aqjd(String paramString1, int paramInt, String paramString2) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = aqlr.a(ServerConfigManager.ConfigType.common, aqjc.sL());
    if (QLog.isDevelopLevel()) {
      QLog.d("PerformanceReportUtils", 4, "reportFPS openStr ：" + paramVarArgs);
    }
    if ((paramVarArgs == null) || (!"1".equals(paramVarArgs))) {
      return null;
    }
    int i;
    for (;;)
    {
      try
      {
        localSharedPreferences = aqjc.A();
        if ((this.ctU == null) || (this.dZr <= 0)) {
          break label632;
        }
        if ((this.dZr >= 60) && (QLog.isDevelopLevel())) {
          QLog.e("PerformanceReportUtils", 4, "reportFPS  fps error fpsvalue :" + this.dZr);
        }
        l2 = localSharedPreferences.getLong(this.ctU, 0L);
        l1 = aqjc.hN();
        paramVarArgs = aqlr.a(ServerConfigManager.ConfigType.common, aqjc.ek());
        if (paramVarArgs == null) {}
      }
      catch (Exception paramVarArgs)
      {
        SharedPreferences localSharedPreferences;
        long l2;
        long l1;
        HashMap localHashMap;
        BaseApplicationImpl localBaseApplicationImpl;
        break label632;
        i = 1;
        continue;
      }
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("PerformanceReportUtils", 4, "reportFPS  server time：" + paramVarArgs);
        }
        l1 = Long.valueOf(paramVarArgs).longValue();
        l1 *= 1000L;
      }
      catch (Exception paramVarArgs)
      {
        l1 = aqjc.hN();
        continue;
        paramVarArgs = this.ctU + "_new";
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("PerformanceReportUtils", 4, "reportFPS report_time ：" + l1 + ",lastRp" + l2 + ",reportFPS fpsvalue：" + this.dZr);
    }
    if ((l2 != 0L) && (SystemClock.uptimeMillis() >= l2))
    {
      if (SystemClock.uptimeMillis() - l2 < l1) {
        break label634;
      }
      break label627;
      bool = UnifiedMonitor.a().whetherReportThisTime(12, false);
      if ((i == 0) && (!bool)) {
        break label632;
      }
      localHashMap = new HashMap();
      localHashMap.put("param_FPS", String.valueOf(this.dZr));
      localHashMap.put("aioBusiness", this.Gv);
      localHashMap.put("theme_Id", QQAppInterface.getCurrentThemeId());
      localHashMap.put("param_threadOpId", String.valueOf(acmq.a().AZ()));
      if (QLog.isDevelopLevel()) {
        QLog.d("PerformanceReportUtils", 4, "reportFPS real report  fpsvalue：" + this.dZr);
      }
      localHashMap.put("param_DeviceType", String.valueOf(zsz.getDeviceType()));
      paramVarArgs = null;
      localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      if (localBaseApplicationImpl != null) {
        paramVarArgs = localBaseApplicationImpl.getRuntime();
      }
      if ((paramVarArgs != null) && ((paramVarArgs instanceof QQAppInterface)))
      {
        if (((QQAppInterface)paramVarArgs).a.Ra == 0L) {
          break label639;
        }
        bool = true;
        label457:
        localHashMap.put("param_is_logining", String.valueOf(bool));
        if (((QQAppInterface)paramVarArgs).a.abT()) {
          break label645;
        }
      }
    }
    label645:
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("param_syncing_msg", String.valueOf(bool));
      localHashMap.put("param_NetType", String.valueOf(aqiw.getSystemNetwork(BaseApplication.getContext())));
      if (i != 0)
      {
        paramVarArgs = this.ctU;
        anpc.a(BaseApplication.getContext()).collectPerformance(aqlr.getUin(), paramVarArgs, aqjc.rz(this.ctU), this.dZr, 0L, localHashMap, aqjc.ej());
        if (i == 0) {
          break label632;
        }
        localSharedPreferences.edit().putLong(this.ctU, SystemClock.uptimeMillis()).commit();
      }
      label627:
      label632:
      return null;
      label634:
      i = 0;
      break;
      label639:
      bool = false;
      break label457;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqjd
 * JD-Core Version:    0.7.0.1
 */