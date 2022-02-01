import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.events.QCircleSelectTabEvent;
import com.tencent.biz.qqcircle.fragments.QCircleFolderFollowTabFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class pab
  implements View.OnClickListener
{
  public pab(QCircleFolderFollowTabFragment paramQCircleFolderFollowTabFragment) {}
  
  public void onClick(View paramView)
  {
    pco.h("", 22, 13L);
    rwv.a().a(new QCircleSelectTabEvent(6));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pab
 * JD-Core Version:    0.7.0.1
 */