import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class otg
  implements View.OnClickListener
{
  otg(otd paramotd) {}
  
  public void onClick(View paramView)
  {
    this.a.dA(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     otg
 * JD-Core Version:    0.7.0.1
 */