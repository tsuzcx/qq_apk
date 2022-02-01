import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xtv
  implements View.OnClickListener
{
  xtv(xtu paramxtu) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (this.a.a.a != null) {
      this.a.a.a.a(paramView, this.a.a.a(i));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtv
 * JD-Core Version:    0.7.0.1
 */