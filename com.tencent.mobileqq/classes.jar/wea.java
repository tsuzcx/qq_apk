import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class wea
  implements View.OnClickListener
{
  wea(wdx paramwdx) {}
  
  public void onClick(View paramView)
  {
    if (wdx.a(this.a) != null) {
      wdx.a(this.a).a(wdx.a(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wea
 * JD-Core Version:    0.7.0.1
 */