import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.qrcode.ipc.ScannerParams;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import mqq.app.AppActivity;

class rwb
  implements DialogInterface.OnClickListener
{
  rwb(rvz paramrvz, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.aCq.toLowerCase();
    if (paramDialogInterface.startsWith("www.")) {
      paramDialogInterface = "http://" + this.aCq;
    }
    for (;;)
    {
      Intent localIntent = new Intent(this.a.a, QQBrowserDelegationActivity.class);
      localIntent.putExtra("url", paramDialogInterface);
      localIntent.putExtra("param_force_internal_browser", true);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("fromQrcode", true);
      localIntent.putExtra("injectrecommend", false);
      localIntent.putExtra("big_brother_source_key", "biz_src_jc_sacan_qr");
      this.a.a.startActivity(localIntent);
      if (this.a.b.aKi) {
        this.a.a.finish();
      }
      if (this.a.b.aKf) {
        this.a.a.finish();
      }
      return;
      if (paramDialogInterface.startsWith("https:")) {
        paramDialogInterface = "https" + this.aCq.substring(5);
      } else if (paramDialogInterface.startsWith("http:")) {
        paramDialogInterface = "http" + this.aCq.substring(4);
      } else {
        paramDialogInterface = this.aCq;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rwb
 * JD-Core Version:    0.7.0.1
 */