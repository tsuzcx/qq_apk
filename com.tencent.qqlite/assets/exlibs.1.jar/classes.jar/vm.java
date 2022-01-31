import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ShaderAnimLayout;

public class vm
  implements View.OnClickListener
{
  public vm(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.b) {
      return;
    }
    paramView = this.a;
    boolean bool;
    if (!this.a.jdField_a_of_type_Boolean)
    {
      bool = true;
      paramView.jdField_a_of_type_Boolean = bool;
      if (!this.a.jdField_a_of_type_Boolean) {
        break label225;
      }
      AccountManageActivity.a(this.a).setVisibility(8);
      AccountManageActivity.b(this.a).setVisibility(0);
      AccountManageActivity.c(this.a).setText(2131363444);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131427499));
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_AndroidViewView != null)
      {
        ((ShaderAnimLayout)AccountManageActivity.a(this.a, this.a.jdField_a_of_type_AndroidViewView)).d();
        this.a.jdField_a_of_type_AndroidViewView = null;
      }
      this.a.b();
      this.a.a(this.a.jdField_a_of_type_Boolean);
      this.a.b = false;
      AccountManageActivity.a(this.a).postDelayed(new vn(this), 400L);
      ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_acc_edit", 0, 0, "", "", "", "");
      return;
      bool = false;
      break;
      label225:
      AccountManageActivity.d(this.a).setVisibility(0);
      AccountManageActivity.e(this.a).setVisibility(8);
      AccountManageActivity.f(this.a).setText(2131363447);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColorStateList(2131427472));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     vm
 * JD-Core Version:    0.7.0.1
 */