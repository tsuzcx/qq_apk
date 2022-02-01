import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vof
  implements View.OnClickListener
{
  vof(vod paramvod) {}
  
  public void onClick(View paramView)
  {
    vod.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vof
 * JD-Core Version:    0.7.0.1
 */