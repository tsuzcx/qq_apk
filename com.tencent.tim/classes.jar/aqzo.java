import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqzo
  implements View.OnClickListener
{
  aqzo(aqzl paramaqzl) {}
  
  public void onClick(View paramView)
  {
    this.this$0.c(false, 0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqzo
 * JD-Core Version:    0.7.0.1
 */