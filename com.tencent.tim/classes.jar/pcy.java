import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.biz.qqcircle.report.QCircleVideoReporter.1;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pcy
{
  private static int bhl;
  private static long zE;
  
  private static void a(Object paramObject, List<FeedCloudCommon.Entry> paramList)
  {
    if ((paramObject instanceof FeedCloudMeta.StFeed))
    {
      paramList.add(pcr.a("video_url", String.valueOf(((FeedCloudMeta.StFeed)paramObject).video.playUrl.get())));
      paramList.add(pcr.a("total_time", String.valueOf(((FeedCloudMeta.StFeed)paramObject).video.duration.get() / 1000.0F)));
      paramList.add(pcr.a("orig_uin", String.valueOf(((FeedCloudMeta.StFeed)paramObject).poster.id.get())));
      paramList.add(pcr.a("feed_id", String.valueOf(((FeedCloudMeta.StFeed)paramObject).id.get())));
      paramList.add(pcr.a("feed_type", String.valueOf(((FeedCloudMeta.StFeed)paramObject).type.get())));
      paramList.add(pcr.a("video_resolution", String.valueOf(String.valueOf(((FeedCloudMeta.StFeed)paramObject).video.width.get()) + "x" + String.valueOf(((FeedCloudMeta.StFeed)paramObject).video.height.get()))));
    }
  }
  
  public static void a(String paramString, Object paramObject, List<FeedCloudCommon.Entry> paramList)
  {
    pcu.a().getReportHandler().post(new QCircleVideoReporter.1(paramObject, paramString, paramList));
  }
  
  public static void bjt()
  {
    zE = System.currentTimeMillis() / 1000L << 32 | bhl;
    bhl += 1;
  }
  
  public static List<FeedCloudCommon.Entry> c(String paramString, Object paramObject)
  {
    paramString = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { pcr.a("host_uin", String.valueOf(aroi.a().getUin())), pcr.a("qua", avpq.getQUA3()), pcr.a("network_type", pcr.getNetworkType()), pcr.a("client_time", String.valueOf(System.currentTimeMillis())), pcr.a("event_id", paramString), pcr.a("mobile_type", Build.MODEL + "_" + Build.VERSION.RELEASE), pcr.a("version", "3.4.4.3058"), pcr.a("platform", "AND"), pcr.a("video_play_id", String.valueOf(dv())), pcr.a("unique_id", String.valueOf(dv())) }));
    a(paramObject, paramString);
    return paramString;
  }
  
  public static long dv()
  {
    return zE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pcy
 * JD-Core Version:    0.7.0.1
 */