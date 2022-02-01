import android.net.Uri;
import android.util.LruCache;
import com.tencent.biz.qqcircle.requests.QCircleVideoUrlAdapterRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.richframework.widget.BaseVideoView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudMeta.StVideoUrl;
import java.util.Iterator;
import java.util.List;

public class vqh
{
  private static final int jdField_a_of_type_Int = QzoneConfig.getInstance().getConfig("qqcircle", "secondary_video_level_type", 10);
  private static final long jdField_a_of_type_Long;
  private static final vqh jdField_a_of_type_Vqh = new vqh();
  private static final int jdField_b_of_type_Int = QzoneConfig.getInstance().getConfig("qqcircle", "secondary_video_hevc_level_type", 16);
  private final LruCache<String, FeedCloudMeta.StVideo> jdField_a_of_type_AndroidUtilLruCache = new LruCache(100);
  private long jdField_b_of_type_Long = 300000L;
  
  static
  {
    jdField_a_of_type_Long = QzoneConfig.getInstance().getConfig("qqcircle", "secondary_qcircle_video_url_valid_time", 21600000);
  }
  
  public static FeedCloudMeta.StVideoUrl a(List<FeedCloudMeta.StVideoUrl> paramList)
  {
    if (!"0".equals(BaseVideoView.a)) {}
    for (int i = jdField_b_of_type_Int; (paramList != null) && (paramList.size() > 0); i = jdField_a_of_type_Int)
    {
      Iterator localIterator = paramList.iterator();
      FeedCloudMeta.StVideoUrl localStVideoUrl;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localStVideoUrl = (FeedCloudMeta.StVideoUrl)localIterator.next();
      } while (localStVideoUrl.levelType.get() != i);
      QLog.i("BaseVideoView_QCircleVideoUrlExchangeHelper", 1, String.format("getTargetLevelTypeUrl urls size:%d, targetLevelType:%d", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(i) }));
      return localStVideoUrl;
    }
    QLog.i("BaseVideoView_QCircleVideoUrlExchangeHelper", 1, "getTargetLevelTypeUrl urls size 0");
    return null;
  }
  
  public static vqh a()
  {
    return jdField_a_of_type_Vqh;
  }
  
  public void a(int paramInt, FeedCloudMeta.StVideo paramStVideo, vqj paramvqj)
  {
    if ((paramStVideo == null) || (paramvqj == null)) {
      return;
    }
    if (!a(paramStVideo))
    {
      QLog.i("BaseVideoView_QCircleVideoUrlExchangeHelper", 1, String.format("exchangeVideoUrl: valid callBack fileId:%s ,videoExchange url:%s", new Object[] { paramStVideo.fileId.get(), paramStVideo.playUrl.get() }));
      paramvqj.a(paramStVideo, true);
      return;
    }
    Object localObject = (FeedCloudMeta.StVideo)this.jdField_a_of_type_AndroidUtilLruCache.get(paramStVideo.fileId.get());
    if ((localObject != null) && (((FeedCloudMeta.StVideo)localObject).playUrl.get().trim().length() > 0))
    {
      QLog.i("BaseVideoView_QCircleVideoUrlExchangeHelper", 1, String.format("exchangeVideoUrl: success hit Video Cache fileId:%s ,videoExchange url %s:", new Object[] { ((FeedCloudMeta.StVideo)localObject).fileId.get(), ((FeedCloudMeta.StVideo)localObject).playUrl.get() }));
      paramvqj.a((FeedCloudMeta.StVideo)localObject, false);
      return;
    }
    localObject = new QCircleVideoUrlAdapterRequest(paramStVideo);
    VSNetworkHelper.a().a(paramInt, (VSBaseRequest)localObject, new vqi(this, paramStVideo, paramvqj));
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
          QLog.d("BaseVideoView_QCircleVideoUrlExchangeHelper", 2, String.format("intervalTime:%d, disTime: %d, valid time:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(jdField_a_of_type_Long) }));
          l2 = jdField_a_of_type_Long;
          long l3 = this.jdField_b_of_type_Long;
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
 * Qualified Name:     vqh
 * JD-Core Version:    0.7.0.1
 */