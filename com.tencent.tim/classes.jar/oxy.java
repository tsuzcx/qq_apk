import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class oxy
  implements View.OnClickListener
{
  oxy(oxx paramoxx) {}
  
  public void onClick(View paramView)
  {
    this.a.biw();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oxy
 * JD-Core Version:    0.7.0.1
 */