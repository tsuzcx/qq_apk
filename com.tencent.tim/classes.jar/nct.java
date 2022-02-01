import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nct
  implements View.OnClickListener
{
  nct(ncs paramncs, kge paramkge) {}
  
  public void onClick(View paramView)
  {
    this.c.refreshList();
    this.b.aVE();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nct
 * JD-Core Version:    0.7.0.1
 */