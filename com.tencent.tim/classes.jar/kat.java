import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;

public class kat
  implements DialogInterface.OnClickListener
{
  public kat(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PublicAccountJavascriptInterface.a(this.this$0, this.adl, this.VG, this.VA);
    PublicAccountJavascriptInterface.setLocationPermissionGrant(this.VE, this.VF, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kat
 * JD-Core Version:    0.7.0.1
 */