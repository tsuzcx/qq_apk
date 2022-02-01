import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto.StItemInfo;

class vyj
  implements View.OnClickListener
{
  vyj(vyh paramvyh) {}
  
  public void onClick(View paramView)
  {
    FeedCloudMeta.StFeed localStFeed = vyh.a(this.a);
    if ((localStFeed != null) && ((vyh.a(this.a) instanceof QQCircleDitto.StItemInfo)))
    {
      QQCircleDitto.StItemInfo localStItemInfo = (QQCircleDitto.StItemInfo)vyh.a(this.a);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(vri.a("ext3", String.valueOf(localStFeed.createTime)));
      vrc.a(localStItemInfo.id.get(), 3, 1, 65, 1, vyh.a(this.a), vyh.a(this.a).id.get(), "", vyh.a(this.a).poster.id.get(), vyh.b(this.a), vyh.a(this.a), localArrayList, vyh.c(this.a), -1);
      vrr.a().a(new vrt().a("closebutton").b("click").a(vyh.a(this.a)).a(this.a.a()).a(vyh.a(this.a)).c(localStItemInfo.id.get()));
      if (vyh.a(this.a) != null)
      {
        vyh.a(this.a).a(vyh.a(this.a));
        if (vyh.a(this.a).getItemCount() <= 0) {
          zwp.a().a(new QCircleFeedEvent(localStFeed.id.get(), 3));
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.e("QCircleRecommendWidget", 2, "report hide item error! mParentFeed or itemInfo is null!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyj
 * JD-Core Version:    0.7.0.1
 */