import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sxs
  implements View.OnClickListener
{
  sxs(sxn paramsxn) {}
  
  public void onClick(View paramView)
  {
    this.a.bBU();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     sxs
 * JD-Core Version:    0.7.0.1
 */