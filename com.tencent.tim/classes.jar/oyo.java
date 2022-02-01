import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudWrite.StDoReplyRsp;
import java.util.Map;

class oyo
  implements rxc.a<FeedCloudWrite.StDoReplyRsp>
{
  oyo(oyh paramoyh, FeedCloudMeta.StReply paramStReply, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoReplyRsp paramStDoReplyRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoReplyRsp == null))
    {
      QLog.e(oyh.access$200(), 1, "deleteCommentReply error:" + paramLong + "  errorMsg:" + paramString);
      return;
    }
    QLog.d(oyh.access$200(), 1, "deleteCommentReply Success");
    paramStDoReplyRsp.reply.id.set(this.jdField_b_of_type_FeedcloudFeedCloudMeta$StReply.id.get());
    oyh.a(this.a).put(this.jdField_b_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), Integer.valueOf(this.a.aU(this.jdField_b_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()) - 1));
    rwv.a().a(new QCircleCommentUpdateEvent(4, this.jdField_b_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.c, this.jdField_b_of_type_FeedcloudFeedCloudMeta$StReply, this.a.aU(this.jdField_b_of_type_FeedcloudFeedCloudMeta$StFeed.id.get())));
    pmi.a().dispatch(this.a.a(new Object[] { Integer.valueOf(6), Long.valueOf(paramLong), paramString, paramStDoReplyRsp, this.c, Integer.valueOf(this.a.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oyo
 * JD-Core Version:    0.7.0.1
 */