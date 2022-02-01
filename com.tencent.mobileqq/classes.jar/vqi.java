import android.util.LruCache;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StVideo;
import qqcircle.QQCircleVideourlexchange.StGetVideoAdaptRsp;

class vqi
  implements aaav<QQCircleVideourlexchange.StGetVideoAdaptRsp>
{
  vqi(vqh paramvqh, FeedCloudMeta.StVideo paramStVideo, vqj paramvqj) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleVideourlexchange.StGetVideoAdaptRsp paramStGetVideoAdaptRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetVideoAdaptRsp.videos.size() > 0))
    {
      paramStGetVideoAdaptRsp = (FeedCloudMeta.StVideo)paramStGetVideoAdaptRsp.videos.get(0);
      paramStGetVideoAdaptRsp.fileId.set(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StVideo.fileId.get());
      if (paramStGetVideoAdaptRsp.playUrl.get().trim().length() > 0)
      {
        this.jdField_a_of_type_Vqj.a(paramStGetVideoAdaptRsp, false);
        vqh.a(this.jdField_a_of_type_Vqh).put(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StVideo.fileId.get(), paramStGetVideoAdaptRsp);
        QLog.i("BaseVideoView_QCircleVideoUrlExchangeHelper", 1, String.format("exchangeVideoUrl: success fileId:%s ,videoExchange url %s:", new Object[] { paramStGetVideoAdaptRsp.fileId.get(), paramStGetVideoAdaptRsp.playUrl.get() }));
        return;
      }
      this.jdField_a_of_type_Vqj.a(paramLong, paramString);
      QLog.e("BaseVideoView_QCircleVideoUrlExchangeHelper", 1, String.format("exchangeVideoUrl: failed fileId:%s ,final url:%s, retCode:%d, errMsg:%s", new Object[] { this.jdField_a_of_type_FeedcloudFeedCloudMeta$StVideo.fileId.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StVideo.playUrl.get(), Long.valueOf(paramLong), paramString }));
      return;
    }
    this.jdField_a_of_type_Vqj.a(paramLong, paramString);
    QLog.e("BaseVideoView_QCircleVideoUrlExchangeHelper", 1, String.format("exchangeVideoUrl: failed fileId:%s ,final url:%s, retCode:%d, errMsg:%s", new Object[] { this.jdField_a_of_type_FeedcloudFeedCloudMeta$StVideo.fileId.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StVideo.playUrl.get(), Long.valueOf(paramLong), paramString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqi
 * JD-Core Version:    0.7.0.1
 */