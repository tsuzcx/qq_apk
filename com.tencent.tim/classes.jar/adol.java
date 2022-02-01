import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler.1;
import com.tencent.mobileqq.ark.ArkAppCenter;

public class adol
  implements DialogInterface.OnClickListener
{
  public adol(ArkAppSchemeCenter.TelSchemeHandler.1 param1, aqju paramaqju) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.a.val$phone));
    ArkAppCenter.dn(paramDialogInterface);
    BaseActivity.sTopActivity.startActivity(paramDialogInterface);
    if ((this.al != null) && (this.al.isShowing())) {}
    try
    {
      this.al.dismiss();
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adol
 * JD-Core Version:    0.7.0.1
 */