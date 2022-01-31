import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;

public class vf
  implements View.OnClickListener
{
  public vf(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (View)paramView.getParent().getParent();
    if ((paramView == null) || (paramView.getTag() == null)) {}
    int i;
    do
    {
      return;
      i = ((Integer)paramView.getTag()).intValue();
    } while ((i == 0) && (!PhoneNumLoginImpl.a().a(this.a.app, this.a)));
    this.a.a(i);
    ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_acc_edit_delete", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     vf
 * JD-Core Version:    0.7.0.1
 */