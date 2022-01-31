import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.biz.qqcircle.report.QCircleQualityReporter.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import mqq.app.AppRuntime;

public class tyl
{
  private static long jdField_a_of_type_Long;
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
    return new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { tym.a("host_uin", String.valueOf(bexd.a().a())), tym.a("qua", bizf.a()), tym.a("network_type", tym.b()), tym.a("client_time", String.valueOf(System.currentTimeMillis())), tym.a("event_id", paramString), tym.a("mobile_type", Build.MODEL + "_" + Build.VERSION.RELEASE), tym.a("version", "8.3.3.4515"), tym.a("platform", "AND"), tym.a("unique_id", String.valueOf(a())) }));
  }
  
  private static void a()
  {
    jdField_a_of_type_Long = System.currentTimeMillis() / 1000L << 32 | BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
  }
  
  public static void a(String paramString, List<FeedCloudCommon.Entry> paramList, boolean paramBoolean)
  {
    if ((paramBoolean) && (!jdField_a_of_type_Boolean))
    {
      QLog.d("QCircleQualityReporter", 4, "reportQualityEvent miss hit Sample,direct return!");
      return;
    }
    typ.a().a().post(new QCircleQualityReporter.1(paramString, paramList));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyl
 * JD-Core Version:    0.7.0.1
 */