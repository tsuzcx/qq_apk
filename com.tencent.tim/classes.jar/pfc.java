import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.a;
import com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

public class pfc
  implements QCircleAsyncTextView.a
{
  public pfc(QCircleFeedCommentWidget paramQCircleFeedCommentWidget, FeedCloudMeta.StReply paramStReply) {}
  
  public void onClick()
  {
    pcl.a(this.b.postUser.id.get(), QCircleFeedCommentWidget.a(this.a).mFeed, QCircleFeedCommentWidget.a(this.a), 44);
    oux.qm(this.b.postUser.id.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pfc
 * JD-Core Version:    0.7.0.1
 */