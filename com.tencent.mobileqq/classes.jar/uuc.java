import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uuc
  implements View.OnClickListener
{
  uuc(uub paramuub) {}
  
  public void onClick(View paramView)
  {
    uub.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uuc
 * JD-Core Version:    0.7.0.1
 */