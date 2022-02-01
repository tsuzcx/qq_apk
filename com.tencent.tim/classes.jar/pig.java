import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.a;
import com.tencent.biz.qqcircle.widgets.message.item.QCircleMessageReplyItemView;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

public class pig
  implements QCircleAsyncTextView.a
{
  public pig(QCircleMessageReplyItemView paramQCircleMessageReplyItemView, FeedCloudMeta.StReply paramStReply) {}
  
  public void onClick()
  {
    pcl.a(this.b.postUser.id.get(), QCircleMessageReplyItemView.a(this.a).mFeed, QCircleMessageReplyItemView.a(this.a), 44);
    oux.qm(this.b.postUser.id.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pig
 * JD-Core Version:    0.7.0.1
 */