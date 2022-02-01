import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uud
  implements View.OnClickListener
{
  uud(uub paramuub) {}
  
  public void onClick(View paramView)
  {
    uub.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uud
 * JD-Core Version:    0.7.0.1
 */