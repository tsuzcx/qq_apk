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

class oyl
  implements rxc.a<FeedCloudWrite.StDoCommentRsp>
{
  oyl(oyh paramoyh, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoCommentRsp paramStDoCommentRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoCommentRsp == null))
    {
      QLog.e(oyh.access$200(), 1, "addFeedComment error:" + paramLong + "  errorMsg:" + paramString);
      return;
    }
    QLog.d(oyh.access$200(), 1, "addFeedComment Success");
    String str = this.c.id.get();
    this.c.id.set(paramStDoCommentRsp.comment.id.get());
    this.c.createTime.set(paramStDoCommentRsp.comment.createTime.get());
    this.c.likeInfo.set(paramStDoCommentRsp.comment.likeInfo.get());
    paramStDoCommentRsp.comment.set(this.c);
    oyh.a(this.a).put(this.b.id.get(), Integer.valueOf(this.a.aU(this.b.id.get()) + 1));
    rwv.a().a(new QCircleCommentUpdateEvent(1, this.b.id.get(), this.c, this.a.aU(this.b.id.get())));
    pmi.a().dispatch(this.a.a(new Object[] { Integer.valueOf(3), Long.valueOf(paramLong), paramString, paramStDoCommentRsp, str, Integer.valueOf(this.a.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oyl
 * JD-Core Version:    0.7.0.1
 */