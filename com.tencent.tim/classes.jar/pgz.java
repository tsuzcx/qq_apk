import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendWidget.a;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendWidget.b;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto.StItemInfo;

public class pgz
  implements View.OnClickListener
{
  public pgz(QCircleRecommendWidget.b paramb) {}
  
  public void onClick(View paramView)
  {
    FeedCloudMeta.StFeed localStFeed = QCircleRecommendWidget.b.a(this.a);
    if ((localStFeed != null) && ((QCircleRecommendWidget.b.a(this.a) instanceof QQCircleDitto.StItemInfo)))
    {
      QQCircleDitto.StItemInfo localStItemInfo = (QQCircleDitto.StItemInfo)QCircleRecommendWidget.b.a(this.a);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(pcr.a("ext3", String.valueOf(localStFeed.createTime)));
      pcl.a(String.valueOf(localStItemInfo.id.get()), 65, 1, QCircleRecommendWidget.b.b(this.a), localStFeed, localArrayList);
      if (QCircleRecommendWidget.b.a(this.a) != null)
      {
        QCircleRecommendWidget.b.a(this.a).af(QCircleRecommendWidget.b.a(this.a));
        if (QCircleRecommendWidget.b.a(this.a).getItemCount() <= 0) {
          rwv.a().a(new QCircleFeedEvent(localStFeed.id.get(), 3));
        }
      }
      QQToast.a(QCircleRecommendWidget.b.a(this.a).getContext(), 2, 2131700079, 0).show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.e("QCircleRecommendWidget", 2, "report hide item error! mParentFeed or itemInfo is null!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pgz
 * JD-Core Version:    0.7.0.1
 */