import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xvk
  implements View.OnClickListener
{
  xvk(xvj paramxvj) {}
  
  public void onClick(View paramView)
  {
    xvj.a(this.a, false);
    this.a.notifyDataSetChanged();
    if (xvj.a(this.a) != null) {
      xvj.a(this.a).f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvk
 * JD-Core Version:    0.7.0.1
 */