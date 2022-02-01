import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.richstatus.SignatureEditFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class amge
  implements DialogInterface.OnClickListener
{
  public amge(SignatureEditFragment paramSignatureEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VasWebviewUtil.reportCommercialDrainage("signature_update", "click_know", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amge
 * JD-Core Version:    0.7.0.1
 */