import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;

public class kap
  implements DialogInterface.OnClickListener
{
  public kap(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, String paramString1, long paramLong, String paramString2, String paramString3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PublicAccountJavascriptInterface.a(this.this$0, this.VA, this.ri);
    PublicAccountJavascriptInterface.setLocationPermissionGrant(this.VE, this.VF, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kap
 * JD-Core Version:    0.7.0.1
 */