import com.tencent.mobileqq.activity.aio.AIOReporterGetDeviceInfo;
import com.tencent.mobileqq.activity.aio.AIOTimeReporter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class bsj
  implements Runnable
{
  public bsj(AIOTimeReporter paramAIOTimeReporter) {}
  
  public void run()
  {
    Object localObject3 = AIOReporterGetDeviceInfo.a();
    AIOTimeReporter.a(this.a, ((AIOReporterGetDeviceInfo)localObject3).a());
    if ((AIOTimeReporter.a(this.a) <= 0L) || (AIOTimeReporter.b(this.a) <= 0L) || (AIOTimeReporter.c(this.a) <= 0L) || (AIOTimeReporter.d(this.a) <= 0L) || (AIOTimeReporter.e(this.a) <= 0L) || (AIOTimeReporter.f(this.a) <= 0L) || (AIOTimeReporter.g(this.a) <= 0L) || (AIOTimeReporter.a(this.a))) {}
    long l1;
    long l2;
    long l3;
    long l4;
    long l5;
    do
    {
      return;
      l1 = AIOTimeReporter.a(this.a) - AIOTimeReporter.b(this.a);
      l2 = AIOTimeReporter.c(this.a) - AIOTimeReporter.d(this.a);
      l3 = AIOTimeReporter.e(this.a) - AIOTimeReporter.f(this.a);
      l4 = AIOTimeReporter.g(this.a) - AIOTimeReporter.e(this.a);
      l5 = AIOTimeReporter.g(this.a) - AIOTimeReporter.b(this.a);
    } while ((l1 < 0L) || (l2 < 0L) || (l3 < 0L) || (l4 < 0L) || (l5 < 0L));
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).put("create", "" + l1);
    ((HashMap)localObject1).put("start", "" + l2);
    ((HashMap)localObject1).put("resume", "" + l3);
    ((HashMap)localObject1).put("resumeToShow", "" + l4);
    Object localObject2 = AIOTimeReporter.a(this.a, AIOTimeReporter.a(this.a));
    if (localObject2 != null) {
      ((HashMap)localObject1).putAll((Map)localObject2);
    }
    if (((AIOReporterGetDeviceInfo)localObject3).jdField_a_of_type_JavaLangString.equals(AIOTimeReporter.a(this.a))) {
      if (((AIOReporterGetDeviceInfo)localObject3).jdField_a_of_type_Boolean) {
        StatisticCollector.a(BaseApplication.getContext()).a(null, "report_HighDeviceFirstOpenAIOTime", true, l5, 0L, (HashMap)localObject1, "");
      }
    }
    for (;;)
    {
      AIOTimeReporter.a(this.a, true);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("reportAIOTime:").append("IsFirstOpen_").append(((AIOReporterGetDeviceInfo)localObject3).jdField_a_of_type_Boolean).append("---DeviceType_").append(AIOTimeReporter.a(this.a)).append(";");
      localObject3 = ((HashMap)localObject1).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        ((StringBuilder)localObject2).append(str).append("_").append((String)((HashMap)localObject1).get(str)).append(";");
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, "report_HighDeviceNotFirstOpenAIOTime", true, l5, 0L, (HashMap)localObject1, "");
      continue;
      if (((AIOReporterGetDeviceInfo)localObject3).b.equals(AIOTimeReporter.a(this.a))) {
        if (((AIOReporterGetDeviceInfo)localObject3).jdField_a_of_type_Boolean) {
          StatisticCollector.a(BaseApplication.getContext()).a(null, "report_LowDeviceFirstOpenAIOTime", true, l5, 0L, (HashMap)localObject1, "");
        } else {
          StatisticCollector.a(BaseApplication.getContext()).a(null, "report_LowDeviceNotFirstOpenAIOTime", true, l5, 0L, (HashMap)localObject1, "");
        }
      }
    }
    localObject1 = AIOTimeReporter.a(this.a).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((StringBuilder)localObject2).append((String)((Iterator)localObject1).next()).append(";");
    }
    QLog.d("AutoMonitor", 4, ((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bsj
 * JD-Core Version:    0.7.0.1
 */