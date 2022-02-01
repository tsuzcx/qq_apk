import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rrm
  implements View.OnClickListener
{
  rrm(rrl paramrrl) {}
  
  public void onClick(View paramView)
  {
    this.b.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rrm
 * JD-Core Version:    0.7.0.1
 */