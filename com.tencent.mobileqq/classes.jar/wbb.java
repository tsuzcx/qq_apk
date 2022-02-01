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

class wbb
  implements View.OnClickListener
{
  wbb(waz paramwaz) {}
  
  public void onClick(View paramView)
  {
    FeedCloudMeta.StFeed localStFeed = waz.h(this.a);
    if ((localStFeed != null) && ((waz.e(this.a) instanceof QQCircleDitto.StItemInfo)))
    {
      QQCircleDitto.StItemInfo localStItemInfo = (QQCircleDitto.StItemInfo)waz.f(this.a);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(vtt.a("ext3", String.valueOf(localStFeed.createTime)));
      vtn.a(localStItemInfo.id.get(), 3, 1, 65, 1, waz.h(this.a), waz.i(this.a).id.get(), "", waz.j(this.a).poster.id.get(), waz.i(this.a), waz.k(this.a), localArrayList, waz.j(this.a), -1);
      vud.a().a(new vuf().a("closebutton").b("click").a(waz.l(this.a)).a(this.a.a()).a(waz.k(this.a)).c(localStItemInfo.id.get()));
      if (waz.a(this.a) != null)
      {
        waz.b(this.a).a(waz.g(this.a), 1);
        if (waz.c(this.a).getItemCount() <= 0) {
          aaak.a().a(new QCircleFeedEvent(localStFeed.id.get(), 3));
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
 * Qualified Name:     wbb
 * JD-Core Version:    0.7.0.1
 */