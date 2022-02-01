import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xvm
  implements View.OnClickListener
{
  xvm(xvj paramxvj) {}
  
  public void onClick(View paramView)
  {
    if (xvj.a(this.a) != null) {
      xvj.a(this.a).h();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvm
 * JD-Core Version:    0.7.0.1
 */