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

public class uaf
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  
  public static long a()
  {
    return jdField_a_of_type_Long;
  }
  
  public static List<FeedCloudCommon.Entry> a(String paramString, FeedCloudMeta.StFeed paramStFeed)
  {
    return new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { tzy.a("host_uin", String.valueOf(bfbm.a().a())), tzy.a("qua", bjdm.a()), tzy.a("network_type", tzy.b()), tzy.a("client_time", String.valueOf(System.currentTimeMillis())), tzy.a("event_id", paramString), tzy.a("video_url", String.valueOf(paramStFeed.video.playUrl.get())), tzy.a("total_time", String.valueOf(paramStFeed.video.duration.get() / 1000.0F)), tzy.a("orig_uin", String.valueOf(paramStFeed.poster.id.get())), tzy.a("feed_id", String.valueOf(paramStFeed.id.get())), tzy.a("feed_type", String.valueOf(paramStFeed.type.get())), tzy.a("video_resolution", String.valueOf(String.valueOf(paramStFeed.video.width.get()) + "x" + String.valueOf(paramStFeed.video.height.get()))), tzy.a("mobile_type", Build.MODEL + "_" + Build.VERSION.RELEASE), tzy.a("version", "8.3.5.4555"), tzy.a("platform", "AND"), tzy.a("video_play_id", String.valueOf(a())), tzy.a("unique_id", String.valueOf(a())) }));
  }
  
  public static void a()
  {
    jdField_a_of_type_Long = System.currentTimeMillis() / 1000L << 32 | jdField_a_of_type_Int;
    jdField_a_of_type_Int += 1;
  }
  
  public static void a(String paramString, FeedCloudMeta.StFeed paramStFeed, List<FeedCloudCommon.Entry> paramList)
  {
    uab.a().a().post(new QCircleVideoReporter.1(paramStFeed, paramString, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uaf
 * JD-Core Version:    0.7.0.1
 */