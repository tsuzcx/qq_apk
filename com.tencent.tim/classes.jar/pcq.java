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

public class pcq
{
  private static boolean azm = true;
  private static long zE;
  
  public static List<FeedCloudCommon.Entry> I(String paramString)
  {
    return new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { pcr.a("host_uin", String.valueOf(aroi.a().getUin())), pcr.a("qua", avpq.getQUA3()), pcr.a("network_type", pcr.getNetworkType()), pcr.a("client_time", String.valueOf(System.currentTimeMillis())), pcr.a("event_id", paramString), pcr.a("mobile_type", Build.MODEL + "_" + Build.VERSION.RELEASE), pcr.a("version", "3.4.4.3058"), pcr.a("platform", "AND"), pcr.a("unique_id", String.valueOf(dv())) }));
  }
  
  private static void bjt()
  {
    zE = System.currentTimeMillis() / 1000L << 32 | BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
  }
  
  private static void bju()
  {
    long l1 = getDaysSince1970();
    long l2 = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    if (l2 == 0L) {
      return;
    }
    int i = (int)(l1 % 100);
    if (i == l2 % 100) {}
    for (boolean bool = true;; bool = false)
    {
      azm = bool;
      if (QLog.isDevelopLevel()) {
        QLog.d("QCircleQualityReporter", 4, "抽中的尾数： " + i);
      }
      QLog.d("QCircleQualityReporter", 1, "checkIsSampled:" + azm);
      return;
    }
  }
  
  public static void c(String paramString, List<FeedCloudCommon.Entry> paramList, boolean paramBoolean)
  {
    if ((paramBoolean) && (!azm))
    {
      QLog.d("QCircleQualityReporter", 4, "reportQualityEvent miss hit Sample,direct return!");
      return;
    }
    pcu.a().getReportHandler().post(new QCircleQualityReporter.1(paramString, paramList));
  }
  
  private static long dv()
  {
    if (zE == 0L)
    {
      bjt();
      bju();
    }
    return zE;
  }
  
  private static long getBeijingTimeInMillis(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
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
  
  private static int getDaysSince1970()
  {
    return (int)((System.currentTimeMillis() - getBeijingTimeInMillis(1970, 0, 1, 0, 0, 0)) / 1000L / 60L / 60L / 24L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pcq
 * JD-Core Version:    0.7.0.1
 */