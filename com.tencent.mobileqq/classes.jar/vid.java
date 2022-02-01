import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoCommentRsp;
import java.util.Map;

class vid
  implements zxa<FeedCloudWrite.StDoCommentRsp>
{
  vid(vhu paramvhu, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StFeed paramStFeed, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoCommentRsp paramStDoCommentRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoCommentRsp == null))
    {
      QLog.e("QCircleCommentBusiness", 1, "deleteFeedComment error:" + paramLong + "  errorMsg:" + paramString);
      return;
    }
    QLog.d("QCircleCommentBusiness", 1, "deleteFeedComment Success");
    paramStDoCommentRsp.comment.id.set(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get());
    vhu.a(this.jdField_a_of_type_Vhu).put(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), Integer.valueOf(this.jdField_a_of_type_Vhu.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()) - 1 - this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.vecReply.size()));
    zwp.a().a(new QCircleCommentUpdateEvent(4, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_Vhu.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()), this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vid
 * JD-Core Version:    0.7.0.1
 */