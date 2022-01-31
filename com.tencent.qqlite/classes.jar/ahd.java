import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.Conversation;

public class ahd
  implements DialogInterface.OnDismissListener
{
  public ahd(Conversation paramConversation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == Conversation.a(this.a)) {
      Conversation.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ahd
 * JD-Core Version:    0.7.0.1
 */