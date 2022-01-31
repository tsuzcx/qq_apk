import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopDisbandActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

class bmm
  implements DialogInterface.OnClickListener
{
  bmm(bmk parambmk, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.a(this.jdField_a_of_type_Bmk.a.app, "P_CliOper", "Grp_manage", "", "del_grp", "Clk_know", 0, 0, this.jdField_a_of_type_Bmk.a.b, "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bmm
 * JD-Core Version:    0.7.0.1
 */