import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.statistics.ReportController;

class cny
  implements DialogInterface.OnClickListener
{
  cny(cnx paramcnx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.d();
    paramDialogInterface.dismiss();
    ReportController.b(this.a.a.app, "CliOper", "", "", "Multi_call", "Clk_join_discuss_next", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cny
 * JD-Core Version:    0.7.0.1
 */