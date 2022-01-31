import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.PerformanceReportUtils;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.ServerConfigManager.ConfigType;

public final class hcc
  extends AsyncTask
{
  public hcc(int paramInt, long paramLong, String paramString) {}
  
  protected Void a(Void... paramVarArgs)
  {
    int i = 1;
    paramVarArgs = QQUtils.a(ServerConfigManager.ConfigType.common, PerformanceReportUtils.a());
    if (QLog.isDevelopLevel()) {
      QLog.d(PerformanceReportUtils.b(), 4, "reportUISwitch openStr ：" + paramVarArgs);
    }
    if ((paramVarArgs == null) || (!"1".equals(paramVarArgs))) {}
    for (;;)
    {
      return null;
      try
      {
        HashMap localHashMap = new HashMap();
        if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3000))
        {
          if (QQAppInterface.c) {
            i = 0;
          }
          localHashMap.put("actloginTypt", String.valueOf(i));
          if (!QQAppInterface.c) {
            QQAppInterface.c = true;
          }
        }
        switch (this.jdField_a_of_type_Int)
        {
        }
        long l1;
        for (;;)
        {
          SharedPreferences localSharedPreferences = PerformanceReportUtils.a();
          if ((paramVarArgs == null) || (this.jdField_a_of_type_Long <= 0L)) {
            break;
          }
          long l2 = localSharedPreferences.getLong(paramVarArgs, 0L);
          l1 = PerformanceReportUtils.a();
          String str = QQUtils.a(ServerConfigManager.ConfigType.common, PerformanceReportUtils.g());
          if (str != null) {
            if (QLog.isDevelopLevel()) {
              QLog.d(PerformanceReportUtils.b(), 4, "reportUISwitch  server time：" + str);
            }
          }
          try
          {
            l1 = Long.valueOf(str).longValue();
            l1 *= 1000L;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              l1 = PerformanceReportUtils.a();
            }
            paramVarArgs = null;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d(PerformanceReportUtils.b(), 4, "reportUISwitch report_time ：" + l1 + ",lastRp" + l2);
          }
          if ((l2 != 0L) && (SystemClock.uptimeMillis() >= l2) && (SystemClock.uptimeMillis() - l2 < l1)) {
            break;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d(PerformanceReportUtils.b(), 4, "reportUISwitch timeConsumed ：" + this.jdField_a_of_type_Long);
          }
          StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_JavaLangString, paramVarArgs, true, this.jdField_a_of_type_Long, 0L, localHashMap, PerformanceReportUtils.h());
          localSharedPreferences.edit().putLong(paramVarArgs, SystemClock.uptimeMillis()).commit();
          return null;
          paramVarArgs = PerformanceReportUtils.c();
          continue;
          paramVarArgs = PerformanceReportUtils.d();
          continue;
          paramVarArgs = PerformanceReportUtils.e();
          continue;
          paramVarArgs = PerformanceReportUtils.f();
        }
        return null;
      }
      catch (Exception paramVarArgs) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hcc
 * JD-Core Version:    0.7.0.1
 */