import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ytz
  implements View.OnClickListener
{
  ytz(yty paramyty) {}
  
  public void onClick(View paramView)
  {
    yty.a(this.a, false);
    this.a.notifyDataSetChanged();
    if (yty.a(this.a) != null) {
      yty.a(this.a).f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ytz
 * JD-Core Version:    0.7.0.1
 */