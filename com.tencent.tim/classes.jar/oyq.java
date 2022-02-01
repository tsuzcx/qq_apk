import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoTopRsp;

class oyq
  implements rxc.a<FeedCloudWrite.StDoTopRsp>
{
  oyq(oyh paramoyh, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoTopRsp paramStDoTopRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoTopRsp == null))
    {
      QLog.e(oyh.access$200(), 1, "cancelStickyFeedComment error:" + paramLong + "  errorMsg:" + paramString);
      return;
    }
    QLog.d(oyh.access$200(), 1, "cancelStickyFeedComment Success");
    oyh.a(this.a, this.jdField_c_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), "");
    rwv.a().a(new QCircleCommentUpdateEvent(7, this.jdField_c_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.jdField_c_of_type_FeedcloudFeedCloudMeta$StComment, this.a.aU(this.jdField_c_of_type_FeedcloudFeedCloudMeta$StComment.id.get())));
    pmi.a().dispatch(this.a.a(new Object[] { Integer.valueOf(10), Long.valueOf(paramLong), paramString, this.jdField_c_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), Integer.valueOf(this.a.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oyq
 * JD-Core Version:    0.7.0.1
 */