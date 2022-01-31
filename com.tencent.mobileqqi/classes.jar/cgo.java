import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Handler.Callback;
import com.tencent.mobileqq.statistics.ReportController;

public final class cgo
  implements DialogInterface.OnCancelListener
{
  public cgo(boolean paramBoolean, Handler.Callback paramCallback) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Boolean) {
      ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "3", "", "", "");
    }
    if (this.jdField_a_of_type_AndroidOsHandler$Callback != null) {
      this.jdField_a_of_type_AndroidOsHandler$Callback.handleMessage(null);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cgo
 * JD-Core Version:    0.7.0.1
 */