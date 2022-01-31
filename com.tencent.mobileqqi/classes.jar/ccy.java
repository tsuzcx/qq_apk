import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;

public class ccy
  implements DialogInterface.OnClickListener
{
  public ccy(ChatActivity paramChatActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivity.a(this.a, this.a.a.a);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ccy
 * JD-Core Version:    0.7.0.1
 */