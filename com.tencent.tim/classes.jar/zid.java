import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.SearchDialogDismissRunnable;

public class zid
  implements DialogInterface.OnDismissListener
{
  public zid(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.this$0.mHandler.postDelayed(new ChatHistoryTroopMemberFragment.SearchDialogDismissRunnable(this.this$0), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zid
 * JD-Core Version:    0.7.0.1
 */