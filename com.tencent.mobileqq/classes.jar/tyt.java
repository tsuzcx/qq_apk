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

public class tyt
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  
  public static long a()
  {
    return jdField_a_of_type_Long;
  }
  
  public static List<FeedCloudCommon.Entry> a(String paramString, FeedCloudMeta.StFeed paramStFeed)
  {
    return new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { tym.a("host_uin", String.valueOf(bexd.a().a())), tym.a("qua", bizf.a()), tym.a("network_type", tym.b()), tym.a("client_time", String.valueOf(System.currentTimeMillis())), tym.a("event_id", paramString), tym.a("video_url", String.valueOf(paramStFeed.video.playUrl.get())), tym.a("total_time", String.valueOf(paramStFeed.video.duration.get() / 1000.0F)), tym.a("orig_uin", String.valueOf(paramStFeed.poster.id.get())), tym.a("feed_id", String.valueOf(paramStFeed.id.get())), tym.a("feed_type", String.valueOf(paramStFeed.type.get())), tym.a("video_resolution", String.valueOf(String.valueOf(paramStFeed.video.width.get()) + "x" + String.valueOf(paramStFeed.video.height.get()))), tym.a("mobile_type", Build.MODEL + "_" + Build.VERSION.RELEASE), tym.a("version", "8.3.3.4515"), tym.a("platform", "AND"), tym.a("video_play_id", String.valueOf(paramStFeed.video.fileId.get())), tym.a("unique_id", String.valueOf(a())) }));
  }
  
  public static void a()
  {
    jdField_a_of_type_Long = System.currentTimeMillis() / 1000L << 32 | jdField_a_of_type_Int;
    jdField_a_of_type_Int += 1;
  }
  
  public static void a(String paramString, FeedCloudMeta.StFeed paramStFeed, List<FeedCloudCommon.Entry> paramList)
  {
    typ.a().a().post(new QCircleVideoReporter.1(paramStFeed, paramString, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyt
 * JD-Core Version:    0.7.0.1
 */