import android.util.LruCache;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StVideo;
import qqcircle.QQCircleVideourlexchange.StGetVideoAdaptRsp;

class voa
  implements zxa<QQCircleVideourlexchange.StGetVideoAdaptRsp>
{
  voa(vnz paramvnz, FeedCloudMeta.StVideo paramStVideo, vob paramvob) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleVideourlexchange.StGetVideoAdaptRsp paramStGetVideoAdaptRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetVideoAdaptRsp.videos.size() > 0))
    {
      paramString = (FeedCloudMeta.StVideo)paramStGetVideoAdaptRsp.videos.get(0);
      paramString.fileId.set(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StVideo.fileId.get());
      this.jdField_a_of_type_Vob.a(paramString, false);
      vnz.a(this.jdField_a_of_type_Vnz).put(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StVideo.fileId.get(), paramString);
      QLog.i("QCircleVideoUrlExchangeHelper", 1, String.format("exchangeVideoUrl: success fileId:%s ,videoExchange url %s:", new Object[] { paramString.fileId.get(), paramString.playUrl.get() }));
      return;
    }
    this.jdField_a_of_type_Vob.a(paramLong, paramString);
    QLog.e("QCircleVideoUrlExchangeHelper", 1, String.format("exchangeVideoUrl: failed fileId:%s ,final url:%s, retCode:%d, errMsg:%s", new Object[] { this.jdField_a_of_type_FeedcloudFeedCloudMeta$StVideo.fileId.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StVideo.playUrl.get(), Long.valueOf(paramLong), paramString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     voa
 * JD-Core Version:    0.7.0.1
 */