import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yua
  implements View.OnClickListener
{
  yua(yty paramyty) {}
  
  public void onClick(View paramView)
  {
    if (yty.a(this.a) != null) {
      yty.a(this.a).Q_();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yua
 * JD-Core Version:    0.7.0.1
 */