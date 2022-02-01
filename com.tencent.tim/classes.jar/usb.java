import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.UpgradeTIMManager;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;

public class usb
  implements DialogInterface.OnClickListener
{
  public usb(Conversation paramConversation, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Conversation.a(this.this$0, null);
    ((UpgradeTIMManager)this.this$0.app.getManager(256)).cl(this.this$0.a(), this.b.url);
    anot.a(this.this$0.app, "CliOper", "", "", "0X800815D", "0X800815D", 0, 0, "", "", "", "");
    anot.a(this.this$0.app, "CliOper", "", "", "0X8008657", "0X8008657", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     usb
 * JD-Core Version:    0.7.0.1
 */