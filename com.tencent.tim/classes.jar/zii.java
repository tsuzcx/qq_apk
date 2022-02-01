import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zii
  implements View.OnClickListener
{
  public zii(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if ((this.val$dialog != null) && (this.val$dialog.isShowing())) {
      this.val$dialog.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zii
 * JD-Core Version:    0.7.0.1
 */