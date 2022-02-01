import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class urx
  implements View.OnClickListener
{
  urx(urw paramurw) {}
  
  public void onClick(View paramView)
  {
    urw.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urx
 * JD-Core Version:    0.7.0.1
 */