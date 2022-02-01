import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vby
  implements View.OnClickListener
{
  vby(vbw paramvbw) {}
  
  public void onClick(View paramView)
  {
    vbw.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vby
 * JD-Core Version:    0.7.0.1
 */