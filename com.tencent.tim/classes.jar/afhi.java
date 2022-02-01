import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

final class afhi
  implements DialogInterface.OnClickListener
{
  afhi(QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (paramInt == 1) {
      aqrf.a(this.val$app, this.val$context, "mvip.n.a.bqsc_aio", 3, "1450000516", "CJCLUBT", this.val$app.getApp().getString(2131720669), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afhi
 * JD-Core Version:    0.7.0.1
 */