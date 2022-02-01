import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sdr
  implements View.OnClickListener
{
  sdr(sdq paramsdq, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.b.a.eB(this.val$position, sdq.a(this.b));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sdr
 * JD-Core Version:    0.7.0.1
 */