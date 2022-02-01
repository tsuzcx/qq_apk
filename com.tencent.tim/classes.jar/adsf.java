import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.ark.ArkAppCenter;

class adsf
  implements DialogInterface.OnDismissListener
{
  adsf(adse paramadse, ausj paramausj) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.val$actionSheet.dismiss();
    ArkAppCenter.r("ArkApp.DebugOnlineActivity", String.format("ClearApp actionsheet is closed", new Object[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adsf
 * JD-Core Version:    0.7.0.1
 */