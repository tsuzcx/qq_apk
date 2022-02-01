import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ykg
  implements View.OnClickListener
{
  ykg(yke paramyke) {}
  
  public void onClick(View paramView)
  {
    if (yke.a(this.a) != null) {
      yke.a(this.a).M_();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ykg
 * JD-Core Version:    0.7.0.1
 */