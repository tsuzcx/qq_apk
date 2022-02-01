import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.widget.LeftTabBarView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rsl
  implements View.OnClickListener
{
  public rsl(LeftTabBarView paramLeftTabBarView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - LeftTabBarView.a(this.b) < 500L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      LeftTabBarView.a(this.b, l);
      this.b.setSelectedTab(this.val$position, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rsl
 * JD-Core Version:    0.7.0.1
 */