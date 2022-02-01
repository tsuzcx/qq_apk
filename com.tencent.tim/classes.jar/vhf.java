import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vhf
  implements View.OnClickListener
{
  public vhf(MainFragment paramMainFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.bFv();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vhf
 * JD-Core Version:    0.7.0.1
 */