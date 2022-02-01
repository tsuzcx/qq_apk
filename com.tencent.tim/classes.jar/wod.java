import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class wod
  implements View.OnClickListener
{
  wod(woc paramwoc) {}
  
  public void onClick(View paramView)
  {
    this.this$0.cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wod
 * JD-Core Version:    0.7.0.1
 */