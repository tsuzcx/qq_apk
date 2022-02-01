import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoCommentRsp;
import java.util.Map;

class oym
  implements rxc.a<FeedCloudWrite.StDoCommentRsp>
{
  oym(oyh paramoyh, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoCommentRsp paramStDoCommentRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoCommentRsp == null))
    {
      QLog.e(oyh.access$200(), 1, "deleteFeedComment error:" + paramLong + "  errorMsg:" + paramString);
      return;
    }
    QLog.d(oyh.access$200(), 1, "deleteFeedComment Success");
    paramStDoCommentRsp.comment.id.set(this.c.id.get());
    oyh.a(this.a).put(this.b.id.get(), Integer.valueOf(this.a.aU(this.b.id.get()) - 1 - this.c.vecReply.size()));
    rwv.a().a(new QCircleCommentUpdateEvent(2, this.b.id.get(), this.c, this.a.aU(this.b.id.get())));
    pmi.a().dispatch(this.a.a(new Object[] { Integer.valueOf(5), Long.valueOf(paramLong), paramString, paramStDoCommentRsp, Integer.valueOf(this.a.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oym
 * JD-Core Version:    0.7.0.1
 */