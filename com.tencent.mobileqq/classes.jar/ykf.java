import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ykf
  implements View.OnClickListener
{
  ykf(yke paramyke) {}
  
  public void onClick(View paramView)
  {
    yke.a(this.a, false);
    this.a.notifyDataSetChanged();
    if (yke.a(this.a) != null) {
      yke.a(this.a).f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ykf
 * JD-Core Version:    0.7.0.1
 */