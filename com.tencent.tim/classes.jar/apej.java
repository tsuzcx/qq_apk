import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class apej
  implements View.OnClickListener
{
  apej(apei paramapei) {}
  
  public void onClick(View paramView)
  {
    this.a.hV(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apej
 * JD-Core Version:    0.7.0.1
 */