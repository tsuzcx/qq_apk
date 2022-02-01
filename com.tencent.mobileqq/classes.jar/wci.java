import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class wci
  implements View.OnClickListener
{
  wci(wch paramwch) {}
  
  public void onClick(View paramView)
  {
    wch.a(this.a, paramView.getContext());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wci
 * JD-Core Version:    0.7.0.1
 */