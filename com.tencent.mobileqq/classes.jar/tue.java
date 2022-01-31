import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoTopRsp;

class tue
  implements yvn<FeedCloudWrite.StDoTopRsp>
{
  tue(ttv paramttv, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoTopRsp paramStDoTopRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoTopRsp == null)) {
      QLog.e(ttv.a(), 1, "cancelStickyFeedComment error:" + paramLong + "  errorMsg:" + paramString);
    }
    if (paramLong == 0L)
    {
      QLog.d(ttv.a(), 1, "cancelStickyFeedComment Success");
      ttv.a(this.jdField_a_of_type_Ttv, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), "");
    }
    QLog.d(ttv.a(), 1, "cancel Sticky Success");
    yej.a().a(new QCircleCommentUpdateEvent(7, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_Ttv.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get())));
    uht.a().dispatch(this.jdField_a_of_type_Ttv.a(new Object[] { Integer.valueOf(10), Long.valueOf(paramLong), paramString, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), Integer.valueOf(this.jdField_a_of_type_Ttv.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tue
 * JD-Core Version:    0.7.0.1
 */