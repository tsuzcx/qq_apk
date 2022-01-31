import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.PrivacyDeclareHelper;
import com.tencent.mobileqq.app.QQAppInterface;

public class czi
  implements DialogInterface.OnClickListener
{
  public czi(LoginActivity paramLoginActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
    localIntent.putExtra("reqType", 4);
    localIntent.putExtra("title", this.a.getString(2131561842));
    localIntent.putExtra("uin", this.a.b.a());
    this.a.startActivity(localIntent.putExtra("url", PrivacyDeclareHelper.a(this.a)));
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     czi
 * JD-Core Version:    0.7.0.1
 */