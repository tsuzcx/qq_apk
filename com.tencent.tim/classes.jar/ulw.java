import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ulw
  implements DialogInterface.OnClickListener
{
  public ulw(QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.c paramc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    jkm.a(this.val$app, this.val$context, 2, 12);
    if (this.a != null) {
      this.a.onCancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ulw
 * JD-Core Version:    0.7.0.1
 */