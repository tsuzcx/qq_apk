import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uww
  implements View.OnClickListener
{
  uww(uwt paramuwt) {}
  
  public void onClick(View paramView)
  {
    this.a.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uww
 * JD-Core Version:    0.7.0.1
 */