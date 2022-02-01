import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class osk
  implements View.OnClickListener
{
  osk(osj paramosj) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.b() instanceof orw)) {
      ((orw)this.a.b()).bgq();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     osk
 * JD-Core Version:    0.7.0.1
 */