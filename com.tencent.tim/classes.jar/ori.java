import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ori
  implements View.OnClickListener
{
  ori(orh paramorh) {}
  
  public void onClick(View paramView)
  {
    orh.a(this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ori
 * JD-Core Version:    0.7.0.1
 */