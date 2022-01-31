import android.view.View;
import com.tencent.mobileqq.activity.SubAccountSettingActivity;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountDataControll;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class dsh
  implements ActionSheet.OnButtonClickListener
{
  dsh(dsg paramdsg, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    paramView = "";
    if (SubAccountSettingActivity.a(this.jdField_a_of_type_Dsg.a) != null) {
      paramView = SubAccountSettingActivity.a(this.jdField_a_of_type_Dsg.a).subuin;
    }
    ReportController.b(this.jdField_a_of_type_Dsg.a.b, "CliOper", "", paramView, "Bind_account", "Clean_msg_tipslist", 0, 0, "", "", "", "");
    if (SubAccountSettingActivity.a(this.jdField_a_of_type_Dsg.a) != null)
    {
      SubAccountDataControll.a().a(this.jdField_a_of_type_Dsg.a.b, SubAccountSettingActivity.a(this.jdField_a_of_type_Dsg.a).subuin);
      this.jdField_a_of_type_Dsg.a.b(this.jdField_a_of_type_Dsg.a.getString(2131561834));
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dsh
 * JD-Core Version:    0.7.0.1
 */