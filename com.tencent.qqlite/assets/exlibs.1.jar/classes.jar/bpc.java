import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.List;

class bpc
  implements View.OnClickListener
{
  bpc(bpa parambpa, String paramString, CheckBox paramCheckBox, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    paramView = (TroopHandler)this.jdField_a_of_type_Bpa.a.app.a(17);
    Object localObject;
    if (paramView != null)
    {
      localObject = new ArrayList();
      ((List)localObject).add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_JavaLangString)));
      paramView.a(Long.parseLong(this.jdField_a_of_type_Bpa.a.i), (List)localObject, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
      localObject = this.jdField_a_of_type_Bpa.a.p;
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label184;
      }
    }
    label184:
    for (paramView = "0";; paramView = "1")
    {
      ReportController.b(this.jdField_a_of_type_Bpa.a.app, "P_CliOper", "Grp_manage", "", "del_mber", "Clk_del", 1, 0, this.jdField_a_of_type_Bpa.a.i, (String)localObject, paramView, "");
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_Bpa.a.k();
      this.jdField_a_of_type_Bpa.a.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bpc
 * JD-Core Version:    0.7.0.1
 */