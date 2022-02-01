import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amsl
  implements View.OnClickListener
{
  amsl(amsk paramamsk, amrd paramamrd) {}
  
  public void onClick(View paramView)
  {
    this.c.cR(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amsl
 * JD-Core Version:    0.7.0.1
 */