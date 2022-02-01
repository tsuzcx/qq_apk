import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class vrq
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static long b;
  
  public static long a()
  {
    return jdField_a_of_type_Long;
  }
  
  public static List<FeedCloudCommon.Entry> a(long paramLong, String paramString, Object paramObject)
  {
    paramString = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { vri.a("host_uin", String.valueOf(biip.a().a())), vri.a("qua", blru.a()), vri.a("network_type", vri.b()), vri.a("client_time", String.valueOf(System.currentTimeMillis())), vri.a("event_id", paramString), vri.a("mobile_type", Build.MODEL + "_" + Build.VERSION.RELEASE), vri.a("version", "8.4.1.4680"), vri.a("platform", "AND"), vri.a("video_play_id", String.valueOf(paramLong)), vri.a("unique_id", String.valueOf(b())) }));
    a(paramObject, paramString);
    return paramString;
  }
  
  public static void a()
  {
    jdField_a_of_type_Long = System.currentTimeMillis() / 1000L << 32 | jdField_a_of_type_Int;
    jdField_a_of_type_Int += 1;
  }
  
  private static void a(Object paramObject, List<FeedCloudCommon.Entry> paramList)
  {
    if ((paramObject instanceof FeedCloudMeta.StFeed))
    {
      paramList.add(vri.a("video_url", String.valueOf(((FeedCloudMeta.StFeed)paramObject).video.playUrl.get())));
      paramList.add(vri.a("total_time", String.valueOf(((FeedCloudMeta.StFeed)paramObject).video.duration.get() / 1000.0F)));
      paramList.add(vri.a("orig_uin", String.valueOf(((FeedCloudMeta.StFeed)paramObject).poster.id.get())));
      paramList.add(vri.a("feed_id", String.valueOf(((FeedCloudMeta.StFeed)paramObject).id.get())));
      paramList.add(vri.a("feed_type", String.valueOf(((FeedCloudMeta.StFeed)paramObject).type.get())));
      paramList.add(vri.a("video_resolution", String.valueOf(String.valueOf(((FeedCloudMeta.StFeed)paramObject).video.width.get()) + "x" + String.valueOf(((FeedCloudMeta.StFeed)paramObject).video.height.get()))));
    }
  }
  
  public static long b()
  {
    long l = b;
    b = 1L + l;
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrq
 * JD-Core Version:    0.7.0.1
 */