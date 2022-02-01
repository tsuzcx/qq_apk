import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amtk
  implements View.OnClickListener
{
  amtk(amtj paramamtj, ampw paramampw) {}
  
  public void onClick(View paramView)
  {
    this.c.gJ(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amtk
 * JD-Core Version:    0.7.0.1
 */