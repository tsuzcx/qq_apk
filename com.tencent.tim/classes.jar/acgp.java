import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acgp
  implements View.OnClickListener
{
  public acgp(IphoneTitleBarActivity paramIphoneTitleBarActivity) {}
  
  public void onClick(View paramView)
  {
    this.c.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acgp
 * JD-Core Version:    0.7.0.1
 */