import android.os.Bundle;
import com.tencent.biz.qqcircle.beans.QCircleFakeFeed;
import com.tencent.biz.qqcircle.beans.QCircleFakeFeed.a;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudWrite.StPublishFeedRsp;

class avri
  implements rxc.a<FeedCloudWrite.StPublishFeedRsp>
{
  avri(avre paramavre, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StPublishFeedRsp paramStPublishFeedRsp)
  {
    QLog.d("[QzoneIPCModule_upload2]QCircle", 1, "ACTION_QCIRCLE_PULISH_FEED onReceive isSuccess:" + paramBoolean + " retCode:" + paramLong + " errMsg:" + paramString);
    if ((paramBoolean) && (paramLong == 0L) && (paramStPublishFeedRsp != null) && (paramStPublishFeedRsp.feed != null) && (paramStPublishFeedRsp.feed.id != null))
    {
      localObject = new QCircleFakeFeed.a().a(paramStPublishFeedRsp.feed.id.get()).b(this.vm).a(paramStPublishFeedRsp.feed.createTime.get()).f(paramStPublishFeedRsp.feed.poster.id.get()).a(paramStPublishFeedRsp.feed.feedType.get()).g(paramStPublishFeedRsp.feed.video.playUrl.get()).e(paramStPublishFeedRsp.feed.cover.picUrl.get()).b(paramStPublishFeedRsp.feed.cover.width.get()).c(paramStPublishFeedRsp.feed.cover.height.get()).d(paramStPublishFeedRsp.feed.video.duration.get()).a();
      QLog.d("[QzoneIPCModule_upload2]QCircle", 1, new Object[] { "ACTION_QCIRCLE_PULISH_FEED onReceive feed id:", paramStPublishFeedRsp.feed.id.get(), " clientKey:", this.vm });
      rwv.a().a(new QCircleFeedEvent((QCircleFakeFeed)localObject, 2));
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putLong("key_return_code", paramLong);
    ((Bundle)localObject).putString("key_error_msg", paramString);
    if ((paramStPublishFeedRsp != null) && (paramStPublishFeedRsp.feed != null) && (paramStPublishFeedRsp.feed.id != null)) {
      ((Bundle)localObject).putString("key_stfeed_id", paramStPublishFeedRsp.feed.id.get());
    }
    ((Bundle)localObject).putString("key_clientkey", this.vm);
    this.b.callbackResult(this.val$callbackId, EIPCResult.createResult(0, (Bundle)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avri
 * JD-Core Version:    0.7.0.1
 */