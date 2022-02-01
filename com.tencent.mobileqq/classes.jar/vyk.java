import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vyk
  implements View.OnClickListener
{
  vyk(vyh paramvyh) {}
  
  public void onClick(View paramView)
  {
    vyh.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyk
 * JD-Core Version:    0.7.0.1
 */