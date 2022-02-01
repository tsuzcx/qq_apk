import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.SubAccountSettingActivity;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.SubAccountAssistantManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class dmq
  implements ActionSheet.OnButtonClickListener
{
  dmq(dmo paramdmo, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while ((!this.jdField_a_of_type_Dmo.a.f()) || ((SubAccountSettingActivity.a(this.jdField_a_of_type_Dmo.a) != null) && (TextUtils.isEmpty(SubAccountSettingActivity.a(this.jdField_a_of_type_Dmo.a).subuin))));
    this.jdField_a_of_type_Dmo.a.d();
    SubAccountAssistantManager.a().a(this.jdField_a_of_type_Dmo.a.b, SubAccountSettingActivity.a(this.jdField_a_of_type_Dmo.a).subuin);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dmq
 * JD-Core Version:    0.7.0.1
 */