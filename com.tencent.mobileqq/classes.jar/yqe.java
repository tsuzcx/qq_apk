import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yqe
  implements View.OnClickListener
{
  yqe(yqd paramyqd) {}
  
  public void onClick(View paramView)
  {
    yqd.a(this.a, false);
    this.a.notifyDataSetChanged();
    if (yqd.a(this.a) != null) {
      yqd.a(this.a).f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yqe
 * JD-Core Version:    0.7.0.1
 */