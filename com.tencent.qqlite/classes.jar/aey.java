import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;

public class aey
  implements DialogInterface.OnDismissListener
{
  public aey(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ChatSettingForTroop.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     aey
 * JD-Core Version:    0.7.0.1
 */