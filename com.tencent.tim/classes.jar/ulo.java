import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ulo
  implements DialogInterface.OnClickListener
{
  public ulo(ChatActivityUtils.c paramc, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.a != null) {
      this.a.onCancel();
    }
    anot.a(this.val$app, "CliOper", "", "", "0X8006405", "0X8006405", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ulo
 * JD-Core Version:    0.7.0.1
 */