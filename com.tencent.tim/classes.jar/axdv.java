import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axdv
  implements View.OnClickListener
{
  axdv(axdr paramaxdr) {}
  
  public void onClick(View paramView)
  {
    axdr.a(this.a).Hi();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axdv
 * JD-Core Version:    0.7.0.1
 */