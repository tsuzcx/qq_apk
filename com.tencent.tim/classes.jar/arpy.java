import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.open.agent.BindGroupConfirmActivity.8;
import com.tencent.qphone.base.util.QLog;

public class arpy
  implements DialogInterface.OnClickListener
{
  public arpy(BindGroupConfirmActivity.8 param8) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.this$0.aH.cancel();
      this.a.this$0.finish();
      return;
    }
    try
    {
      ahkr.a(this.a.this$0, true, "action_game_bind_group", Long.valueOf(this.a.this$0.mAppId).longValue(), -1, this.a.val$message);
      this.a.this$0.aH.cancel();
      BindGroupConfirmActivity.a(this.a.this$0, -1);
      BindGroupConfirmActivity.a(this.a.this$0);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        QLog.e("BindGroupConfirmActivity", 1, "showAlertDlg error = " + paramDialogInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arpy
 * JD-Core Version:    0.7.0.1
 */