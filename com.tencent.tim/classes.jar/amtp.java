import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amtp
  implements View.OnClickListener
{
  amtp(amtn paramamtn, amqc paramamqc) {}
  
  public void onClick(View paramView)
  {
    this.b.cR(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amtp
 * JD-Core Version:    0.7.0.1
 */