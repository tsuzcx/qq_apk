import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoTopRsp;

class vkb
  implements aaav<FeedCloudWrite.StDoTopRsp>
{
  vkb(vjy paramvjy, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoTopRsp paramStDoTopRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoTopRsp == null))
    {
      QLog.e("QCircleCommentBusiness", 1, "cancelStickyFeedComment error:" + paramLong + "  errorMsg:" + paramString);
      return;
    }
    QLog.d("QCircleCommentBusiness", 1, "cancelStickyFeedComment Success");
    vjy.a(this.jdField_a_of_type_Vjy, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), "");
    aaak.a().a(new QCircleCommentUpdateEvent(8, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_Vjy.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get()), this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vkb
 * JD-Core Version:    0.7.0.1
 */