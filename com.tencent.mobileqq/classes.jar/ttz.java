import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tribe.async.dispatch.Dispatcher;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudWrite.StDoCommentRsp;
import java.util.Map;

class ttz
  implements yvn<FeedCloudWrite.StDoCommentRsp>
{
  ttz(ttv paramttv, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoCommentRsp paramStDoCommentRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoCommentRsp == null)) {
      return;
    }
    String str = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get();
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.set(paramStDoCommentRsp.comment.id.get());
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.createTime.set(paramStDoCommentRsp.comment.createTime.get());
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.set(paramStDoCommentRsp.comment.likeInfo.get());
    paramStDoCommentRsp.comment.set(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
    ttv.a(this.jdField_a_of_type_Ttv).put(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), Integer.valueOf(this.jdField_a_of_type_Ttv.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()) + 1));
    yej.a().a(new QCircleCommentUpdateEvent(1, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_Ttv.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get())));
    uht.a().dispatch(this.jdField_a_of_type_Ttv.a(new Object[] { Integer.valueOf(3), Long.valueOf(paramLong), paramString, paramStDoCommentRsp, str, Integer.valueOf(this.jdField_a_of_type_Ttv.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ttz
 * JD-Core Version:    0.7.0.1
 */