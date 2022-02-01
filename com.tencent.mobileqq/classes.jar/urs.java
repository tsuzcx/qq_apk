import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class urs
  implements View.OnClickListener
{
  urs(urq paramurq) {}
  
  public void onClick(View paramView)
  {
    urq.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urs
 * JD-Core Version:    0.7.0.1
 */