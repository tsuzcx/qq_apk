import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;

public class adf
  implements DialogInterface.OnClickListener
{
  public adf(ChatHistory paramChatHistory) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatHistory.a(this.a).setEnabled(true);
    this.a.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     adf
 * JD-Core Version:    0.7.0.1
 */