import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahnb
  implements View.OnClickListener
{
  public ahnb(IphoneTitleBarFragment paramIphoneTitleBarFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahnb
 * JD-Core Version:    0.7.0.1
 */