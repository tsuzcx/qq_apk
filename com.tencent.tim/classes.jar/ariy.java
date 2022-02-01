import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ariy
  implements View.OnClickListener
{
  public ariy(SimpleSlidingIndicator paramSimpleSlidingIndicator, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.a.h(this.val$position, true, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ariy
 * JD-Core Version:    0.7.0.1
 */