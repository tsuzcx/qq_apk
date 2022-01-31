import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.VerifyCreditCardIdentityActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.PrivacyDeclareHelper;
import com.tencent.mobileqq.app.QQAppInterface;

public class ehv
  implements DialogInterface.OnClickListener
{
  public ehv(MainAssistObserver paramMainAssistObserver) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent(this.a.a, VerifyCreditCardIdentityActivity.class);
    localIntent.putExtra("reqType", 4);
    localIntent.putExtra("title", this.a.a.getString(2131561842));
    localIntent.putExtra("uin", this.a.a.b.a());
    this.a.a.startActivityForResult(localIntent.putExtra("url", PrivacyDeclareHelper.a(this.a.a)), 2000);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ehv
 * JD-Core Version:    0.7.0.1
 */