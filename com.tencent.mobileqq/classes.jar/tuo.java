import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudWrite.StDoCommentRsp;
import java.util.Map;

class tuo
  implements zac<FeedCloudWrite.StDoCommentRsp>
{
  tuo(tuk paramtuk, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoCommentRsp paramStDoCommentRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoCommentRsp == null))
    {
      QLog.e(tuk.a(), 1, "addFeedComment error:" + paramLong + "  errorMsg:" + paramString);
      return;
    }
    QLog.d(tuk.a(), 1, "addFeedComment Success");
    String str = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get();
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.set(paramStDoCommentRsp.comment.id.get());
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.createTime.set(paramStDoCommentRsp.comment.createTime.get());
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.set(paramStDoCommentRsp.comment.likeInfo.get());
    paramStDoCommentRsp.comment.set(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
    tuk.a(this.jdField_a_of_type_Tuk).put(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), Integer.valueOf(this.jdField_a_of_type_Tuk.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()) + 1));
    yiw.a().a(new QCircleCommentUpdateEvent(1, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_Tuk.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get())));
    umc.a().dispatch(this.jdField_a_of_type_Tuk.a(new Object[] { Integer.valueOf(3), Long.valueOf(paramLong), paramString, paramStDoCommentRsp, str, Integer.valueOf(this.jdField_a_of_type_Tuk.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tuo
 * JD-Core Version:    0.7.0.1
 */