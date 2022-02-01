import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity.ConfessBrowserFragment;
import com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity.ConfessBrowserFragment.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wqv
  implements View.OnClickListener
{
  public wqv(ConfessHalfScreenActivity.ConfessBrowserFragment.a parama) {}
  
  public void onClick(View paramView)
  {
    this.a.a.getHostActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wqv
 * JD-Core Version:    0.7.0.1
 */