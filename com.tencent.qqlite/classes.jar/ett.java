import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.PerformanceReportUtils;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.ServerConfigManager.ConfigType;

public final class ett
  extends AsyncTask
{
  public ett(String paramString1, int paramInt, String paramString2) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = QQUtils.a(ServerConfigManager.ConfigType.common, PerformanceReportUtils.n());
    if (QLog.isDevelopLevel()) {
      QLog.d(PerformanceReportUtils.c(), 4, "reportFPS openStr ：" + paramVarArgs);
    }
    if ((paramVarArgs == null) || (!"1".equals(paramVarArgs))) {}
    for (;;)
    {
      return null;
      long l1;
      try
      {
        paramVarArgs = PerformanceReportUtils.a();
        if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Int > 0))
        {
          if ((this.jdField_a_of_type_Int >= 60) && (QLog.isDevelopLevel())) {
            QLog.e(PerformanceReportUtils.c(), 4, "reportFPS  fps error fpsvalue :" + this.jdField_a_of_type_Int);
          }
          long l2 = paramVarArgs.getLong(this.jdField_a_of_type_JavaLangString, 0L);
          l1 = PerformanceReportUtils.a();
          Object localObject = QQUtils.a(ServerConfigManager.ConfigType.common, PerformanceReportUtils.o());
          if (localObject != null) {}
          try
          {
            if (QLog.isDevelopLevel()) {
              QLog.d(PerformanceReportUtils.c(), 4, "reportFPS  server time：" + (String)localObject);
            }
            l1 = Long.valueOf((String)localObject).longValue();
            l1 *= 1000L;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              l1 = PerformanceReportUtils.a();
            }
          }
          if (QLog.isDevelopLevel()) {
            QLog.d(PerformanceReportUtils.c(), 4, "reportFPS report_time ：" + l1 + ",lastRp" + l2 + ",reportFPS fpsvalue：" + this.jdField_a_of_type_Int);
          }
          if ((l2 == 0L) || (SystemClock.uptimeMillis() < l2) || (SystemClock.uptimeMillis() - l2 >= l1))
          {
            localObject = new HashMap();
            ((HashMap)localObject).put("param_FPS", String.valueOf(this.jdField_a_of_type_Int));
            ((HashMap)localObject).put("aioBusiness", this.b);
            if (QLog.isDevelopLevel()) {
              QLog.d(PerformanceReportUtils.c(), 4, "reportFPS real report  fpsvalue：" + this.jdField_a_of_type_Int);
            }
            StatisticCollector.a(BaseApplication.getContext()).a(QQUtils.a(), this.jdField_a_of_type_JavaLangString, PerformanceReportUtils.a(this.jdField_a_of_type_JavaLangString), 0L, 0L, (HashMap)localObject, PerformanceReportUtils.m());
            paramVarArgs.edit().putLong(this.jdField_a_of_type_JavaLangString, SystemClock.uptimeMillis()).commit();
            return null;
          }
        }
      }
      catch (Exception paramVarArgs) {}
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ett
 * JD-Core Version:    0.7.0.1
 */