import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.Conversation;

public class usc
  implements DialogInterface.OnDismissListener
{
  public usc(Conversation paramConversation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == Conversation.a(this.this$0)) {
      Conversation.a(this.this$0, null);
    }
    this.this$0.h(1134057, 50L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     usc
 * JD-Core Version:    0.7.0.1
 */