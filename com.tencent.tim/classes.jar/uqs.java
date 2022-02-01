import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ChatSettingForTroop.51;
import com.tencent.qphone.base.util.QLog;

public class uqs
  implements DialogInterface.OnClickListener
{
  public uqs(ChatSettingForTroop.51 param51) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.this$0.x.cancel();
      return;
    }
    try
    {
      ahkr.a(this.a.this$0, true, "action_game_join_group", Long.valueOf(this.a.this$0.aMk).longValue(), -1, this.a.val$message);
      this.a.this$0.x.cancel();
      this.a.this$0.finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        QLog.e("Q.chatopttroop", 1, "showAlertDlg error = " + paramDialogInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uqs
 * JD-Core Version:    0.7.0.1
 */