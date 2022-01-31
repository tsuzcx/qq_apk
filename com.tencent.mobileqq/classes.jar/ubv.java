import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ubv
  implements DialogInterface.OnClickListener
{
  ubv(ubt paramubt, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_Ubt.a.app, "P_CliOper", "Grp_manage", "", "turn_grp", "Clk_know", 0, 0, this.jdField_a_of_type_Ubt.a.a, "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ubv
 * JD-Core Version:    0.7.0.1
 */