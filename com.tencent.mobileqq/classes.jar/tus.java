import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoTopRsp;

class tus
  implements zac<FeedCloudWrite.StDoTopRsp>
{
  tus(tuk paramtuk, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoTopRsp paramStDoTopRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoTopRsp == null))
    {
      QLog.e(tuk.a(), 1, "stickyFeedComment error:" + paramLong + "  errorMsg:" + paramString);
      return;
    }
    QLog.d(tuk.a(), 1, "sticky Success");
    tuk.a(this.jdField_a_of_type_Tuk, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get());
    yiw.a().a(new QCircleCommentUpdateEvent(6, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_Tuk.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get())));
    umc.a().dispatch(this.jdField_a_of_type_Tuk.a(new Object[] { Integer.valueOf(9), Long.valueOf(paramLong), paramString, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), Integer.valueOf(this.jdField_a_of_type_Tuk.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tus
 * JD-Core Version:    0.7.0.1
 */