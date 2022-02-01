import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uub
  implements View.OnClickListener
{
  uub(uua paramuua) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a() instanceof utm)) {
      ((utm)this.a.a()).f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uub
 * JD-Core Version:    0.7.0.1
 */