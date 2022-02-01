import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ybr
  implements View.OnClickListener
{
  ybr(ybl paramybl) {}
  
  public void onClick(View paramView)
  {
    ybl.a(this.this$0, paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ybr
 * JD-Core Version:    0.7.0.1
 */