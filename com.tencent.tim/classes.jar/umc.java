import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.app.QQAppInterface;

public final class umc
  implements DialogInterface.OnClickListener
{
  public umc(QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.c paramc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    jkm.a(this.val$app, this.val$context, 1, 16);
    if (this.a != null) {
      this.a.aqN();
    }
    anot.a(this.val$app, "CliOper", "", "", "0X80067FC", "0X80067FC", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     umc
 * JD-Core Version:    0.7.0.1
 */