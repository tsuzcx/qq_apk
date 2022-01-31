import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class byc
  implements View.OnClickListener
{
  public byc(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.d) {
      return;
    }
    paramView = this.a;
    boolean bool;
    if (!this.a.c)
    {
      bool = true;
      paramView.c = bool;
      if (!this.a.c) {
        break label187;
      }
      AccountManageActivity.a(this.a).setVisibility(8);
      AccountManageActivity.b(this.a).setVisibility(0);
      AccountManageActivity.c(this.a).setText(2131561977);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131362099));
    }
    for (;;)
    {
      this.a.b();
      this.a.a(this.a.c);
      this.a.d = false;
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new byd(this), 400L);
      ReportController.b(this.a.b, "CliOper", "", "", "Setting_tab", "Clk_acc_edit", 0, 0, "", "", "", "");
      return;
      bool = false;
      break;
      label187:
      AccountManageActivity.d(this.a).setVisibility(0);
      AccountManageActivity.e(this.a).setVisibility(8);
      AccountManageActivity.f(this.a).setText(2131562001);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColorStateList(2131362073));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     byc
 * JD-Core Version:    0.7.0.1
 */