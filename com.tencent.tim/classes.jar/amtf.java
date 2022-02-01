import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amtf
  implements View.OnClickListener
{
  amtf(amte paramamte, ampw paramampw) {}
  
  public void onClick(View paramView)
  {
    this.b.gJ(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amtf
 * JD-Core Version:    0.7.0.1
 */