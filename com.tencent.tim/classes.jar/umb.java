import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tim.call.qcall.PstnSessionInfo;

public final class umb
  implements DialogInterface.OnClickListener
{
  public umb(QQAppInterface paramQQAppInterface, Context paramContext, PstnSessionInfo paramPstnSessionInfo, int paramInt, ChatActivityUtils.c paramc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ChatActivityUtils.a(this.val$app, this.val$context, this.b, this.val$from, this.a, false);
    anot.a(this.val$app, "CliOper", "", "", "0X80067FB", "0X80067FB", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     umb
 * JD-Core Version:    0.7.0.1
 */