import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.ark.ArkAppCenter;

class adsi
  implements DialogInterface.OnDismissListener
{
  adsi(adsh paramadsh, ausj paramausj) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.val$actionSheet.dismiss();
    ArkAppCenter.r("ArkApp.DebugOnlineActivity", String.format("ClearData actionsheet is closed", new Object[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adsi
 * JD-Core Version:    0.7.0.1
 */