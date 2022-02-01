import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agwd
  implements View.OnClickListener
{
  agwd(agwc paramagwc) {}
  
  public void onClick(View paramView)
  {
    this.b.djX();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agwd
 * JD-Core Version:    0.7.0.1
 */