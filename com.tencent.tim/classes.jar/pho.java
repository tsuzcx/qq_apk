import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pho
  implements View.OnClickListener
{
  pho(phn paramphn) {}
  
  public void onClick(View paramView)
  {
    this.b.HY();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pho
 * JD-Core Version:    0.7.0.1
 */