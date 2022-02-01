import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.statistics.ReportController;

class eri
  implements DialogInterface.OnClickListener
{
  eri(erh paramerh) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.f();
    paramDialogInterface.dismiss();
    ReportController.b(this.a.a.b, "CliOper", "", "", "Multi_call", "Clk_join_discuss_next", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eri
 * JD-Core Version:    0.7.0.1
 */