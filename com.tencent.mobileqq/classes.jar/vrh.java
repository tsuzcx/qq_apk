import NS_COMM.COMM.Entry;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.biz.qqcircle.report.QCircleQualityReporter.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import mqq.app.AppRuntime;

public class vrh
{
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString;
  private static boolean jdField_a_of_type_Boolean = true;
  
  private static int a()
  {
    return (int)((System.currentTimeMillis() - a(1970, 0, 1, 0, 0, 0)) / 1000L / 60L / 60L / 24L);
  }
  
  private static long a()
  {
    if (jdField_a_of_type_Long == 0L)
    {
      a();
      b();
    }
    return jdField_a_of_type_Long;
  }
  
  private static long a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramInt3 != 0))
    {
      localCalendar.set(1, paramInt1);
      localCalendar.set(2, paramInt2);
      localCalendar.set(5, paramInt3);
    }
    localCalendar.set(11, paramInt4);
    localCalendar.set(12, paramInt5);
    localCalendar.set(13, paramInt6);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static List<FeedCloudCommon.Entry> a(String paramString)
  {
    return new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { vri.a("host_uin", String.valueOf(biip.a().a())), vri.a("qua", blru.a()), vri.a("network_type", vri.b()), vri.a("client_time", String.valueOf(System.currentTimeMillis())), vri.a("event_id", paramString), vri.a("mobile_type", Build.MODEL + "_" + Build.VERSION.RELEASE), vri.a("version", "8.4.1.4680"), vri.a("platform", "AND"), vri.a("unique_id", String.valueOf(a())) }));
  }
  
  private static void a()
  {
    jdField_a_of_type_Long = System.currentTimeMillis() / 1000L << 32 | BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
  {
    if ((QLog.isColorLevel()) || (jdField_a_of_type_Boolean))
    {
      if (jdField_a_of_type_JavaLangString == null) {
        jdField_a_of_type_JavaLangString = String.valueOf(bgln.f());
      }
      paramString1 = MiniProgramReportHelper.newSingleReportData(16, new ArrayList(Arrays.asList(new COMM.Entry[] { MiniProgramReportHelper.newEntry("uid", String.valueOf(biip.a().a())), MiniProgramReportHelper.newEntry("event", MiniReportManager.getEventName(paramInt1)), MiniProgramReportHelper.newEntry("timestamp", String.valueOf(System.currentTimeMillis())), MiniProgramReportHelper.newEntry("appversion", "8.4.1.4680"), MiniProgramReportHelper.newEntry("qua", blru.a()), MiniProgramReportHelper.newEntry("cmd", paramString1), MiniProgramReportHelper.newEntry("retcode", String.valueOf(paramInt2)), MiniProgramReportHelper.newEntry("time_cost", String.valueOf(paramLong)), MiniProgramReportHelper.newEntry("network_type", MiniProgramReportHelper.getNetworkType()), MiniProgramReportHelper.newEntry("busiType", jdField_a_of_type_JavaLangString), MiniProgramReportHelper.newEntry("trace_id", paramString2) })), null);
      vrl.a().a(paramString1);
    }
  }
  
  public static void a(int paramInt, String paramString, List<FeedCloudCommon.Entry> paramList, boolean paramBoolean)
  {
    if ((paramBoolean) && (!jdField_a_of_type_Boolean) && (!QLog.isColorLevel()) && (QzoneConfig.getQQCircleQualitySampleSwitchOpen()))
    {
      QLog.d("QCircleQualityReporter", 4, "reportQualityEvent miss hit Sample,direct return!");
      return;
    }
    vrl.a().a().post(new QCircleQualityReporter.1(paramInt, paramString, paramList));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(vri.a("time_cost", paramString2));
    localArrayList.add(vri.a("ret_code", paramString3));
    localArrayList.add(vri.a("url", paramString4));
    localArrayList.add(vri.a("refer", paramInt + ""));
    a(paramString1, localArrayList, true);
  }
  
  public static void a(String paramString, List<FeedCloudCommon.Entry> paramList, boolean paramBoolean)
  {
    a(5531, paramString, paramList, paramBoolean);
  }
  
  private static void b()
  {
    long l1 = a();
    long l2 = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    if (l2 == 0L) {
      return;
    }
    int i = (int)(l1 % 100);
    if (i == l2 % 100) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      if (QLog.isDevelopLevel()) {
        QLog.d("QCircleQualityReporter", 4, "抽中的尾数： " + i);
      }
      QLog.d("QCircleQualityReporter", 1, "checkIsSampled:" + jdField_a_of_type_Boolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrh
 * JD-Core Version:    0.7.0.1
 */