import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class apqi
  implements View.OnClickListener
{
  public apqi(BulkSendMessageFragment paramBulkSendMessageFragment) {}
  
  public void onClick(View paramView)
  {
    BulkSendMessageFragment.a(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apqi
 * JD-Core Version:    0.7.0.1
 */