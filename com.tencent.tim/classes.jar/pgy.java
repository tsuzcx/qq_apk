import com.tencent.biz.qqcircle.widgets.QCircleFollowView.b;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendWidget.b;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleDitto.StItemInfo;

public class pgy
  implements QCircleFollowView.b
{
  public pgy(QCircleRecommendWidget.b paramb) {}
  
  public void bky()
  {
    String str = "";
    if ((QCircleRecommendWidget.b.a(this.a) instanceof QQCircleDitto.StItemInfo)) {
      str = ((QQCircleDitto.StItemInfo)QCircleRecommendWidget.b.a(this.a)).id.get();
    }
    pcl.a(str, 3, 1, 19, 2, QCircleRecommendWidget.b.a(this.a), QCircleRecommendWidget.b.a(this.a).poster.id.get(), "", QCircleRecommendWidget.b.a(this.a).id.get(), QCircleRecommendWidget.b.b(this.a), QCircleRecommendWidget.b.a(this.a), null);
  }
  
  public void onClick(int paramInt)
  {
    String str = "";
    if ((QCircleRecommendWidget.b.a(this.a) instanceof QQCircleDitto.StItemInfo)) {
      str = ((QQCircleDitto.StItemInfo)QCircleRecommendWidget.b.a(this.a)).id.get();
    }
    if (paramInt > 0) {}
    for (paramInt = 18;; paramInt = 17)
    {
      pcl.a(str, 3, 1, paramInt, 2, QCircleRecommendWidget.b.a(this.a), QCircleRecommendWidget.b.a(this.a).poster.id.get(), "", QCircleRecommendWidget.b.a(this.a).id.get(), QCircleRecommendWidget.b.b(this.a), QCircleRecommendWidget.b.a(this.a), null);
      return;
    }
  }
  
  public void vu(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pgy
 * JD-Core Version:    0.7.0.1
 */