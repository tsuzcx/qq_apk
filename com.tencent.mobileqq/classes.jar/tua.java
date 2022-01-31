import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.Dispatcher;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoCommentRsp;
import java.util.Map;

class tua
  implements yvn<FeedCloudWrite.StDoCommentRsp>
{
  tua(ttv paramttv, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoCommentRsp paramStDoCommentRsp)
  {
    if (paramStDoCommentRsp != null) {
      paramStDoCommentRsp.comment.id.set(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get());
    }
    ttv.a(this.jdField_a_of_type_Ttv).put(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), Integer.valueOf(this.jdField_a_of_type_Ttv.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()) - 1 - this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.vecReply.size()));
    yej.a().a(new QCircleCommentUpdateEvent(2, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_Ttv.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get())));
    uht.a().dispatch(this.jdField_a_of_type_Ttv.a(new Object[] { Integer.valueOf(5), Long.valueOf(paramLong), paramString, paramStDoCommentRsp, Integer.valueOf(this.jdField_a_of_type_Ttv.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tua
 * JD-Core Version:    0.7.0.1
 */