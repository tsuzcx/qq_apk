import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler.Callback;
import com.tencent.mobileqq.statistics.ReportController;

public final class cgq
  implements DialogInterface.OnClickListener
{
  public cgq(boolean paramBoolean, int paramInt, Handler.Callback paramCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Int != 2) {
        break label64;
      }
      ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "2", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsHandler$Callback != null) {
        this.jdField_a_of_type_AndroidOsHandler$Callback.handleMessage(null);
      }
      paramDialogInterface.dismiss();
      return;
      label64:
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "2", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cgq
 * JD-Core Version:    0.7.0.1
 */