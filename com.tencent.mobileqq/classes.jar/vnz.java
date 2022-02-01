import android.net.Uri;
import android.util.LruCache;
import com.tencent.biz.qqcircle.requests.QCircleVideoUrlAdapterRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StVideo;

public class vnz
{
  private static final long jdField_a_of_type_Long = QzoneConfig.getInstance().getConfig("qqcircle", "secondary_qcircle_video_url_valid_time", 21600000);
  private static final vnz jdField_a_of_type_Vnz = new vnz();
  private final LruCache<String, FeedCloudMeta.StVideo> jdField_a_of_type_AndroidUtilLruCache = new LruCache(100);
  private long b = 300000L;
  
  public static vnz a()
  {
    return jdField_a_of_type_Vnz;
  }
  
  public void a(int paramInt, FeedCloudMeta.StVideo paramStVideo, vob paramvob)
  {
    if ((paramStVideo == null) || (paramvob == null)) {
      return;
    }
    if (!a(paramStVideo))
    {
      QLog.i("QCircleVideoUrlExchangeHelper", 1, String.format("exchangeVideoUrl: valid callBack fileId:%s ,videoExchange url:%s", new Object[] { paramStVideo.fileId.get(), paramStVideo.playUrl.get() }));
      paramvob.a(paramStVideo, true);
      return;
    }
    Object localObject = (FeedCloudMeta.StVideo)this.jdField_a_of_type_AndroidUtilLruCache.get(paramStVideo.fileId.get());
    if (localObject != null)
    {
      QLog.i("QCircleVideoUrlExchangeHelper", 1, String.format("exchangeVideoUrl: success hit Video Cache fileId:%s ,videoExchange url %s:", new Object[] { ((FeedCloudMeta.StVideo)localObject).fileId.get(), ((FeedCloudMeta.StVideo)localObject).playUrl.get() }));
      paramvob.a((FeedCloudMeta.StVideo)localObject, false);
      return;
    }
    localObject = new QCircleVideoUrlAdapterRequest(paramStVideo);
    VSNetworkHelper.a().a(paramInt, (VSBaseRequest)localObject, new voa(this, paramStVideo, paramvob));
  }
  
  public boolean a(FeedCloudMeta.StVideo paramStVideo)
  {
    if (paramStVideo == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramStVideo = Uri.parse(paramStVideo.playUrl.get());
        if (paramStVideo.getQueryParameter("dis_t") != null)
        {
          long l2 = Long.valueOf(paramStVideo.getQueryParameter("dis_t")).longValue() * 1000L;
          long l1 = System.currentTimeMillis() - l2;
          QLog.d("QCircleVideoUrlExchangeHelper", 2, String.format("intervalTime:%d, disTime: %d, valid time:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(jdField_a_of_type_Long) }));
          l2 = jdField_a_of_type_Long;
          long l3 = this.b;
          if (l1 > l2 - l3) {
            return true;
          }
        }
      }
      catch (Exception paramStVideo)
      {
        paramStVideo.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnz
 * JD-Core Version:    0.7.0.1
 */