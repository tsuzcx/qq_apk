import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ztj
  implements View.OnClickListener
{
  ztj(zti paramzti) {}
  
  public void onClick(View paramView)
  {
    this.a.b(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ztj
 * JD-Core Version:    0.7.0.1
 */