import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;

public class ada
  implements DialogInterface.OnClickListener
{
  public ada(ChatHistory paramChatHistory) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    new adb(this).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ada
 * JD-Core Version:    0.7.0.1
 */