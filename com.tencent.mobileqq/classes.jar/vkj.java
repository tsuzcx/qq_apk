import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudWrite.StDoReplyRsp;
import java.util.Map;

class vkj
  implements aaav<FeedCloudWrite.StDoReplyRsp>
{
  vkj(vjy paramvjy, FeedCloudMeta.StReply paramStReply, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoReplyRsp paramStDoReplyRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoReplyRsp == null))
    {
      QLog.e("QCircleCommentBusiness", 1, "deleteCommentReply error:" + paramLong + "  errorMsg:" + paramString);
      return;
    }
    QLog.d("QCircleCommentBusiness", 1, "deleteCommentReply Success");
    paramStDoReplyRsp.reply.id.set(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get());
    vjy.a(this.jdField_a_of_type_Vjy).put(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), Integer.valueOf(this.jdField_a_of_type_Vjy.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()) - 1));
    aaak.a().a(new QCircleCommentUpdateEvent(6, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply, this.jdField_a_of_type_Vjy.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()), this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vkj
 * JD-Core Version:    0.7.0.1
 */