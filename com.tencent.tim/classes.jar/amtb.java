import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amtb
  implements View.OnClickListener
{
  amtb(amta paramamta) {}
  
  public void onClick(View paramView)
  {
    amta.a(this.a).cR(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amtb
 * JD-Core Version:    0.7.0.1
 */