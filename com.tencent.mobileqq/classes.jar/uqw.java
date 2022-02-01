import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uqw
  implements View.OnClickListener
{
  uqw(uqv paramuqv) {}
  
  public void onClick(View paramView)
  {
    uqv.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqw
 * JD-Core Version:    0.7.0.1
 */