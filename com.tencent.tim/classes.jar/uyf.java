import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardTroopListFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uyf
  implements View.OnClickListener
{
  public uyf(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  public void onClick(View paramView)
  {
    ForwardTroopListFragment.a(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uyf
 * JD-Core Version:    0.7.0.1
 */