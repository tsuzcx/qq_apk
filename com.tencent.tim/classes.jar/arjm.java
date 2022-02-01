import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arjm
  implements View.OnClickListener
{
  public arjm(TipsBar paramTipsBar) {}
  
  public void onClick(View paramView)
  {
    this.g.removeAllViews();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     arjm
 * JD-Core Version:    0.7.0.1
 */