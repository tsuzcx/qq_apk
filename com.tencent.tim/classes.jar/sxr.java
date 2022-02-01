import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sxr
  implements View.OnClickListener
{
  sxr(sxn paramsxn) {}
  
  public void onClick(View paramView)
  {
    this.a.bBT();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     sxr
 * JD-Core Version:    0.7.0.1
 */