import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agvy
  implements View.OnClickListener
{
  agvy(agvx paramagvx) {}
  
  public void onClick(View paramView)
  {
    this.a.a.iB();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agvy
 * JD-Core Version:    0.7.0.1
 */