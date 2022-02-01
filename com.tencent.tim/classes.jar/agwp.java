import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agwp
  implements View.OnClickListener
{
  agwp(agwn paramagwn) {}
  
  public void onClick(View paramView)
  {
    agwn.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agwp
 * JD-Core Version:    0.7.0.1
 */