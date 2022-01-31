import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudWrite.StDoReplyRsp;
import java.util.Map;

class tuq
  implements zac<FeedCloudWrite.StDoReplyRsp>
{
  tuq(tuk paramtuk, FeedCloudMeta.StReply paramStReply, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoReplyRsp paramStDoReplyRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoReplyRsp == null))
    {
      QLog.e(tuk.a(), 1, "addCommentReply error:" + paramLong + "  errorMsg:" + paramString);
      return;
    }
    QLog.d(tuk.a(), 1, "addCommentReply Success");
    String str = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get();
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.set(paramStDoReplyRsp.reply.id.get());
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.createTime.set(paramStDoReplyRsp.reply.createTime.get());
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.set(paramStDoReplyRsp.reply.likeInfo.get());
    paramStDoReplyRsp.reply.set(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
    tuk.a(this.jdField_a_of_type_Tuk).put(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), Integer.valueOf(this.jdField_a_of_type_Tuk.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()) + 1));
    QCircleCommentUpdateEvent localQCircleCommentUpdateEvent = new QCircleCommentUpdateEvent(3, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply, this.jdField_a_of_type_Tuk.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()));
    localQCircleCommentUpdateEvent.mFakeReplyId = str;
    yiw.a().a(localQCircleCommentUpdateEvent);
    umc.a().dispatch(this.jdField_a_of_type_Tuk.a(new Object[] { Integer.valueOf(4), Long.valueOf(paramLong), paramString, paramStDoReplyRsp, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, str, Integer.valueOf(this.jdField_a_of_type_Tuk.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tuq
 * JD-Core Version:    0.7.0.1
 */