import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aa
  implements DialogInterface.OnClickListener
{
  public aa(LiteActivity paramLiteActivity, long paramLong, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$0.getIntent().getIntExtra("forward_type", -1) == 11) {
      arts.a().a(this.this$0.app.getAccount(), "", String.valueOf(this.Y), "1000", "51", "0", false);
    }
    if (QLog.isColorLevel()) {
      QLog.i(LiteActivity.TAG, 2, "qbShowShareResultDialog back");
    }
    if (this.this$0.getIntent().getBooleanExtra("MigSdkShareNotDone", false))
    {
      this.this$0.getIntent().putExtra("MigSdkShareNotDone", false);
      ahkr.a(this.this$0, true, "sendToMyComputer", this.Y);
    }
    for (;;)
    {
      jqo.a(this.val$context, 0, "", "");
      this.this$0.finish();
      if (this.this$0.getIntent().getBooleanExtra("show_share_result_dialog_return_thirdapp", true)) {}
      try
      {
        this.this$0.getActivity().moveTaskToBack(true);
        return;
        ahkr.a(this.this$0, true, "shareToQQ", this.Y);
      }
      catch (Throwable paramDialogInterface)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e(LiteActivity.TAG, 2, "qbShowShareResultDialog ", paramDialogInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aa
 * JD-Core Version:    0.7.0.1
 */