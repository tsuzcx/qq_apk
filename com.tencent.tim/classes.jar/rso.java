import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rso
  implements View.OnClickListener
{
  rso(rsn paramrsn) {}
  
  public void onClick(View paramView)
  {
    this.b.ui(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rso
 * JD-Core Version:    0.7.0.1
 */