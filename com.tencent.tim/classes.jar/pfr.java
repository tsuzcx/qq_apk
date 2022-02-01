import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.widgets.QCircleFollowTagListItemView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StTagInfo;

public class pfr
  implements View.OnClickListener
{
  public pfr(QCircleFollowTagListItemView paramQCircleFollowTagListItemView) {}
  
  public void onClick(View paramView)
  {
    QCircleFollowTagListItemView localQCircleFollowTagListItemView = this.a;
    if (QCircleFollowTagListItemView.a(this.a).isTop.get() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localQCircleFollowTagListItemView.ru(bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pfr
 * JD-Core Version:    0.7.0.1
 */