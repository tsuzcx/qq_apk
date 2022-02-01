import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zmz
  implements View.OnClickListener
{
  public zmz(ServiceFolderFollowPBHeadView paramServiceFolderFollowPBHeadView) {}
  
  public void onClick(View paramView)
  {
    if (ServiceFolderFollowPBHeadView.a(this.a) != null) {
      ServiceFolderFollowPBHeadView.a(this.a).setCurrentItem(1, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zmz
 * JD-Core Version:    0.7.0.1
 */