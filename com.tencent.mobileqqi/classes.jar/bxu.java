import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;

public class bxu
  implements View.OnClickListener
{
  public bxu(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (View)paramView.getParent();
    if ((paramView == null) || (paramView.getTag() == null)) {}
    int i;
    do
    {
      return;
      i = ((Integer)paramView.getTag()).intValue();
    } while ((i == 0) && (!PhoneNumLoginImpl.a().a(this.a.b, this.a)));
    this.a.a(i);
    ReportController.b(this.a.b, "CliOper", "", "", "Setting_tab", "Clk_acc_edit_delete", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bxu
 * JD-Core Version:    0.7.0.1
 */