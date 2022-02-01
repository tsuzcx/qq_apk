import com.tencent.biz.qqcircle.events.QCirclePraiseUpdateEvent;
import com.tencent.biz.qqcircle.widgets.QCirclePraiseImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudWrite.StDoLikeRsp;

public class pgk
  implements rxc.a<FeedCloudWrite.StDoLikeRsp>
{
  public pgk(QCirclePraiseImageView paramQCirclePraiseImageView, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    int i = 1;
    QCirclePraiseImageView.a(this.a, true);
    if ((paramBoolean) && (paramLong == 0L))
    {
      QCirclePraiseImageView.a(this.a).likeInfo.status.set(this.biD);
      this.a.vx(this.biD);
      int j = QCirclePraiseImageView.a(this.a).likeInfo.count.get();
      if (this.biD == 1) {}
      for (;;)
      {
        i += j;
        QCirclePraiseImageView.a(this.a).likeInfo.count.set(i);
        rwv.a().a(new QCirclePraiseUpdateEvent(QCirclePraiseImageView.a(this.a).id.get(), this.biD, i));
        return;
        i = -1;
      }
    }
    QLog.d("QCircleFeedItemBottomPresenter", 4, "zan failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pgk
 * JD-Core Version:    0.7.0.1
 */