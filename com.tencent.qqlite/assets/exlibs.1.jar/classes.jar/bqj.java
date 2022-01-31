import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

class bqj
  implements DialogInterface.OnClickListener
{
  bqj(bqh parambqh, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.a(this.jdField_a_of_type_Bqh.a.app, "P_CliOper", "Grp_manage", "", "turn_grp", "Clk_know", 0, 0, this.jdField_a_of_type_Bqh.a.b, "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bqj
 * JD-Core Version:    0.7.0.1
 */