import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.events.QCircleSelectTabEvent;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderFollowTabFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vod
  implements View.OnClickListener
{
  public vod(QCircleFolderFollowTabFragment paramQCircleFolderFollowTabFragment) {}
  
  public void onClick(View paramView)
  {
    vtq.a("", 22, 13);
    aaak.a().a(new QCircleSelectTabEvent(6));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vod
 * JD-Core Version:    0.7.0.1
 */