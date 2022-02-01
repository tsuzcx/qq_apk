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

class oyn
  implements rxc.a<FeedCloudWrite.StDoReplyRsp>
{
  oyn(oyh paramoyh, FeedCloudMeta.StReply paramStReply, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoReplyRsp paramStDoReplyRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoReplyRsp == null))
    {
      QLog.e(oyh.access$200(), 1, "addCommentReply error:" + paramLong + "  errorMsg:" + paramString);
      return;
    }
    QLog.d(oyh.access$200(), 1, "addCommentReply Success");
    String str = this.jdField_b_of_type_FeedcloudFeedCloudMeta$StReply.id.get();
    this.jdField_b_of_type_FeedcloudFeedCloudMeta$StReply.id.set(paramStDoReplyRsp.reply.id.get());
    this.jdField_b_of_type_FeedcloudFeedCloudMeta$StReply.createTime.set(paramStDoReplyRsp.reply.createTime.get());
    this.jdField_b_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.set(paramStDoReplyRsp.reply.likeInfo.get());
    paramStDoReplyRsp.reply.set(this.jdField_b_of_type_FeedcloudFeedCloudMeta$StReply);
    oyh.a(this.a).put(this.jdField_b_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), Integer.valueOf(this.a.aU(this.jdField_b_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()) + 1));
    QCircleCommentUpdateEvent localQCircleCommentUpdateEvent = new QCircleCommentUpdateEvent(3, this.jdField_b_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.c, this.jdField_b_of_type_FeedcloudFeedCloudMeta$StReply, this.a.aU(this.jdField_b_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()));
    localQCircleCommentUpdateEvent.mFakeReplyId = str;
    rwv.a().a(localQCircleCommentUpdateEvent);
    pmi.a().dispatch(this.a.a(new Object[] { Integer.valueOf(4), Long.valueOf(paramLong), paramString, paramStDoReplyRsp, this.c, str, Integer.valueOf(this.a.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oyn
 * JD-Core Version:    0.7.0.1
 */