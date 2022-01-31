import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

class bqh
  implements DialogInterface.OnClickListener
{
  bqh(bqg parambqg, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.a(this.jdField_a_of_type_Bqg.a.app, "P_CliOper", "Grp_manage", "", "turn_grp", "Clk_more", 0, 0, this.jdField_a_of_type_Bqg.a.b, "", "", "");
    paramDialogInterface = new Intent(this.jdField_a_of_type_Bqg.a, QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", "http://kf.qq.com/touch/apifaq/120307IVnEni140626N3EZzq.html?platform=15&ADTAG=veda.mobileqq.app&_wv=1027");
    paramDialogInterface.putExtra("webStyle", "noBottomBar");
    this.jdField_a_of_type_Bqg.a.startActivity(paramDialogInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bqh
 * JD-Core Version:    0.7.0.1
 */