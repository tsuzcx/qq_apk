import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.a;
import com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StUser;

public class pfb
  implements QCircleAsyncTextView.a
{
  public pfb(QCircleFeedCommentWidget paramQCircleFeedCommentWidget, FeedCloudMeta.StComment paramStComment) {}
  
  public void onClick()
  {
    pcl.a(this.c.postUser.id.get(), QCircleFeedCommentWidget.a(this.a).mFeed, QCircleFeedCommentWidget.a(this.a), 44);
    oux.qm(this.c.postUser.id.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pfb
 * JD-Core Version:    0.7.0.1
 */