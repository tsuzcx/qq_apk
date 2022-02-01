import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ulr
  implements DialogInterface.OnClickListener
{
  public ulr(QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    jkm.a(this.val$app, this.val$context, 2, 16);
    anot.a(this.val$app, "CliOper", "", "", "0X80067FC", "0X80067FC", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ulr
 * JD-Core Version:    0.7.0.1
 */