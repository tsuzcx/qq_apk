import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axdp
  implements View.OnClickListener
{
  axdp(axdn paramaxdn) {}
  
  public void onClick(View paramView)
  {
    this.a.eIZ();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axdp
 * JD-Core Version:    0.7.0.1
 */