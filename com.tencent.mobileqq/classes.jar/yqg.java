import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yqg
  implements View.OnClickListener
{
  yqg(yqd paramyqd) {}
  
  public void onClick(View paramView)
  {
    if (yqd.a(this.a) != null) {
      yqd.a(this.a).h();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yqg
 * JD-Core Version:    0.7.0.1
 */