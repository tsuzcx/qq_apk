import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudWrite.StDoCommentRsp;
import java.util.Map;

class vic
  implements zxa<FeedCloudWrite.StDoCommentRsp>
{
  vic(vhu paramvhu, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoCommentRsp paramStDoCommentRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoCommentRsp == null))
    {
      QLog.e("QCircleCommentBusiness", 1, "addFeedComment error:" + paramLong + "  errorMsg:" + paramString);
      zwp.a().a(new QCircleCommentUpdateEvent(9, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, null, this.jdField_a_of_type_Int));
      return;
    }
    QLog.d("QCircleCommentBusiness", 1, "addFeedComment Success");
    paramString = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get();
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.set(paramStDoCommentRsp.comment.id.get());
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.createTime.set(paramStDoCommentRsp.comment.createTime.get());
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.set(paramStDoCommentRsp.comment.likeInfo.get());
    paramStDoCommentRsp.comment.set(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
    vhu.a(this.jdField_a_of_type_Vhu).put(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), Integer.valueOf(this.jdField_a_of_type_Vhu.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()) + 1));
    paramStDoCommentRsp = new QCircleCommentUpdateEvent(3, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_Vhu.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()), this.jdField_a_of_type_Int);
    paramStDoCommentRsp.fakeCommentId = paramString;
    zwp.a().a(paramStDoCommentRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vic
 * JD-Core Version:    0.7.0.1
 */