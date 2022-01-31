import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudWrite.StDoReplyRsp;
import java.util.Map;

class tur
  implements zac<FeedCloudWrite.StDoReplyRsp>
{
  tur(tuk paramtuk, FeedCloudMeta.StReply paramStReply, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoReplyRsp paramStDoReplyRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoReplyRsp == null))
    {
      QLog.e(tuk.a(), 1, "deleteCommentReply error:" + paramLong + "  errorMsg:" + paramString);
      return;
    }
    QLog.d(tuk.a(), 1, "deleteCommentReply Success");
    paramStDoReplyRsp.reply.id.set(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get());
    tuk.a(this.jdField_a_of_type_Tuk).put(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), Integer.valueOf(this.jdField_a_of_type_Tuk.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()) - 1));
    yiw.a().a(new QCircleCommentUpdateEvent(4, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply, this.jdField_a_of_type_Tuk.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get())));
    umc.a().dispatch(this.jdField_a_of_type_Tuk.a(new Object[] { Integer.valueOf(6), Long.valueOf(paramLong), paramString, paramStDoReplyRsp, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, Integer.valueOf(this.jdField_a_of_type_Tuk.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tur
 * JD-Core Version:    0.7.0.1
 */