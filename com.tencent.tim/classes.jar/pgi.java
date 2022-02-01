import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicLikePopWindow;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoLikeRsp;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class pgi
  implements rxc.a<FeedCloudWrite.StDoLikeRsp>
{
  public pgi(QCirclePolymorphicLikePopWindow paramQCirclePolymorphicLikePopWindow, FeedCloudMeta.StFeed paramStFeed, int paramInt, QQCircleFeedBase.StPolyLike paramStPolyLike1, QQCircleFeedBase.StPolyLike paramStPolyLike2) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    QCirclePolymorphicLikePopWindow.b(this.b, true);
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (!QCirclePolymorphicLikePopWindow.c(this.b)) {
        this.b.a(false, true, this.m, this.biC, this.c, this.d);
      }
      QLog.d("QCirclePolylick", 4, " success");
    }
    for (;;)
    {
      QCirclePolymorphicLikePopWindow.a(this.b, true);
      return;
      QLog.d("QCirclePolylick", 4, " failed：" + paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pgi
 * JD-Core Version:    0.7.0.1
 */