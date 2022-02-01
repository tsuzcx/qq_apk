import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoTopRsp;

class vka
  implements aaav<FeedCloudWrite.StDoTopRsp>
{
  vka(vjy paramvjy, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoTopRsp paramStDoTopRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoTopRsp == null))
    {
      QLog.e("QCircleCommentBusiness", 1, "stickyFeedComment error:" + paramLong + "  errorMsg:" + paramString);
      return;
    }
    QLog.d("QCircleCommentBusiness", 1, "sticky Success");
    vjy.a(this.jdField_a_of_type_Vjy, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get());
    aaak.a().a(new QCircleCommentUpdateEvent(7, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_Vjy.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get()), this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vka
 * JD-Core Version:    0.7.0.1
 */