import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.VChatActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class bkq
  implements DialogInterface.OnClickListener
{
  public bkq(VChatActivity paramVChatActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(null, "CliOper", "", "", "AV_module", "AV_module_install", 0, 0, "", "", "", "");
    paramDialogInterface.dismiss();
    VChatActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bkq
 * JD-Core Version:    0.7.0.1
 */