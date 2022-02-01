import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class yaq
  implements DialogInterface.OnClickListener
{
  yaq(yap paramyap) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.this$0.ah = new ReportDialog(this.a.this$0.a(), 2131756467);
    this.a.this$0.ah.setContentView(2131558460);
    this.a.this$0.ah.setCancelable(true);
    ((TextView)this.a.this$0.ah.findViewById(2131365863)).setText(this.a.this$0.a().getString(2131719519));
    this.a.this$0.ah.show();
    ((acfv)this.a.this$0.app.getBusinessHandler(35)).b(this.a.this$0.sessionInfo.aTl, this.a.this$0.sessionInfo.troopUin, this.a.e.senderuin, this.a.val$nick, 1);
    anot.a(this.a.this$0.app, "CliOper", "", "", "0X8005D55", "0X8005D55", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     yaq
 * JD-Core Version:    0.7.0.1
 */