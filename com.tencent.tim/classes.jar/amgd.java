import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.richstatus.SignatureEditFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class amgd
  implements DialogInterface.OnClickListener
{
  public amgd(SignatureEditFragment paramSignatureEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.getActivity().finish();
    VasWebviewUtil.reportCommercialDrainage("signature_update", "click_close", "click_close", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amgd
 * JD-Core Version:    0.7.0.1
 */