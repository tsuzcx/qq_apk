import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.Dispatcher;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudWrite.StDoReplyRsp;
import java.util.Map;

class tuc
  implements yvn<FeedCloudWrite.StDoReplyRsp>
{
  tuc(ttv paramttv, FeedCloudMeta.StReply paramStReply, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoReplyRsp paramStDoReplyRsp)
  {
    if (paramStDoReplyRsp != null) {
      paramStDoReplyRsp.reply.id.set(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get());
    }
    ttv.a(this.jdField_a_of_type_Ttv).put(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), Integer.valueOf(this.jdField_a_of_type_Ttv.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()) - 1));
    yej.a().a(new QCircleCommentUpdateEvent(4, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply, this.jdField_a_of_type_Ttv.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get())));
    uht.a().dispatch(this.jdField_a_of_type_Ttv.a(new Object[] { Integer.valueOf(6), Long.valueOf(paramLong), paramString, paramStDoReplyRsp, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, Integer.valueOf(this.jdField_a_of_type_Ttv.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tuc
 * JD-Core Version:    0.7.0.1
 */