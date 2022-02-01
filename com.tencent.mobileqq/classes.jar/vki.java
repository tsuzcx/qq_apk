import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudWrite.StDoReplyRsp;
import java.util.Map;

class vki
  implements aaav<FeedCloudWrite.StDoReplyRsp>
{
  vki(vjy paramvjy, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoReplyRsp paramStDoReplyRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoReplyRsp == null))
    {
      QLog.e("QCircleCommentBusiness", 1, "addCommentReply error:" + paramLong + "  errorMsg:" + paramString);
      aaak.a().a(new QCircleCommentUpdateEvent(10, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply, this.jdField_a_of_type_Int));
      if (!TextUtils.isEmpty(paramString)) {
        vws.a(paramLong, BaseApplicationImpl.getContext(), paramString, 0);
      }
      return;
    }
    QLog.d("QCircleCommentBusiness", 1, "addCommentReply Success");
    paramString = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get();
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.set(paramStDoReplyRsp.reply.id.get());
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.createTime.set(paramStDoReplyRsp.reply.createTime.get());
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.set(paramStDoReplyRsp.reply.likeInfo.get());
    paramStDoReplyRsp.reply.set(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
    vjy.a(this.jdField_a_of_type_Vjy).put(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), Integer.valueOf(this.jdField_a_of_type_Vjy.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()) + 1));
    paramStDoReplyRsp = new QCircleCommentUpdateEvent(5, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply, this.jdField_a_of_type_Vjy.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()), this.jdField_a_of_type_Int);
    paramStDoReplyRsp.fakeReplyId = paramString;
    aaak.a().a(paramStDoReplyRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vki
 * JD-Core Version:    0.7.0.1
 */