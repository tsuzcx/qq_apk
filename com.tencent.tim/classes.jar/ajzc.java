import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajzc
  implements View.OnClickListener
{
  public ajzc(StuffContainerView paramStuffContainerView) {}
  
  public void onClick(View paramView)
  {
    if (this.c.a != null) {
      this.c.a.lP(0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajzc
 * JD-Core Version:    0.7.0.1
 */