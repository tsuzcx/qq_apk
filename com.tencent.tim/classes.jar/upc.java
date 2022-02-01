import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingActivity;

public class upc
  implements DialogInterface.OnClickListener
{
  public upc(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((ChatSettingActivity.a(this.this$0) != null) && (ChatSettingActivity.a(this.this$0).isShowing())) {
      ChatSettingActivity.a(this.this$0).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     upc
 * JD-Core Version:    0.7.0.1
 */