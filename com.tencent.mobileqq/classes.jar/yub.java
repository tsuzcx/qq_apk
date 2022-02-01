import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yub
  implements View.OnClickListener
{
  yub(yty paramyty) {}
  
  public void onClick(View paramView)
  {
    if (yty.a(this.a) != null) {
      yty.a(this.a).h();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yub
 * JD-Core Version:    0.7.0.1
 */