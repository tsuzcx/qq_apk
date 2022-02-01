import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.qrcode.activity.QRCardActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;

public class rub
  implements DialogInterface.OnClickListener
{
  public rub(QRCardActivity paramQRCardActivity, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.aCq.toLowerCase();
    if (paramDialogInterface.startsWith("www.")) {
      paramDialogInterface = "http://" + this.aCq;
    }
    for (;;)
    {
      Intent localIntent = new Intent(this.this$0, QQBrowserDelegationActivity.class);
      localIntent.putExtra("url", paramDialogInterface);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("injectrecommend", false);
      this.this$0.startActivity(localIntent);
      return;
      if (paramDialogInterface.startsWith("https:")) {
        paramDialogInterface = "https" + this.aCq.substring(5);
      } else if (paramDialogInterface.startsWith("http:")) {
        paramDialogInterface = "http" + this.aCq.substring(4);
      } else {
        paramDialogInterface = "http://" + this.aCq;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rub
 * JD-Core Version:    0.7.0.1
 */