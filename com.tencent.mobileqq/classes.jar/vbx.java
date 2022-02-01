import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vbx
  implements View.OnClickListener
{
  vbx(vbw paramvbw) {}
  
  public void onClick(View paramView)
  {
    vbw.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbx
 * JD-Core Version:    0.7.0.1
 */