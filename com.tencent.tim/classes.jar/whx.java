import Wallet.AcsMsg;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class whx
  implements View.OnClickListener
{
  public whx(ReminderListFragment paramReminderListFragment) {}
  
  public void onClick(View paramView)
  {
    AcsMsg localAcsMsg = (AcsMsg)paramView.getTag();
    ReminderListFragment.a(this.this$0, localAcsMsg);
    if (ReminderListFragment.a(this.this$0) != null) {
      ReminderListFragment.a(this.this$0).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     whx
 * JD-Core Version:    0.7.0.1
 */