import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tim.call.qcall.PstnSessionInfo;

public final class ume
  implements DialogInterface.OnClickListener
{
  public ume(QQAppInterface paramQQAppInterface, Context paramContext, PstnSessionInfo paramPstnSessionInfo, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ChatActivityUtils.a(this.val$app, this.val$context, this.b.mUinType, this.b.mPeerUin, this.b.mNickName, this.b.cGF, true, null, true, true, null, "from_internal");
    paramDialogInterface = this.val$app;
    if (this.val$from == 5) {}
    for (paramInt = 2;; paramInt = 3)
    {
      anot.a(paramDialogInterface, "CliOper", "", "", "0X80063FC", "0X80063FC", paramInt, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ume
 * JD-Core Version:    0.7.0.1
 */