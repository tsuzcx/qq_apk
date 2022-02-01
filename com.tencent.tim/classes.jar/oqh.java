import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class oqh
  implements View.OnClickListener
{
  oqh(oqf paramoqf) {}
  
  public void onClick(View paramView)
  {
    oqf.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oqh
 * JD-Core Version:    0.7.0.1
 */