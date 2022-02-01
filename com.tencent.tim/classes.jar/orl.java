import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class orl
  implements View.OnClickListener
{
  orl(ork paramork) {}
  
  public void onClick(View paramView)
  {
    ork.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     orl
 * JD-Core Version:    0.7.0.1
 */