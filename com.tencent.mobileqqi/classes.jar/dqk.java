import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.List;

class dqk
  implements View.OnClickListener
{
  dqk(dqg paramdqg, CheckBox paramCheckBox, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    paramView = new ArrayList();
    paramView.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_Dqg.a.e)));
    this.jdField_a_of_type_Dqg.a.a.a(Long.parseLong(this.jdField_a_of_type_Dqg.a.c), paramView, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
    paramView = this.jdField_a_of_type_Dqg.a.b;
    String str = this.jdField_a_of_type_Dqg.a.c;
    StringBuilder localStringBuilder = new StringBuilder().append("");
    if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {}
    for (int i = 0;; i = 1)
    {
      ReportController.b(paramView, "P_CliOper", "Grp_mber", "", "manage_grp", "Clk_delmber_never", 0, 0, str, i, "", "");
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dqk
 * JD-Core Version:    0.7.0.1
 */