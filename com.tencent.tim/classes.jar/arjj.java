import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arjj
  implements View.OnClickListener
{
  public arjj(TabBarView paramTabBarView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.f.avU < 500L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.f.avU = l;
      this.f.setSelectedTab(this.val$position, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arjj
 * JD-Core Version:    0.7.0.1
 */