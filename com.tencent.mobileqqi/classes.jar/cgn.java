import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler.Callback;
import com.tencent.mobileqq.statistics.ReportController;

public final class cgn
  implements DialogInterface.OnClickListener
{
  public cgn(boolean paramBoolean, Handler.Callback paramCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "2", "", "", "");
    }
    if (this.jdField_a_of_type_AndroidOsHandler$Callback != null) {
      this.jdField_a_of_type_AndroidOsHandler$Callback.handleMessage(null);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cgn
 * JD-Core Version:    0.7.0.1
 */