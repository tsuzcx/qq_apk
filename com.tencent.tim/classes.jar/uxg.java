import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uxg
  implements View.OnClickListener
{
  public uxg(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.this$0.isFinishing()) {
      ForwardFriendListActivity.a(this.this$0).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uxg
 * JD-Core Version:    0.7.0.1
 */