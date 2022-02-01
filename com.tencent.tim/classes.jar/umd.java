import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

public final class umd
  implements DialogInterface.OnClickListener
{
  public umd(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    jkm.a(this.val$app, this.val$context, 1, 8);
    paramDialogInterface = this.val$app;
    if (this.val$from == 5) {}
    for (paramInt = 2;; paramInt = 3)
    {
      anot.a(paramDialogInterface, "CliOper", "", "", "0X80063FB", "0X80063FB", paramInt, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     umd
 * JD-Core Version:    0.7.0.1
 */