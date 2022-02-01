import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ulu
  implements DialogInterface.OnClickListener
{
  public ulu(QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.c paramc, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    jkm.a(this.val$app, this.val$context, 2, 12);
    if (this.a != null) {
      this.a.onCancel();
    }
    paramDialogInterface = this.val$app;
    if (this.val$from == 6) {}
    for (paramInt = 1;; paramInt = 4)
    {
      anot.a(paramDialogInterface, "CliOper", "", "", "0X80063F9", "0X80063F9", paramInt, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ulu
 * JD-Core Version:    0.7.0.1
 */