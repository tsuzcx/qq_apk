import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amto
  implements View.OnClickListener
{
  amto(amtn paramamtn, amqg paramamqg) {}
  
  public void onClick(View paramView)
  {
    this.c.cR(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amto
 * JD-Core Version:    0.7.0.1
 */